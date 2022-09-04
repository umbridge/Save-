package com.hashedin.huTaxer.Services;

import com.hashedin.huTaxer.Exception.ExistingUserException;
import com.hashedin.huTaxer.Exception.SamePasswordException;
import com.hashedin.huTaxer.Exception.UserNotFoundException;
import com.hashedin.huTaxer.Modal.*;
import com.hashedin.huTaxer.Repository.UserRepository;
import com.hashedin.huTaxer.util.LimitAndName;
import com.hashedin.huTaxer.util.SuggestionDifference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final int[] newRegimeTaxAmts = {0, 12500, 37500, 75000, 125000, 187500};
    private final int[] oldRegimeTaxAmtsBelow60 = {0, 12500, 62500, 112500, 187500, 262500};
    private final int[] oldRegimeTaxAmtsBtw60_80 = {0, 10000, 60000, 110000, 185000, 260000};
    private final int[] oldRegimeTaxAmtsAbove80 = {0, 0, 50000, 100000, 175000, 250000};

    private final double[] newRegimeTaxFactor = {0, 0.1, 0.15, 0.2, 0.25, 0.3};
    private final double[] oldRegimeTaxFactor = {0, 0.2, 0.2, 0.3, 0.3, 0.3};

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User addNewUser(User user) throws ExistingUserException {
        if (user == null) {
            throw new ExistingUserException("User is null ");
        }
        if (userRepository.findByUserName(user.getUserName()) != null) {
            throw new ExistingUserException("User already registered , Please signup with different user_Name");
        }
        if (userRepository.findByUserEmail(user.getUserEmail()) != null) {
            throw new ExistingUserException("Email already registerd , Please SignUp with different Email Id");
        }
        return userRepository.save(user);
    }

    public User getUserbyEmailId(String emailId) throws UserNotFoundException {
        if (emailId == "null") throw new UserNotFoundException("Email id is null");
        User user = userRepository.findByUserEmail(emailId);
        if (user == null) {
            throw new UserNotFoundException("user not found with EmailId = " + emailId);
        }
        return user;
    }

    public User updateExistingUser(User user) throws UserNotFoundException {
        User currentUser = userRepository.findByUserEmail(user.getUserEmail());
        if (currentUser == null) {
            throw new UserNotFoundException("user not found with EmailId = " + user.getUserEmail());
        }


        if (user.getUserDeductions() != null) {
            currentUser.setUserDeductions(user.getUserDeductions());
        }
        if (user.getUserDetails() != null) {
            currentUser.setUserDetails(user.getUserDetails());
        }
        userRepository.save(currentUser);
        return currentUser;
    }

    public User setNewPassword(String userEmail, String userPassword) throws UserNotFoundException, SamePasswordException {
        if (userPassword == null || userEmail == null) throw new UserNotFoundException("Email/Password  is null");
        User currentUser = userRepository.findByUserEmail(userEmail);

        if (currentUser == null) {
            throw new UserNotFoundException("user not found with EmailId = " + userEmail);
        }
        if (currentUser.getUserPassword() == userPassword) {
            throw new SamePasswordException("Cannot have new password same as previous password");
        }
        currentUser.setUserPassword(userPassword);
        return userRepository.save(currentUser);
    }


    public Map<Object, Object> calculateTaxes(String email) throws UserNotFoundException {
        if (email == null) throw new UserNotFoundException("Email is Null Please try again");
        double newTaxRegime;
        double oldTaxRegime;
        User user = userRepository.findByUserEmail(email);
        if (user == null) {
            throw new UserNotFoundException("User Not found with Email id = " + email);
        }
        double grossSalary = calculateGrossSalary(user);
        long extraTaxSaved = 0;

        Map<Object, Object> map = new HashMap();

        double deductions = calculateDeduction(grossSalary, user);
        map.put("Deductions", deductions);
        map.put("GrossSalary", grossSalary);
        double taxableAmount = grossSalary - deductions;

        int age = user.getUserDetails().getAge();
        if(age > 80) {
            oldTaxRegime = calculateTax(user, taxableAmount, oldRegimeTaxAmtsAbove80, oldRegimeTaxFactor);
        }else if(age > 60) {
            oldTaxRegime = calculateTax(user, taxableAmount, oldRegimeTaxAmtsBtw60_80, oldRegimeTaxFactor);
        }else {
            oldTaxRegime = calculateTax(user, taxableAmount, oldRegimeTaxAmtsBelow60, oldRegimeTaxFactor);
        }

        newTaxRegime = calculateTax(user, grossSalary, newRegimeTaxAmts, newRegimeTaxFactor);

        extraTaxSaved = (long) Math.min(oldTaxRegime, newTaxRegime) - user.getUserDetails().getTaxSaved();

        user.getUserDetails().setTaxSaved((long) Math.min(oldTaxRegime, newTaxRegime));
        map.put("extraTaxSave", extraTaxSaved);

        map.put((Object) "OldTaxRegime", (int) oldTaxRegime);
        map.put((Object) "NewTaxRegime", (int) newTaxRegime);
        map.put("EducationCessOldRegime", (int) (oldTaxRegime * 0.04));
        map.put("EducationCessNewRegime", (int) (newTaxRegime * 0.04));
        map.put("SurchargeOldRegime", (int) (getSurcharge(grossSalary, oldTaxRegime)));
        map.put("SurchargeNewRegime", (int) getSurcharge(grossSalary, newTaxRegime));
        map.put("FinalOldTax", oldTaxRegime * 1.04);
        map.put("FinalNewRegimeTax", newTaxRegime * 1.04);


        ArrayList<String> m = new ArrayList<>();

        if (taxableAmount > 500000) {
            PriorityQueue<SuggestionDifference> pq = getSuggestion(user);

            while (!pq.isEmpty()) {
                String name = pq.peek().name;
                int value = pq.peek().value;
                m.add("Additional Exemption Of \u20B9" + value + " can be claimed under " + name);
                pq.poll();
            }

            map.put("suggestion", m);
        } else {
            m.add("No Suggestion Needed ,Taxable Amount is less than 500000");
            map.put("suggestion", m);
        }


        return map;

    }

    public double getSurcharge(double grossSalary, double incomeTax) {

        if(grossSalary > 50000000) {
            return 0.37 * incomeTax;
        }else if(grossSalary > 20000000) {
            return 0.25 * incomeTax;
        }else if(grossSalary > 10000000) {
            return 0.15 * incomeTax;
        }else if(grossSalary > 5000000) {
            return 0.1 * incomeTax;
        }

        return 0;
    }

    public PriorityQueue<SuggestionDifference> getSuggestion(User user) {
        PriorityQueue<SuggestionDifference> priorityQueue = new PriorityQueue<>((a, b) -> b.value - a.value);
        LimitAndName limits = new LimitAndName();
        UserDeductions userDeductions = user.getUserDeductions();
        Section10 section10 = userDeductions.getSection10();
        Section80C section80C = userDeductions.getSection80C();
        Section24 section24 = userDeductions.getSection24();
        //SEction 80c:
        int section80cdiff = (int) (limits.section80cMax - calculateSection80c(section80C, user.getUserDetails().getBasicSalary()));
        if (section80cdiff > 0) {
            priorityQueue.add(new SuggestionDifference("Section 80C", section80cdiff));
        }

        //Section10
        int section24diff = (int) (limits.section24Max - calculateSection24(section24));
        if (section24diff > 0) {
            priorityQueue.add(new SuggestionDifference("Section 24", section24diff));
        }

        int ltaDiff = (int) (limits.lta - section10.getLta());
        if (ltaDiff > 0) {
            priorityQueue.add(new SuggestionDifference(limits.ltaname, ltaDiff));
        }

        int medicalInsurancediff = (int) (limits.medicalInsurance - userDeductions.getMedicalInsurance());
        if (medicalInsurancediff > 0) {
            priorityQueue.add(new SuggestionDifference(limits.mediacalinsuranceName, medicalInsurancediff));
        }
        int savingaccntDiff = (int) (limits.savingAccntamt - userDeductions.getSavingAccountInterest());
        if (savingaccntDiff > 0) {
            priorityQueue.add(new SuggestionDifference(limits.savingAccntName, savingaccntDiff));
        }

        int donationDiff = (int) (calculateGrossSalary(user) * limits.donationFactor - user.getUserDeductions().getCharityDonation());
        if (donationDiff > 0) {
            priorityQueue.add(new SuggestionDifference(limits.Donationname, donationDiff));
        }


        return priorityQueue;
    }


    private double calculateGrossSalary(User user) {
        UserDetails userDetails = user.getUserDetails();
        if (userDetails == null) return 0;
        long basicSalary = user.getUserDetails().getBasicSalary();
        long rentalIncome = user.getUserDetails().getRentalIncome();
        long capitalGains = user.getUserDetails().getCapitalGains();
        long businessIncome = user.getUserDetails().getBusinessIncome();
        long otherIncome = user.getUserDetails().getOtherIncome();
        return basicSalary + rentalIncome + capitalGains + businessIncome + otherIncome;
    }

    //deduction , grosssalary ,
    private double calculateTax(User user, double grossIncome, int taxslab[], double taxFactor[]) {

        /*
    private final int[] newRegimeTaxAmts = {0, 12500, 37500, 75000, 125000, 187500};
    private final int[] oldRegimeTaxAmts = {0, 12500, 62500, 112500, 187500, 262500};

    private final double[] newRegimeTaxFactor = {0, 0.1, 0.15, 0.2, 0.25, 0.3};
    private final double[] oldRegimeTaxFactor = {0, 0.2, 0.2, 0.3, 0.3, 0.3};
        */



        double taxableAmount;

        if (grossIncome < 500000) return 0;

        else if (grossIncome < 750000) {

            taxableAmount = taxslab[1];
            taxableAmount += (grossIncome - 500000) * taxFactor[1];

        } else if (grossIncome < 1000000) {
            taxableAmount = taxslab[2];
            taxableAmount += (grossIncome - 750000) * taxFactor[2];
        } else if (grossIncome < 1250000) {
            taxableAmount = taxslab[3];
            taxableAmount += (grossIncome - 1000000) * taxFactor[3];

        } else if (grossIncome < 1500000) {
            taxableAmount = taxslab[4];
            taxableAmount += (grossIncome - 1250000) * taxFactor[4];

        } else {

            taxableAmount = taxslab[5];
            taxableAmount += (grossIncome - 1500000) * taxFactor[5];

        }
        return taxableAmount;
    }

    private double calculateSection10(Section10 section10, long basicSalary) {
        double deduction10 = 0;

        if (section10 == null) return deduction10;

        double totalhra = section10.getHra();
        totalhra = totalhra = Math.min(totalhra, Math.max(0, section10.getActualRentPaid() - (0.1 * basicSalary)));


        double val = section10.isMetro() ? (0.5 * basicSalary) : (0.4 * basicSalary);

        totalhra = Math.min(totalhra, val);

        deduction10 += totalhra;

        //LTA
        deduction10 += Math.min(section10.getLta(), 50000);

        //Education , Other Repay , HOstel Allowance
        deduction10 += section10.getChildEducationAllowance() + section10.getOtherRepay() + section10.getChildHostelAllowance();

        return deduction10;
    }

    private double calculateSection80c(Section80C section80C, long basicSalary) {
        double deduction80c = 0;

        if (section80C == null) return deduction80c;

        //PPF
        deduction80c += section80C.getPpf();

        //EPF(employee)
        deduction80c += Math.min(basicSalary * (0.12), section80C.getEmployeeEpfContri());

        //LIC , ulip , tution Fees , NPS_80C
        deduction80c += section80C.getLic() + section80C.getUlip() + section80C.getNps_80c();

        deduction80c += Math.min(section80C.getTutionFees(), 150000);
        //nsc , FD , sukanaya yojna , elss
        deduction80c += section80C.getNsc() + section80C.getFd() + section80C.getSsy() + section80C.getElss();

        //HomeLoanPrincipal
        deduction80c += section80C.getHomeLoanPrincipal();

        deduction80c = Math.min(deduction80c, 150000);

        return deduction80c;
    }

    private double calculateSection24(Section24 section24) {
        double lossFromHouseProperty = 0;

        if (section24 == null) return lossFromHouseProperty;

        lossFromHouseProperty = (section24.getRent() * 0.7) - (section24.getPropertyTax() + section24.getInterest());

        if (lossFromHouseProperty > 0 && lossFromHouseProperty <= 200000) {
            return lossFromHouseProperty;
        }
        return 0;
    }

    private double calculateDeduction(double grossIncome, User user) {
        double totalDeductions = 50000; // standard deduction

        double deduction80c = 0, deduction10 = 0, deduction24 = 0;

        UserDeductions userDeductions = user.getUserDeductions();
        if (userDeductions == null) return totalDeductions;

        Section10 section10 = userDeductions.getSection10();
        Section80C section80C = userDeductions.getSection80C();
        Section24 section24 = userDeductions.getSection24();

        long basicSalary = user.getUserDetails().getBasicSalary();

        totalDeductions += calculateSection10(section10, basicSalary) + calculateSection24(section24) + calculateSection80c(section80C, basicSalary);

        //Employer EPF
        totalDeductions += Math.min(user.getUserDetails().getBasicSalary() * (0.0367), userDeductions.getEmployerEpfContri());

        //AdditionNPS
        totalDeductions += Math.min(userDeductions.getAdditionNps(), 50000);

        //EmployerNpsContri
        totalDeductions += Math.min(userDeductions.getEmployerNpsContri(), user.getUserDetails().getBasicSalary() * 0.1);

        //Medical Insurance
        totalDeductions += Math.min(userDeductions.getMedicalInsurance(), 100000);

        //Education Loan Interest
        totalDeductions += Math.min(userDeductions.getEducationLoanInterest(), 50000);


        //Home Loan Interest
        totalDeductions += Math.min(userDeductions.getHomeLoanInterest(), 50000);

        //Saving Account Interst
        totalDeductions += Math.min(userDeductions.getSavingAccountInterest(), 10000);

        //Charity Donation
        totalDeductions += Math.min(calculateGrossSalary(user) * 0.1, userDeductions.getCharityDonation());


        return totalDeductions;

    }


    public String deleteAllUsers() {
        userRepository.deleteAll();
        return "Successfully Deleted All Records";
    }

    public String deleteSingleUser(String email) throws UserNotFoundException {
        User user = userRepository.findByUserEmail(email);
        if (user == null) {
            throw new UserNotFoundException("user not found with EmailId = " + user.getUserEmail());

        }
        userRepository.delete(user);
        return "User Deleted from Records";
    }

    public long getCountOfUsers() {
        return userRepository.count();
    }
}

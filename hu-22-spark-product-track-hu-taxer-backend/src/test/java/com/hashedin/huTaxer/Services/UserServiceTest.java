package com.hashedin.huTaxer.Services;

import com.hashedin.huTaxer.Exception.ExistingUserException;
import com.hashedin.huTaxer.Exception.SamePasswordException;
import com.hashedin.huTaxer.Exception.UserNotFoundException;
import com.hashedin.huTaxer.Modal.Section10;
import com.hashedin.huTaxer.Modal.Section24;
import com.hashedin.huTaxer.Modal.Section80C;
import com.hashedin.huTaxer.Modal.User;
import com.hashedin.huTaxer.Modal.UserDeductions;
import com.hashedin.huTaxer.Modal.UserDetails;
import com.hashedin.huTaxer.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    void setUp() {
        this.userService = new UserService(this.userRepository);
    }

    @Test
    void getUsers() {
        userService.getUsers();
//            verify(userRepository).findAll();
    }

    /**
     * Method under test: {@link UserService#getUsers()}
     */
    @Test
    void testGetUsers() {
        ArrayList<User> userList = new ArrayList<>();
        when(this.userRepository.findAll()).thenReturn(userList);
        List<User> actualUsers = this.userService.getUsers();
        assertSame(userList, actualUsers);
        assertTrue(actualUsers.isEmpty());
        verify(this.userRepository).findAll();
    }

    /**
     * Method under test: {@link UserService#addNewUser(User)}
     */
    @Test
    void testAddNewUser() throws ExistingUserException {
        Section10 section10 = new Section10();
        section10.setActualRentPaid(1L);
        section10.setChildEducationAllowance(1L);
        section10.setChildHostelAllowance(1L);
        section10.setHra(1L);
        section10.setLta(1L);
        section10.setMetro(true);
        section10.setOtherRepay(1L);
        section10.setSection10id(1L);

        Section24 section24 = new Section24();
        section24.setInterest(1L);
        section24.setPropertyTax(1L);
        section24.setRent(1L);
        section24.setSection24id(1L);

        Section80C section80C = new Section80C();
        section80C.setElss(1L);
        section80C.setEmployeeEpfContri(1L);
        section80C.setFd(1L);
        section80C.setHomeLoanPrincipal(1L);
        section80C.setLic(1L);
        section80C.setNps_80c(1L);
        section80C.setNsc(1L);
        section80C.setPpf(1L);
        section80C.setSection80cid(1L);
        section80C.setSsy(1L);
        section80C.setTutionFees(1L);
        section80C.setUlip(1L);

        UserDeductions userDeductions = new UserDeductions();
        userDeductions.setAdditionNps(1L);
        userDeductions.setCharityDonation(1L);
        userDeductions.setDeductionid(1L);
        userDeductions.setEducationLoanInterest(1L);
        userDeductions.setEmployerEpfContri(1L);
        userDeductions.setEmployerNpsContri(1L);
        userDeductions.setHomeLoanInterest(1L);
        userDeductions.setMedicalInsurance(1L);
        userDeductions.setSavingAccountInterest(3L);
        userDeductions.setSection10(section10);
        userDeductions.setSection24(section24);
        userDeductions.setSection80C(section80C);

        UserDetails userDetails = new UserDetails();
        userDetails.setAge(1);
        userDetails.setBasicSalary(1L);
        userDetails.setBusinessIncome(1L);
        userDetails.setCapitalGains(1L);
        userDetails.setOtherIncome(1L);
        userDetails.setRentalIncome(1L);
        userDetails.setSex("Sex");
        userDetails.setTaxSaved(1L);
        userDetails.setUserDetailid(1);
        userDetails.setYear(1);

        User user = new User();
        user.setUserCompany("User Company");
        user.setUserDeductions(userDeductions);
        user.setUserDetails(userDetails);
        user.setUserEmail("jane.doe@example.org");
        user.setUserFirstName("Jane");
        user.setUserId(123);
        user.setUserLastName("Doe");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        Section10 section101 = new Section10();
        section101.setActualRentPaid(1L);
        section101.setChildEducationAllowance(1L);
        section101.setChildHostelAllowance(1L);
        section101.setHra(1L);
        section101.setLta(1L);
        section101.setMetro(true);
        section101.setOtherRepay(1L);
        section101.setSection10id(1L);

        Section24 section241 = new Section24();
        section241.setInterest(1L);
        section241.setPropertyTax(1L);
        section241.setRent(1L);
        section241.setSection24id(1L);

        Section80C section80C1 = new Section80C();
        section80C1.setElss(1L);
        section80C1.setEmployeeEpfContri(1L);
        section80C1.setFd(1L);
        section80C1.setHomeLoanPrincipal(1L);
        section80C1.setLic(1L);
        section80C1.setNps_80c(1L);
        section80C1.setNsc(1L);
        section80C1.setPpf(1L);
        section80C1.setSection80cid(1L);
        section80C1.setSsy(1L);
        section80C1.setTutionFees(1L);
        section80C1.setUlip(1L);

        UserDeductions userDeductions1 = new UserDeductions();
        userDeductions1.setAdditionNps(1L);
        userDeductions1.setCharityDonation(1L);
        userDeductions1.setDeductionid(1L);
        userDeductions1.setEducationLoanInterest(1L);
        userDeductions1.setEmployerEpfContri(1L);
        userDeductions1.setEmployerNpsContri(1L);
        userDeductions1.setHomeLoanInterest(1L);
        userDeductions1.setMedicalInsurance(1L);
        userDeductions1.setSavingAccountInterest(3L);
        userDeductions1.setSection10(section101);
        userDeductions1.setSection24(section241);
        userDeductions1.setSection80C(section80C1);

        UserDetails userDetails1 = new UserDetails();
        userDetails1.setAge(1);
        userDetails1.setBasicSalary(1L);
        userDetails1.setBusinessIncome(1L);
        userDetails1.setCapitalGains(1L);
        userDetails1.setOtherIncome(1L);
        userDetails1.setRentalIncome(1L);
        userDetails1.setSex("Sex");
        userDetails1.setTaxSaved(1L);
        userDetails1.setUserDetailid(1);
        userDetails1.setYear(1);

        User user1 = new User();
        user1.setUserCompany("User Company");
        user1.setUserDeductions(userDeductions1);
        user1.setUserDetails(userDetails1);
        user1.setUserEmail("jane.doe@example.org");
        user1.setUserFirstName("Jane");
        user1.setUserId(123);
        user1.setUserLastName("Doe");
        user1.setUserName("janedoe");
        user1.setUserPassword("iloveyou");

        Section10 section102 = new Section10();
        section102.setActualRentPaid(1L);
        section102.setChildEducationAllowance(1L);
        section102.setChildHostelAllowance(1L);
        section102.setHra(1L);
        section102.setLta(1L);
        section102.setMetro(true);
        section102.setOtherRepay(1L);
        section102.setSection10id(1L);

        Section24 section242 = new Section24();
        section242.setInterest(1L);
        section242.setPropertyTax(1L);
        section242.setRent(1L);
        section242.setSection24id(1L);

        Section80C section80C2 = new Section80C();
        section80C2.setElss(1L);
        section80C2.setEmployeeEpfContri(1L);
        section80C2.setFd(1L);
        section80C2.setHomeLoanPrincipal(1L);
        section80C2.setLic(1L);
        section80C2.setNps_80c(1L);
        section80C2.setNsc(1L);
        section80C2.setPpf(1L);
        section80C2.setSection80cid(1L);
        section80C2.setSsy(1L);
        section80C2.setTutionFees(1L);
        section80C2.setUlip(1L);

        UserDeductions userDeductions2 = new UserDeductions();
        userDeductions2.setAdditionNps(1L);
        userDeductions2.setCharityDonation(1L);
        userDeductions2.setDeductionid(1L);
        userDeductions2.setEducationLoanInterest(1L);
        userDeductions2.setEmployerEpfContri(1L);
        userDeductions2.setEmployerNpsContri(1L);
        userDeductions2.setHomeLoanInterest(1L);
        userDeductions2.setMedicalInsurance(1L);
        userDeductions2.setSavingAccountInterest(3L);
        userDeductions2.setSection10(section102);
        userDeductions2.setSection24(section242);
        userDeductions2.setSection80C(section80C2);

        UserDetails userDetails2 = new UserDetails();
        userDetails2.setAge(1);
        userDetails2.setBasicSalary(1L);
        userDetails2.setBusinessIncome(1L);
        userDetails2.setCapitalGains(1L);
        userDetails2.setOtherIncome(1L);
        userDetails2.setRentalIncome(1L);
        userDetails2.setSex("Sex");
        userDetails2.setTaxSaved(1L);
        userDetails2.setUserDetailid(1);
        userDetails2.setYear(1);

        User user2 = new User();
        user2.setUserCompany("User Company");
        user2.setUserDeductions(userDeductions2);
        user2.setUserDetails(userDetails2);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserFirstName("Jane");
        user2.setUserId(123);
        user2.setUserLastName("Doe");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");
        when(this.userRepository.findByUserEmail((String) any())).thenReturn(user);
        when(this.userRepository.findByUserName((String) any())).thenReturn(user1);
        when(this.userRepository.save((User) any())).thenReturn(user2);

        Section10 section103 = new Section10();
        section103.setActualRentPaid(1L);
        section103.setChildEducationAllowance(1L);
        section103.setChildHostelAllowance(1L);
        section103.setHra(1L);
        section103.setLta(1L);
        section103.setMetro(true);
        section103.setOtherRepay(1L);
        section103.setSection10id(1L);

        Section24 section243 = new Section24();
        section243.setInterest(1L);
        section243.setPropertyTax(1L);
        section243.setRent(1L);
        section243.setSection24id(1L);

        Section80C section80C3 = new Section80C();
        section80C3.setElss(1L);
        section80C3.setEmployeeEpfContri(1L);
        section80C3.setFd(1L);
        section80C3.setHomeLoanPrincipal(1L);
        section80C3.setLic(1L);
        section80C3.setNps_80c(1L);
        section80C3.setNsc(1L);
        section80C3.setPpf(1L);
        section80C3.setSection80cid(1L);
        section80C3.setSsy(1L);
        section80C3.setTutionFees(1L);
        section80C3.setUlip(1L);

        UserDeductions userDeductions3 = new UserDeductions();
        userDeductions3.setAdditionNps(1L);
        userDeductions3.setCharityDonation(1L);
        userDeductions3.setDeductionid(1L);
        userDeductions3.setEducationLoanInterest(1L);
        userDeductions3.setEmployerEpfContri(1L);
        userDeductions3.setEmployerNpsContri(1L);
        userDeductions3.setHomeLoanInterest(1L);
        userDeductions3.setMedicalInsurance(1L);
        userDeductions3.setSavingAccountInterest(3L);
        userDeductions3.setSection10(section103);
        userDeductions3.setSection24(section243);
        userDeductions3.setSection80C(section80C3);

        UserDetails userDetails3 = new UserDetails();
        userDetails3.setAge(1);
        userDetails3.setBasicSalary(1L);
        userDetails3.setBusinessIncome(1L);
        userDetails3.setCapitalGains(1L);
        userDetails3.setOtherIncome(1L);
        userDetails3.setRentalIncome(1L);
        userDetails3.setSex("Sex");
        userDetails3.setTaxSaved(1L);
        userDetails3.setUserDetailid(1);
        userDetails3.setYear(1);

        User user3 = new User();
        user3.setUserCompany("User Company");
        user3.setUserDeductions(userDeductions3);
        user3.setUserDetails(userDetails3);
        user3.setUserEmail("jane.doe@example.org");
        user3.setUserFirstName("Jane");
        user3.setUserId(123);
        user3.setUserLastName("Doe");
        user3.setUserName("janedoe");
        user3.setUserPassword("iloveyou");
        assertThrows(ExistingUserException.class, () -> this.userService.addNewUser(user3));
        verify(this.userRepository).findByUserName((String) any());
    }

    /**
     * Method under test: {@link UserService#getUserbyEmailId(String)}
     */
    @Test
    void testGetUserbyEmailId() throws UserNotFoundException {
        Section10 section10 = new Section10();
        section10.setActualRentPaid(1L);
        section10.setChildEducationAllowance(1L);
        section10.setChildHostelAllowance(1L);
        section10.setHra(1L);
        section10.setLta(1L);
        section10.setMetro(true);
        section10.setOtherRepay(1L);
        section10.setSection10id(1L);

        Section24 section24 = new Section24();
        section24.setInterest(1L);
        section24.setPropertyTax(1L);
        section24.setRent(1L);
        section24.setSection24id(1L);

        Section80C section80C = new Section80C();
        section80C.setElss(1L);
        section80C.setEmployeeEpfContri(1L);
        section80C.setFd(1L);
        section80C.setHomeLoanPrincipal(1L);
        section80C.setLic(1L);
        section80C.setNps_80c(1L);
        section80C.setNsc(1L);
        section80C.setPpf(1L);
        section80C.setSection80cid(1L);
        section80C.setSsy(1L);
        section80C.setTutionFees(1L);
        section80C.setUlip(1L);

        UserDeductions userDeductions = new UserDeductions();
        userDeductions.setAdditionNps(1L);
        userDeductions.setCharityDonation(1L);
        userDeductions.setDeductionid(1L);
        userDeductions.setEducationLoanInterest(1L);
        userDeductions.setEmployerEpfContri(1L);
        userDeductions.setEmployerNpsContri(1L);
        userDeductions.setHomeLoanInterest(1L);
        userDeductions.setMedicalInsurance(1L);
        userDeductions.setSavingAccountInterest(3L);
        userDeductions.setSection10(section10);
        userDeductions.setSection24(section24);
        userDeductions.setSection80C(section80C);

        UserDetails userDetails = new UserDetails();
        userDetails.setAge(1);
        userDetails.setBasicSalary(1L);
        userDetails.setBusinessIncome(1L);
        userDetails.setCapitalGains(1L);
        userDetails.setOtherIncome(1L);
        userDetails.setRentalIncome(1L);
        userDetails.setSex("Sex");
        userDetails.setTaxSaved(1L);
        userDetails.setUserDetailid(1);
        userDetails.setYear(1);

        User user = new User();
        user.setUserCompany("User Company");
        user.setUserDeductions(userDeductions);
        user.setUserDetails(userDetails);
        user.setUserEmail("jane.doe@example.org");
        user.setUserFirstName("Jane");
        user.setUserId(123);
        user.setUserLastName("Doe");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");
        when(this.userRepository.findByUserEmail((String) any())).thenReturn(user);
        assertSame(user, this.userService.getUserbyEmailId("42"));
        verify(this.userRepository).findByUserEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#updateExistingUser(User)}
     */
    @Test
    void testUpdateExistingUser() throws UserNotFoundException {
        Section10 section10 = new Section10();
        section10.setActualRentPaid(1L);
        section10.setChildEducationAllowance(1L);
        section10.setChildHostelAllowance(1L);
        section10.setHra(1L);
        section10.setLta(1L);
        section10.setMetro(true);
        section10.setOtherRepay(1L);
        section10.setSection10id(1L);

        Section24 section24 = new Section24();
        section24.setInterest(1L);
        section24.setPropertyTax(1L);
        section24.setRent(1L);
        section24.setSection24id(1L);

        Section80C section80C = new Section80C();
        section80C.setElss(1L);
        section80C.setEmployeeEpfContri(1L);
        section80C.setFd(1L);
        section80C.setHomeLoanPrincipal(1L);
        section80C.setLic(1L);
        section80C.setNps_80c(1L);
        section80C.setNsc(1L);
        section80C.setPpf(1L);
        section80C.setSection80cid(1L);
        section80C.setSsy(1L);
        section80C.setTutionFees(1L);
        section80C.setUlip(1L);

        UserDeductions userDeductions = new UserDeductions();
        userDeductions.setAdditionNps(1L);
        userDeductions.setCharityDonation(1L);
        userDeductions.setDeductionid(1L);
        userDeductions.setEducationLoanInterest(1L);
        userDeductions.setEmployerEpfContri(1L);
        userDeductions.setEmployerNpsContri(1L);
        userDeductions.setHomeLoanInterest(1L);
        userDeductions.setMedicalInsurance(1L);
        userDeductions.setSavingAccountInterest(3L);
        userDeductions.setSection10(section10);
        userDeductions.setSection24(section24);
        userDeductions.setSection80C(section80C);

        UserDetails userDetails = new UserDetails();
        userDetails.setAge(1);
        userDetails.setBasicSalary(1L);
        userDetails.setBusinessIncome(1L);
        userDetails.setCapitalGains(1L);
        userDetails.setOtherIncome(1L);
        userDetails.setRentalIncome(1L);
        userDetails.setSex("Sex");
        userDetails.setTaxSaved(1L);
        userDetails.setUserDetailid(1);
        userDetails.setYear(1);

        User user = new User();
        user.setUserCompany("User Company");
        user.setUserDeductions(userDeductions);
        user.setUserDetails(userDetails);
        user.setUserEmail("jane.doe@example.org");
        user.setUserFirstName("Jane");
        user.setUserId(123);
        user.setUserLastName("Doe");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");

        Section10 section101 = new Section10();
        section101.setActualRentPaid(1L);
        section101.setChildEducationAllowance(1L);
        section101.setChildHostelAllowance(1L);
        section101.setHra(1L);
        section101.setLta(1L);
        section101.setMetro(true);
        section101.setOtherRepay(1L);
        section101.setSection10id(1L);

        Section24 section241 = new Section24();
        section241.setInterest(1L);
        section241.setPropertyTax(1L);
        section241.setRent(1L);
        section241.setSection24id(1L);

        Section80C section80C1 = new Section80C();
        section80C1.setElss(1L);
        section80C1.setEmployeeEpfContri(1L);
        section80C1.setFd(1L);
        section80C1.setHomeLoanPrincipal(1L);
        section80C1.setLic(1L);
        section80C1.setNps_80c(1L);
        section80C1.setNsc(1L);
        section80C1.setPpf(1L);
        section80C1.setSection80cid(1L);
        section80C1.setSsy(1L);
        section80C1.setTutionFees(1L);
        section80C1.setUlip(1L);

        UserDeductions userDeductions1 = new UserDeductions();
        userDeductions1.setAdditionNps(1L);
        userDeductions1.setCharityDonation(1L);
        userDeductions1.setDeductionid(1L);
        userDeductions1.setEducationLoanInterest(1L);
        userDeductions1.setEmployerEpfContri(1L);
        userDeductions1.setEmployerNpsContri(1L);
        userDeductions1.setHomeLoanInterest(1L);
        userDeductions1.setMedicalInsurance(1L);
        userDeductions1.setSavingAccountInterest(3L);
        userDeductions1.setSection10(section101);
        userDeductions1.setSection24(section241);
        userDeductions1.setSection80C(section80C1);

        UserDetails userDetails1 = new UserDetails();
        userDetails1.setAge(1);
        userDetails1.setBasicSalary(1L);
        userDetails1.setBusinessIncome(1L);
        userDetails1.setCapitalGains(1L);
        userDetails1.setOtherIncome(1L);
        userDetails1.setRentalIncome(1L);
        userDetails1.setSex("Sex");
        userDetails1.setTaxSaved(1L);
        userDetails1.setUserDetailid(1);
        userDetails1.setYear(1);

        User user1 = new User();
        user1.setUserCompany("User Company");
        user1.setUserDeductions(userDeductions1);
        user1.setUserDetails(userDetails1);
        user1.setUserEmail("jane.doe@example.org");
        user1.setUserFirstName("Jane");
        user1.setUserId(123);
        user1.setUserLastName("Doe");
        user1.setUserName("janedoe");
        user1.setUserPassword("iloveyou");
        when(this.userRepository.save((User) any())).thenReturn(user1);
        when(this.userRepository.findByUserEmail((String) any())).thenReturn(user);

        Section10 section102 = new Section10();
        section102.setActualRentPaid(1L);
        section102.setChildEducationAllowance(1L);
        section102.setChildHostelAllowance(1L);
        section102.setHra(1L);
        section102.setLta(1L);
        section102.setMetro(true);
        section102.setOtherRepay(1L);
        section102.setSection10id(1L);

        Section24 section242 = new Section24();
        section242.setInterest(1L);
        section242.setPropertyTax(1L);
        section242.setRent(1L);
        section242.setSection24id(1L);

        Section80C section80C2 = new Section80C();
        section80C2.setElss(1L);
        section80C2.setEmployeeEpfContri(1L);
        section80C2.setFd(1L);
        section80C2.setHomeLoanPrincipal(1L);
        section80C2.setLic(1L);
        section80C2.setNps_80c(1L);
        section80C2.setNsc(1L);
        section80C2.setPpf(1L);
        section80C2.setSection80cid(1L);
        section80C2.setSsy(1L);
        section80C2.setTutionFees(1L);
        section80C2.setUlip(1L);

        UserDeductions userDeductions2 = new UserDeductions();
        userDeductions2.setAdditionNps(1L);
        userDeductions2.setCharityDonation(1L);
        userDeductions2.setDeductionid(1L);
        userDeductions2.setEducationLoanInterest(1L);
        userDeductions2.setEmployerEpfContri(1L);
        userDeductions2.setEmployerNpsContri(1L);
        userDeductions2.setHomeLoanInterest(1L);
        userDeductions2.setMedicalInsurance(1L);
        userDeductions2.setSavingAccountInterest(3L);
        userDeductions2.setSection10(section102);
        userDeductions2.setSection24(section242);
        userDeductions2.setSection80C(section80C2);

        UserDetails userDetails2 = new UserDetails();
        userDetails2.setAge(1);
        userDetails2.setBasicSalary(1L);
        userDetails2.setBusinessIncome(1L);
        userDetails2.setCapitalGains(1L);
        userDetails2.setOtherIncome(1L);
        userDetails2.setRentalIncome(1L);
        userDetails2.setSex("Sex");
        userDetails2.setTaxSaved(1L);
        userDetails2.setUserDetailid(1);
        userDetails2.setYear(1);

        User user2 = new User();
        user2.setUserCompany("User Company");
        user2.setUserDeductions(userDeductions2);
        user2.setUserDetails(userDetails2);
        user2.setUserEmail("jane.doe@example.org");
        user2.setUserFirstName("Jane");
        user2.setUserId(123);
        user2.setUserLastName("Doe");
        user2.setUserName("janedoe");
        user2.setUserPassword("iloveyou");
        User actualUpdateExistingUserResult = this.userService.updateExistingUser(user2);
        assertSame(user, actualUpdateExistingUserResult);
        assertEquals(userDetails, actualUpdateExistingUserResult.getUserDetails());
        assertEquals(userDeductions, actualUpdateExistingUserResult.getUserDeductions());
        verify(this.userRepository).findByUserEmail((String) any());
        verify(this.userRepository).save((User) any());
    }

    /**
     * Method under test: {@link UserService#setNewPassword(String, String)}
     */
    @Test
    void testSetNewPassword() throws SamePasswordException, UserNotFoundException {
        Section10 section10 = new Section10();
        section10.setActualRentPaid(1L);
        section10.setChildEducationAllowance(1L);
        section10.setChildHostelAllowance(1L);
        section10.setHra(1L);
        section10.setLta(1L);
        section10.setMetro(true);
        section10.setOtherRepay(1L);
        section10.setSection10id(1L);

        Section24 section24 = new Section24();
        section24.setInterest(1L);
        section24.setPropertyTax(1L);
        section24.setRent(1L);
        section24.setSection24id(1L);

        Section80C section80C = new Section80C();
        section80C.setElss(1L);
        section80C.setEmployeeEpfContri(1L);
        section80C.setFd(1L);
        section80C.setHomeLoanPrincipal(1L);
        section80C.setLic(1L);
        section80C.setNps_80c(1L);
        section80C.setNsc(1L);
        section80C.setPpf(1L);
        section80C.setSection80cid(1L);
        section80C.setSsy(1L);
        section80C.setTutionFees(1L);
        section80C.setUlip(1L);

        UserDeductions userDeductions = new UserDeductions();
        userDeductions.setAdditionNps(1L);
        userDeductions.setCharityDonation(1L);
        userDeductions.setDeductionid(1L);
        userDeductions.setEducationLoanInterest(1L);
        userDeductions.setEmployerEpfContri(1L);
        userDeductions.setEmployerNpsContri(1L);
        userDeductions.setHomeLoanInterest(1L);
        userDeductions.setMedicalInsurance(1L);
        userDeductions.setSavingAccountInterest(3L);
        userDeductions.setSection10(section10);
        userDeductions.setSection24(section24);
        userDeductions.setSection80C(section80C);

        UserDetails userDetails = new UserDetails();
        userDetails.setAge(1);
        userDetails.setBasicSalary(1L);
        userDetails.setBusinessIncome(1L);
        userDetails.setCapitalGains(1L);
        userDetails.setOtherIncome(1L);
        userDetails.setRentalIncome(1L);
        userDetails.setSex("Sex");
        userDetails.setTaxSaved(1L);
        userDetails.setUserDetailid(1);
        userDetails.setYear(1);

        User user = new User();
        user.setUserCompany("User Company");
        user.setUserDeductions(userDeductions);
        user.setUserDetails(userDetails);
        user.setUserEmail("jane.doe@example.org");
        user.setUserFirstName("Jane");
        user.setUserId(123);
        user.setUserLastName("Doe");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");
        when(this.userRepository.findByUserEmail((String) any())).thenReturn(user);
        assertThrows(SamePasswordException.class,
                () -> this.userService.setNewPassword("jane.doe@example.org", "iloveyou"));
        verify(this.userRepository).findByUserEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#calculateTaxes(String)}
     */
    @Test
    void testCalculateTaxes() throws UserNotFoundException {
        Section10 section10 = new Section10();
        section10.setActualRentPaid(1L);
        section10.setChildEducationAllowance(1L);
        section10.setChildHostelAllowance(1L);
        section10.setHra(1L);
        section10.setLta(1L);
        section10.setMetro(true);
        section10.setOtherRepay(1L);
        section10.setSection10id(1L);

        Section24 section24 = new Section24();
        section24.setInterest(1L);
        section24.setPropertyTax(1L);
        section24.setRent(1L);
        section24.setSection24id(1L);

        Section80C section80C = new Section80C();
        section80C.setElss(1L);
        section80C.setEmployeeEpfContri(1L);
        section80C.setFd(1L);
        section80C.setHomeLoanPrincipal(1L);
        section80C.setLic(1L);
        section80C.setNps_80c(1L);
        section80C.setNsc(1L);
        section80C.setPpf(1L);
        section80C.setSection80cid(1L);
        section80C.setSsy(1L);
        section80C.setTutionFees(1L);
        section80C.setUlip(1L);

        UserDeductions userDeductions = new UserDeductions();
        userDeductions.setAdditionNps(1L);
        userDeductions.setCharityDonation(1L);
        userDeductions.setDeductionid(1L);
        userDeductions.setEducationLoanInterest(1L);
        userDeductions.setEmployerEpfContri(1L);
        userDeductions.setEmployerNpsContri(1L);
        userDeductions.setHomeLoanInterest(1L);
        userDeductions.setMedicalInsurance(1L);
        userDeductions.setSavingAccountInterest(3L);
        userDeductions.setSection10(section10);
        userDeductions.setSection24(section24);
        userDeductions.setSection80C(section80C);

        UserDetails userDetails = new UserDetails();
        userDetails.setAge(1);
        userDetails.setBasicSalary(1L);
        userDetails.setBusinessIncome(1L);
        userDetails.setCapitalGains(1L);
        userDetails.setOtherIncome(1L);
        userDetails.setRentalIncome(1L);
        userDetails.setSex("Sex");
        userDetails.setTaxSaved(1L);
        userDetails.setUserDetailid(1);
        userDetails.setYear(1);

        User user = new User();
        user.setUserCompany("User Company");
        user.setUserDeductions(userDeductions);
        user.setUserDetails(userDetails);
        user.setUserEmail("jane.doe@example.org");
        user.setUserFirstName("Jane");
        user.setUserId(123);
        user.setUserLastName("Doe");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");
        when(this.userRepository.findByUserEmail((String) any())).thenReturn(user);
        assertEquals(10, this.userService.calculateTaxes("jane.doe@example.org").size());
        verify(this.userRepository).findByUserEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#calculateTaxes(String)}
     */
    @Test
    void testCalculateTaxes2() throws UserNotFoundException {
        Section10 section10 = new Section10();
        section10.setActualRentPaid(1L);
        section10.setChildEducationAllowance(1L);
        section10.setChildHostelAllowance(1L);
        section10.setHra(1L);
        section10.setLta(1L);
        section10.setMetro(true);
        section10.setOtherRepay(1L);
        section10.setSection10id(1L);

        Section24 section24 = new Section24();
        section24.setInterest(1L);
        section24.setPropertyTax(1L);
        section24.setRent(1L);
        section24.setSection24id(1L);

        Section80C section80C = new Section80C();
        section80C.setElss(1L);
        section80C.setEmployeeEpfContri(1L);
        section80C.setFd(1L);
        section80C.setHomeLoanPrincipal(1L);
        section80C.setLic(1L);
        section80C.setNps_80c(1L);
        section80C.setNsc(1L);
        section80C.setPpf(1L);
        section80C.setSection80cid(1L);
        section80C.setSsy(1L);
        section80C.setTutionFees(1L);
        section80C.setUlip(1L);

        UserDeductions userDeductions = new UserDeductions();
        userDeductions.setAdditionNps(1L);
        userDeductions.setCharityDonation(1L);
        userDeductions.setDeductionid(1L);
        userDeductions.setEducationLoanInterest(1L);
        userDeductions.setEmployerEpfContri(1L);
        userDeductions.setEmployerNpsContri(1L);
        userDeductions.setHomeLoanInterest(1L);
        userDeductions.setMedicalInsurance(1L);
        userDeductions.setSavingAccountInterest(3L);
        userDeductions.setSection10(section10);
        userDeductions.setSection24(section24);
        userDeductions.setSection80C(section80C);

        UserDetails userDetails = new UserDetails();
        userDetails.setAge(1);
        userDetails.setBasicSalary(1L);
        userDetails.setBusinessIncome(1L);
        userDetails.setCapitalGains(1L);
        userDetails.setOtherIncome(1L);
        userDetails.setRentalIncome(1L);
        userDetails.setSex("Sex");
        userDetails.setTaxSaved(1L);
        userDetails.setUserDetailid(1);
        userDetails.setYear(1);

        Section10 section101 = new Section10();
        section101.setActualRentPaid(1L);
        section101.setChildEducationAllowance(1L);
        section101.setChildHostelAllowance(1L);
        section101.setHra(1L);
        section101.setLta(1L);
        section101.setMetro(true);
        section101.setOtherRepay(1L);
        section101.setSection10id(1L);

        Section24 section241 = new Section24();
        section241.setInterest(1L);
        section241.setPropertyTax(1L);
        section241.setRent(1L);
        section241.setSection24id(1L);

        Section80C section80C1 = new Section80C();
        section80C1.setElss(1L);
        section80C1.setEmployeeEpfContri(1L);
        section80C1.setFd(1L);
        section80C1.setHomeLoanPrincipal(1L);
        section80C1.setLic(1L);
        section80C1.setNps_80c(1L);
        section80C1.setNsc(1L);
        section80C1.setPpf(1L);
        section80C1.setSection80cid(1L);
        section80C1.setSsy(1L);
        section80C1.setTutionFees(1L);
        section80C1.setUlip(1L);
        Section10 section102 = mock(Section10.class);
        when(section102.isMetro()).thenReturn(false);
        when(section102.getActualRentPaid()).thenReturn(1L);
        when(section102.getChildEducationAllowance()).thenReturn(1L);
        when(section102.getChildHostelAllowance()).thenReturn(1L);
        when(section102.getHra()).thenReturn(1L);
        when(section102.getLta()).thenReturn(1L);
        when(section102.getOtherRepay()).thenReturn(1L);
        doNothing().when(section102).setActualRentPaid(anyLong());
        doNothing().when(section102).setChildEducationAllowance(anyLong());
        doNothing().when(section102).setChildHostelAllowance(anyLong());
        doNothing().when(section102).setHra(anyLong());
        doNothing().when(section102).setLta(anyLong());
        doNothing().when(section102).setMetro(anyBoolean());
        doNothing().when(section102).setOtherRepay(anyLong());
        doNothing().when(section102).setSection10id(anyLong());
        section102.setActualRentPaid(1L);
        section102.setChildEducationAllowance(1L);
        section102.setChildHostelAllowance(1L);
        section102.setHra(1L);
        section102.setLta(1L);
        section102.setMetro(true);
        section102.setOtherRepay(1L);
        section102.setSection10id(1L);

        Section24 section242 = new Section24();
        section242.setInterest(1L);
        section242.setPropertyTax(1L);
        section242.setRent(1L);
        section242.setSection24id(1L);

        Section80C section80C2 = new Section80C();
        section80C2.setElss(1L);
        section80C2.setEmployeeEpfContri(1L);
        section80C2.setFd(1L);
        section80C2.setHomeLoanPrincipal(1L);
        section80C2.setLic(1L);
        section80C2.setNps_80c(1L);
        section80C2.setNsc(1L);
        section80C2.setPpf(1L);
        section80C2.setSection80cid(1L);
        section80C2.setSsy(1L);
        section80C2.setTutionFees(1L);
        section80C2.setUlip(1L);
        UserDeductions userDeductions1 = mock(UserDeductions.class);
        when(userDeductions1.getSection10()).thenReturn(section102);
        when(userDeductions1.getSection24()).thenReturn(section242);
        when(userDeductions1.getSection80C()).thenReturn(section80C2);
        when(userDeductions1.getAdditionNps()).thenReturn(1L);
        when(userDeductions1.getCharityDonation()).thenReturn(1L);
        when(userDeductions1.getEducationLoanInterest()).thenReturn(1L);
        when(userDeductions1.getEmployerEpfContri()).thenReturn(1L);
        when(userDeductions1.getEmployerNpsContri()).thenReturn(1L);
        when(userDeductions1.getHomeLoanInterest()).thenReturn(1L);
        when(userDeductions1.getMedicalInsurance()).thenReturn(1L);
        when(userDeductions1.getSavingAccountInterest()).thenReturn(3L);
        doNothing().when(userDeductions1).setAdditionNps(anyLong());
        doNothing().when(userDeductions1).setCharityDonation(anyLong());
        doNothing().when(userDeductions1).setDeductionid(anyLong());
        doNothing().when(userDeductions1).setEducationLoanInterest(anyLong());
        doNothing().when(userDeductions1).setEmployerEpfContri(anyLong());
        doNothing().when(userDeductions1).setEmployerNpsContri(anyLong());
        doNothing().when(userDeductions1).setHomeLoanInterest(anyLong());
        doNothing().when(userDeductions1).setMedicalInsurance(anyLong());
        doNothing().when(userDeductions1).setSavingAccountInterest(anyLong());
        doNothing().when(userDeductions1).setSection10((Section10) any());
        doNothing().when(userDeductions1).setSection24((Section24) any());
        doNothing().when(userDeductions1).setSection80C((Section80C) any());
        userDeductions1.setAdditionNps(1L);
        userDeductions1.setCharityDonation(1L);
        userDeductions1.setDeductionid(1L);
        userDeductions1.setEducationLoanInterest(1L);
        userDeductions1.setEmployerEpfContri(1L);
        userDeductions1.setEmployerNpsContri(1L);
        userDeductions1.setHomeLoanInterest(1L);
        userDeductions1.setMedicalInsurance(1L);
        userDeductions1.setSavingAccountInterest(3L);
        userDeductions1.setSection10(section101);
        userDeductions1.setSection24(section241);
        userDeductions1.setSection80C(section80C1);

        UserDetails userDetails1 = new UserDetails();
        userDetails1.setAge(1);
        userDetails1.setBasicSalary(1L);
        userDetails1.setBusinessIncome(1L);
        userDetails1.setCapitalGains(1L);
        userDetails1.setOtherIncome(1L);
        userDetails1.setRentalIncome(1L);
        userDetails1.setSex("Sex");
        userDetails1.setTaxSaved(1L);
        userDetails1.setUserDetailid(1);
        userDetails1.setYear(1);
        User user = mock(User.class);
        when(user.getUserDeductions()).thenReturn(userDeductions1);
        when(user.getUserDetails()).thenReturn(userDetails1);
        doNothing().when(user).setUserCompany((String) any());
        doNothing().when(user).setUserDeductions((UserDeductions) any());
        doNothing().when(user).setUserDetails((UserDetails) any());
        doNothing().when(user).setUserEmail((String) any());
        doNothing().when(user).setUserFirstName((String) any());
        doNothing().when(user).setUserId(anyInt());
        doNothing().when(user).setUserLastName((String) any());
        doNothing().when(user).setUserName((String) any());
        doNothing().when(user).setUserPassword((String) any());
        user.setUserCompany("User Company");
        user.setUserDeductions(userDeductions);
        user.setUserDetails(userDetails);
        user.setUserEmail("jane.doe@example.org");
        user.setUserFirstName("Jane");
        user.setUserId(123);
        user.setUserLastName("Doe");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");
        when(this.userRepository.findByUserEmail((String) any())).thenReturn(user);
        assertEquals(10, this.userService.calculateTaxes("jane.doe@example.org").size());
        verify(this.userRepository).findByUserEmail((String) any());
        verify(user).getUserDeductions();
        verify(user, atLeast(1)).getUserDetails();
        verify(user).setUserCompany((String) any());
        verify(user).setUserDeductions((UserDeductions) any());
        verify(user).setUserDetails((UserDetails) any());
        verify(user).setUserEmail((String) any());
        verify(user).setUserFirstName((String) any());
        verify(user).setUserId(anyInt());
        verify(user).setUserLastName((String) any());
        verify(user).setUserName((String) any());
        verify(user).setUserPassword((String) any());
        verify(userDeductions1).getSection10();
        verify(userDeductions1).getSection24();
        verify(userDeductions1).getSection80C();
        verify(userDeductions1).getAdditionNps();
        verify(userDeductions1).getCharityDonation();
        verify(userDeductions1).getEducationLoanInterest();
        verify(userDeductions1).getEmployerEpfContri();
        verify(userDeductions1).getEmployerNpsContri();
        verify(userDeductions1).getHomeLoanInterest();
        verify(userDeductions1).getMedicalInsurance();
        verify(userDeductions1).getSavingAccountInterest();
        verify(userDeductions1).setAdditionNps(anyLong());
        verify(userDeductions1).setCharityDonation(anyLong());
        verify(userDeductions1).setDeductionid(anyLong());
        verify(userDeductions1).setEducationLoanInterest(anyLong());
        verify(userDeductions1).setEmployerEpfContri(anyLong());
        verify(userDeductions1).setEmployerNpsContri(anyLong());
        verify(userDeductions1).setHomeLoanInterest(anyLong());
        verify(userDeductions1).setMedicalInsurance(anyLong());
        verify(userDeductions1).setSavingAccountInterest(anyLong());
        verify(userDeductions1).setSection10((Section10) any());
        verify(userDeductions1).setSection24((Section24) any());
        verify(userDeductions1).setSection80C((Section80C) any());
        verify(section102).isMetro();
        verify(section102).getActualRentPaid();
        verify(section102).getChildEducationAllowance();
        verify(section102).getChildHostelAllowance();
        verify(section102).getHra();
        verify(section102).getLta();
        verify(section102).getOtherRepay();
        verify(section102).setActualRentPaid(anyLong());
        verify(section102).setChildEducationAllowance(anyLong());
        verify(section102).setChildHostelAllowance(anyLong());
        verify(section102).setHra(anyLong());
        verify(section102).setLta(anyLong());
        verify(section102).setMetro(anyBoolean());
        verify(section102).setOtherRepay(anyLong());
        verify(section102).setSection10id(anyLong());
    }

    /**
     * Method under test: {@link UserService#calculateTaxes(String)}
     */
    @Test
    void testCalculateTaxes3() throws UserNotFoundException {
        Section10 section10 = new Section10();
        section10.setActualRentPaid(1L);
        section10.setChildEducationAllowance(1L);
        section10.setChildHostelAllowance(1L);
        section10.setHra(1L);
        section10.setLta(1L);
        section10.setMetro(true);
        section10.setOtherRepay(1L);
        section10.setSection10id(1L);

        Section24 section24 = new Section24();
        section24.setInterest(1L);
        section24.setPropertyTax(1L);
        section24.setRent(1L);
        section24.setSection24id(1L);

        Section80C section80C = new Section80C();
        section80C.setElss(1L);
        section80C.setEmployeeEpfContri(1L);
        section80C.setFd(1L);
        section80C.setHomeLoanPrincipal(1L);
        section80C.setLic(1L);
        section80C.setNps_80c(1L);
        section80C.setNsc(1L);
        section80C.setPpf(1L);
        section80C.setSection80cid(1L);
        section80C.setSsy(1L);
        section80C.setTutionFees(1L);
        section80C.setUlip(1L);

        UserDeductions userDeductions = new UserDeductions();
        userDeductions.setAdditionNps(1L);
        userDeductions.setCharityDonation(1L);
        userDeductions.setDeductionid(1L);
        userDeductions.setEducationLoanInterest(1L);
        userDeductions.setEmployerEpfContri(1L);
        userDeductions.setEmployerNpsContri(1L);
        userDeductions.setHomeLoanInterest(1L);
        userDeductions.setMedicalInsurance(1L);
        userDeductions.setSavingAccountInterest(3L);
        userDeductions.setSection10(section10);
        userDeductions.setSection24(section24);
        userDeductions.setSection80C(section80C);

        UserDetails userDetails = new UserDetails();
        userDetails.setAge(1);
        userDetails.setBasicSalary(1L);
        userDetails.setBusinessIncome(1L);
        userDetails.setCapitalGains(1L);
        userDetails.setOtherIncome(1L);
        userDetails.setRentalIncome(1L);
        userDetails.setSex("Sex");
        userDetails.setTaxSaved(1L);
        userDetails.setUserDetailid(1);
        userDetails.setYear(1);

        Section10 section101 = new Section10();
        section101.setActualRentPaid(1L);
        section101.setChildEducationAllowance(1L);
        section101.setChildHostelAllowance(1L);
        section101.setHra(1L);
        section101.setLta(1L);
        section101.setMetro(true);
        section101.setOtherRepay(1L);
        section101.setSection10id(1L);

        Section24 section241 = new Section24();
        section241.setInterest(1L);
        section241.setPropertyTax(1L);
        section241.setRent(1L);
        section241.setSection24id(1L);

        Section80C section80C1 = new Section80C();
        section80C1.setElss(1L);
        section80C1.setEmployeeEpfContri(1L);
        section80C1.setFd(1L);
        section80C1.setHomeLoanPrincipal(1L);
        section80C1.setLic(1L);
        section80C1.setNps_80c(1L);
        section80C1.setNsc(1L);
        section80C1.setPpf(1L);
        section80C1.setSection80cid(1L);
        section80C1.setSsy(1L);
        section80C1.setTutionFees(1L);
        section80C1.setUlip(1L);
        Section10 section102 = mock(Section10.class);
        when(section102.isMetro()).thenReturn(true);
        when(section102.getActualRentPaid()).thenReturn(1L);
        when(section102.getChildEducationAllowance()).thenReturn(Long.MAX_VALUE);
        when(section102.getChildHostelAllowance()).thenReturn(1L);
        when(section102.getHra()).thenReturn(1L);
        when(section102.getLta()).thenReturn(1L);
        when(section102.getOtherRepay()).thenReturn(1L);
        doNothing().when(section102).setActualRentPaid(anyLong());
        doNothing().when(section102).setChildEducationAllowance(anyLong());
        doNothing().when(section102).setChildHostelAllowance(anyLong());
        doNothing().when(section102).setHra(anyLong());
        doNothing().when(section102).setLta(anyLong());
        doNothing().when(section102).setMetro(anyBoolean());
        doNothing().when(section102).setOtherRepay(anyLong());
        doNothing().when(section102).setSection10id(anyLong());
        section102.setActualRentPaid(1L);
        section102.setChildEducationAllowance(1L);
        section102.setChildHostelAllowance(1L);
        section102.setHra(1L);
        section102.setLta(1L);
        section102.setMetro(true);
        section102.setOtherRepay(1L);
        section102.setSection10id(1L);

        Section24 section242 = new Section24();
        section242.setInterest(1L);
        section242.setPropertyTax(1L);
        section242.setRent(1L);
        section242.setSection24id(1L);

        Section80C section80C2 = new Section80C();
        section80C2.setElss(1L);
        section80C2.setEmployeeEpfContri(1L);
        section80C2.setFd(1L);
        section80C2.setHomeLoanPrincipal(1L);
        section80C2.setLic(1L);
        section80C2.setNps_80c(1L);
        section80C2.setNsc(1L);
        section80C2.setPpf(1L);
        section80C2.setSection80cid(1L);
        section80C2.setSsy(1L);
        section80C2.setTutionFees(1L);
        section80C2.setUlip(1L);
        UserDeductions userDeductions1 = mock(UserDeductions.class);
        when(userDeductions1.getSection10()).thenReturn(section102);
        when(userDeductions1.getSection24()).thenReturn(section242);
        when(userDeductions1.getSection80C()).thenReturn(section80C2);
        when(userDeductions1.getAdditionNps()).thenReturn(1L);
        when(userDeductions1.getCharityDonation()).thenReturn(1L);
        when(userDeductions1.getEducationLoanInterest()).thenReturn(1L);
        when(userDeductions1.getEmployerEpfContri()).thenReturn(1L);
        when(userDeductions1.getEmployerNpsContri()).thenReturn(1L);
        when(userDeductions1.getHomeLoanInterest()).thenReturn(1L);
        when(userDeductions1.getMedicalInsurance()).thenReturn(1L);
        when(userDeductions1.getSavingAccountInterest()).thenReturn(3L);
        doNothing().when(userDeductions1).setAdditionNps(anyLong());
        doNothing().when(userDeductions1).setCharityDonation(anyLong());
        doNothing().when(userDeductions1).setDeductionid(anyLong());
        doNothing().when(userDeductions1).setEducationLoanInterest(anyLong());
        doNothing().when(userDeductions1).setEmployerEpfContri(anyLong());
        doNothing().when(userDeductions1).setEmployerNpsContri(anyLong());
        doNothing().when(userDeductions1).setHomeLoanInterest(anyLong());
        doNothing().when(userDeductions1).setMedicalInsurance(anyLong());
        doNothing().when(userDeductions1).setSavingAccountInterest(anyLong());
        doNothing().when(userDeductions1).setSection10((Section10) any());
        doNothing().when(userDeductions1).setSection24((Section24) any());
        doNothing().when(userDeductions1).setSection80C((Section80C) any());
        userDeductions1.setAdditionNps(1L);
        userDeductions1.setCharityDonation(1L);
        userDeductions1.setDeductionid(1L);
        userDeductions1.setEducationLoanInterest(1L);
        userDeductions1.setEmployerEpfContri(1L);
        userDeductions1.setEmployerNpsContri(1L);
        userDeductions1.setHomeLoanInterest(1L);
        userDeductions1.setMedicalInsurance(1L);
        userDeductions1.setSavingAccountInterest(3L);
        userDeductions1.setSection10(section101);
        userDeductions1.setSection24(section241);
        userDeductions1.setSection80C(section80C1);

        UserDetails userDetails1 = new UserDetails();
        userDetails1.setAge(1);
        userDetails1.setBasicSalary(1L);
        userDetails1.setBusinessIncome(1L);
        userDetails1.setCapitalGains(1L);
        userDetails1.setOtherIncome(1L);
        userDetails1.setRentalIncome(1L);
        userDetails1.setSex("Sex");
        userDetails1.setTaxSaved(1L);
        userDetails1.setUserDetailid(1);
        userDetails1.setYear(1);
        User user = mock(User.class);
        when(user.getUserDeductions()).thenReturn(userDeductions1);
        when(user.getUserDetails()).thenReturn(userDetails1);
        doNothing().when(user).setUserCompany((String) any());
        doNothing().when(user).setUserDeductions((UserDeductions) any());
        doNothing().when(user).setUserDetails((UserDetails) any());
        doNothing().when(user).setUserEmail((String) any());
        doNothing().when(user).setUserFirstName((String) any());
        doNothing().when(user).setUserId(anyInt());
        doNothing().when(user).setUserLastName((String) any());
        doNothing().when(user).setUserName((String) any());
        doNothing().when(user).setUserPassword((String) any());
        user.setUserCompany("User Company");
        user.setUserDeductions(userDeductions);
        user.setUserDetails(userDetails);
        user.setUserEmail("jane.doe@example.org");
        user.setUserFirstName("Jane");
        user.setUserId(123);
        user.setUserLastName("Doe");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");
        when(this.userRepository.findByUserEmail((String) any())).thenReturn(user);
        assertEquals(10, this.userService.calculateTaxes("jane.doe@example.org").size());
        verify(this.userRepository).findByUserEmail((String) any());
        verify(user, atLeast(1)).getUserDeductions();
        verify(user, atLeast(1)).getUserDetails();
        verify(user).setUserCompany((String) any());
        verify(user).setUserDeductions((UserDeductions) any());
        verify(user).setUserDetails((UserDetails) any());
        verify(user).setUserEmail((String) any());
        verify(user).setUserFirstName((String) any());
        verify(user).setUserId(anyInt());
        verify(user).setUserLastName((String) any());
        verify(user).setUserName((String) any());
        verify(user).setUserPassword((String) any());
        verify(userDeductions1, atLeast(1)).getSection10();
        verify(userDeductions1, atLeast(1)).getSection24();
        verify(userDeductions1, atLeast(1)).getSection80C();
        verify(userDeductions1).getAdditionNps();
        verify(userDeductions1, atLeast(1)).getCharityDonation();
        verify(userDeductions1).getEducationLoanInterest();
        verify(userDeductions1).getEmployerEpfContri();
        verify(userDeductions1).getEmployerNpsContri();
        verify(userDeductions1).getHomeLoanInterest();
        verify(userDeductions1, atLeast(1)).getMedicalInsurance();
        verify(userDeductions1, atLeast(1)).getSavingAccountInterest();
        verify(userDeductions1).setAdditionNps(anyLong());
        verify(userDeductions1).setCharityDonation(anyLong());
        verify(userDeductions1).setDeductionid(anyLong());
        verify(userDeductions1).setEducationLoanInterest(anyLong());
        verify(userDeductions1).setEmployerEpfContri(anyLong());
        verify(userDeductions1).setEmployerNpsContri(anyLong());
        verify(userDeductions1).setHomeLoanInterest(anyLong());
        verify(userDeductions1).setMedicalInsurance(anyLong());
        verify(userDeductions1).setSavingAccountInterest(anyLong());
        verify(userDeductions1).setSection10((Section10) any());
        verify(userDeductions1).setSection24((Section24) any());
        verify(userDeductions1).setSection80C((Section80C) any());
        verify(section102).isMetro();
        verify(section102).getActualRentPaid();
        verify(section102).getChildEducationAllowance();
        verify(section102).getChildHostelAllowance();
        verify(section102).getHra();
        verify(section102, atLeast(1)).getLta();
        verify(section102).getOtherRepay();
        verify(section102).setActualRentPaid(anyLong());
        verify(section102).setChildEducationAllowance(anyLong());
        verify(section102).setChildHostelAllowance(anyLong());
        verify(section102).setHra(anyLong());
        verify(section102).setLta(anyLong());
        verify(section102).setMetro(anyBoolean());
        verify(section102).setOtherRepay(anyLong());
        verify(section102).setSection10id(anyLong());
    }

    /**
     * Method under test: {@link UserService#calculateTaxes(String)}
     */
    @Test
    void testCalculateTaxes4() throws UserNotFoundException {
        Section10 section10 = new Section10();
        section10.setActualRentPaid(1L);
        section10.setChildEducationAllowance(1L);
        section10.setChildHostelAllowance(1L);
        section10.setHra(1L);
        section10.setLta(1L);
        section10.setMetro(true);
        section10.setOtherRepay(1L);
        section10.setSection10id(1L);

        Section24 section24 = new Section24();
        section24.setInterest(1L);
        section24.setPropertyTax(1L);
        section24.setRent(1L);
        section24.setSection24id(1L);

        Section80C section80C = new Section80C();
        section80C.setElss(1L);
        section80C.setEmployeeEpfContri(1L);
        section80C.setFd(1L);
        section80C.setHomeLoanPrincipal(1L);
        section80C.setLic(1L);
        section80C.setNps_80c(1L);
        section80C.setNsc(1L);
        section80C.setPpf(1L);
        section80C.setSection80cid(1L);
        section80C.setSsy(1L);
        section80C.setTutionFees(1L);
        section80C.setUlip(1L);

        UserDeductions userDeductions = new UserDeductions();
        userDeductions.setAdditionNps(1L);
        userDeductions.setCharityDonation(1L);
        userDeductions.setDeductionid(1L);
        userDeductions.setEducationLoanInterest(1L);
        userDeductions.setEmployerEpfContri(1L);
        userDeductions.setEmployerNpsContri(1L);
        userDeductions.setHomeLoanInterest(1L);
        userDeductions.setMedicalInsurance(1L);
        userDeductions.setSavingAccountInterest(3L);
        userDeductions.setSection10(section10);
        userDeductions.setSection24(section24);
        userDeductions.setSection80C(section80C);

        UserDetails userDetails = new UserDetails();
        userDetails.setAge(1);
        userDetails.setBasicSalary(1L);
        userDetails.setBusinessIncome(1L);
        userDetails.setCapitalGains(1L);
        userDetails.setOtherIncome(1L);
        userDetails.setRentalIncome(1L);
        userDetails.setSex("Sex");
        userDetails.setTaxSaved(1L);
        userDetails.setUserDetailid(1);
        userDetails.setYear(1);

        Section10 section101 = new Section10();
        section101.setActualRentPaid(1L);
        section101.setChildEducationAllowance(1L);
        section101.setChildHostelAllowance(1L);
        section101.setHra(1L);
        section101.setLta(1L);
        section101.setMetro(true);
        section101.setOtherRepay(1L);
        section101.setSection10id(1L);

        Section24 section241 = new Section24();
        section241.setInterest(1L);
        section241.setPropertyTax(1L);
        section241.setRent(1L);
        section241.setSection24id(1L);

        Section80C section80C1 = new Section80C();
        section80C1.setElss(1L);
        section80C1.setEmployeeEpfContri(1L);
        section80C1.setFd(1L);
        section80C1.setHomeLoanPrincipal(1L);
        section80C1.setLic(1L);
        section80C1.setNps_80c(1L);
        section80C1.setNsc(1L);
        section80C1.setPpf(1L);
        section80C1.setSection80cid(1L);
        section80C1.setSsy(1L);
        section80C1.setTutionFees(1L);
        section80C1.setUlip(1L);
        Section10 section102 = mock(Section10.class);
        when(section102.isMetro()).thenReturn(true);
        when(section102.getActualRentPaid()).thenReturn(1L);
        when(section102.getChildEducationAllowance()).thenReturn(1L);
        when(section102.getChildHostelAllowance()).thenReturn(1L);
        when(section102.getHra()).thenReturn(1L);
        when(section102.getLta()).thenReturn(1L);
        when(section102.getOtherRepay()).thenReturn(1L);
        doNothing().when(section102).setActualRentPaid(anyLong());
        doNothing().when(section102).setChildEducationAllowance(anyLong());
        doNothing().when(section102).setChildHostelAllowance(anyLong());
        doNothing().when(section102).setHra(anyLong());
        doNothing().when(section102).setLta(anyLong());
        doNothing().when(section102).setMetro(anyBoolean());
        doNothing().when(section102).setOtherRepay(anyLong());
        doNothing().when(section102).setSection10id(anyLong());
        section102.setActualRentPaid(1L);
        section102.setChildEducationAllowance(1L);
        section102.setChildHostelAllowance(1L);
        section102.setHra(1L);
        section102.setLta(1L);
        section102.setMetro(true);
        section102.setOtherRepay(1L);
        section102.setSection10id(1L);

        Section24 section242 = new Section24();
        section242.setInterest(-1L);
        section242.setPropertyTax(1L);
        section242.setRent(1L);
        section242.setSection24id(1L);

        Section80C section80C2 = new Section80C();
        section80C2.setElss(1L);
        section80C2.setEmployeeEpfContri(1L);
        section80C2.setFd(1L);
        section80C2.setHomeLoanPrincipal(1L);
        section80C2.setLic(1L);
        section80C2.setNps_80c(1L);
        section80C2.setNsc(1L);
        section80C2.setPpf(1L);
        section80C2.setSection80cid(1L);
        section80C2.setSsy(1L);
        section80C2.setTutionFees(1L);
        section80C2.setUlip(1L);
        UserDeductions userDeductions1 = mock(UserDeductions.class);
        when(userDeductions1.getSection10()).thenReturn(section102);
        when(userDeductions1.getSection24()).thenReturn(section242);
        when(userDeductions1.getSection80C()).thenReturn(section80C2);
        when(userDeductions1.getAdditionNps()).thenReturn(1L);
        when(userDeductions1.getCharityDonation()).thenReturn(1L);
        when(userDeductions1.getEducationLoanInterest()).thenReturn(1L);
        when(userDeductions1.getEmployerEpfContri()).thenReturn(1L);
        when(userDeductions1.getEmployerNpsContri()).thenReturn(1L);
        when(userDeductions1.getHomeLoanInterest()).thenReturn(1L);
        when(userDeductions1.getMedicalInsurance()).thenReturn(1L);
        when(userDeductions1.getSavingAccountInterest()).thenReturn(3L);
        doNothing().when(userDeductions1).setAdditionNps(anyLong());
        doNothing().when(userDeductions1).setCharityDonation(anyLong());
        doNothing().when(userDeductions1).setDeductionid(anyLong());
        doNothing().when(userDeductions1).setEducationLoanInterest(anyLong());
        doNothing().when(userDeductions1).setEmployerEpfContri(anyLong());
        doNothing().when(userDeductions1).setEmployerNpsContri(anyLong());
        doNothing().when(userDeductions1).setHomeLoanInterest(anyLong());
        doNothing().when(userDeductions1).setMedicalInsurance(anyLong());
        doNothing().when(userDeductions1).setSavingAccountInterest(anyLong());
        doNothing().when(userDeductions1).setSection10((Section10) any());
        doNothing().when(userDeductions1).setSection24((Section24) any());
        doNothing().when(userDeductions1).setSection80C((Section80C) any());
        userDeductions1.setAdditionNps(1L);
        userDeductions1.setCharityDonation(1L);
        userDeductions1.setDeductionid(1L);
        userDeductions1.setEducationLoanInterest(1L);
        userDeductions1.setEmployerEpfContri(1L);
        userDeductions1.setEmployerNpsContri(1L);
        userDeductions1.setHomeLoanInterest(1L);
        userDeductions1.setMedicalInsurance(1L);
        userDeductions1.setSavingAccountInterest(3L);
        userDeductions1.setSection10(section101);
        userDeductions1.setSection24(section241);
        userDeductions1.setSection80C(section80C1);

        UserDetails userDetails1 = new UserDetails();
        userDetails1.setAge(1);
        userDetails1.setBasicSalary(1L);
        userDetails1.setBusinessIncome(1L);
        userDetails1.setCapitalGains(1L);
        userDetails1.setOtherIncome(1L);
        userDetails1.setRentalIncome(1L);
        userDetails1.setSex("Sex");
        userDetails1.setTaxSaved(1L);
        userDetails1.setUserDetailid(1);
        userDetails1.setYear(1);
        User user = mock(User.class);
        when(user.getUserDeductions()).thenReturn(userDeductions1);
        when(user.getUserDetails()).thenReturn(userDetails1);
        doNothing().when(user).setUserCompany((String) any());
        doNothing().when(user).setUserDeductions((UserDeductions) any());
        doNothing().when(user).setUserDetails((UserDetails) any());
        doNothing().when(user).setUserEmail((String) any());
        doNothing().when(user).setUserFirstName((String) any());
        doNothing().when(user).setUserId(anyInt());
        doNothing().when(user).setUserLastName((String) any());
        doNothing().when(user).setUserName((String) any());
        doNothing().when(user).setUserPassword((String) any());
        user.setUserCompany("User Company");
        user.setUserDeductions(userDeductions);
        user.setUserDetails(userDetails);
        user.setUserEmail("jane.doe@example.org");
        user.setUserFirstName("Jane");
        user.setUserId(123);
        user.setUserLastName("Doe");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");
        when(this.userRepository.findByUserEmail((String) any())).thenReturn(user);
        assertEquals(10, this.userService.calculateTaxes("jane.doe@example.org").size());
        verify(this.userRepository).findByUserEmail((String) any());
        verify(user).getUserDeductions();
        verify(user, atLeast(1)).getUserDetails();
        verify(user).setUserCompany((String) any());
        verify(user).setUserDeductions((UserDeductions) any());
        verify(user).setUserDetails((UserDetails) any());
        verify(user).setUserEmail((String) any());
        verify(user).setUserFirstName((String) any());
        verify(user).setUserId(anyInt());
        verify(user).setUserLastName((String) any());
        verify(user).setUserName((String) any());
        verify(user).setUserPassword((String) any());
        verify(userDeductions1).getSection10();
        verify(userDeductions1).getSection24();
        verify(userDeductions1).getSection80C();
        verify(userDeductions1).getAdditionNps();
        verify(userDeductions1).getCharityDonation();
        verify(userDeductions1).getEducationLoanInterest();
        verify(userDeductions1).getEmployerEpfContri();
        verify(userDeductions1).getEmployerNpsContri();
        verify(userDeductions1).getHomeLoanInterest();
        verify(userDeductions1).getMedicalInsurance();
        verify(userDeductions1).getSavingAccountInterest();
        verify(userDeductions1).setAdditionNps(anyLong());
        verify(userDeductions1).setCharityDonation(anyLong());
        verify(userDeductions1).setDeductionid(anyLong());
        verify(userDeductions1).setEducationLoanInterest(anyLong());
        verify(userDeductions1).setEmployerEpfContri(anyLong());
        verify(userDeductions1).setEmployerNpsContri(anyLong());
        verify(userDeductions1).setHomeLoanInterest(anyLong());
        verify(userDeductions1).setMedicalInsurance(anyLong());
        verify(userDeductions1).setSavingAccountInterest(anyLong());
        verify(userDeductions1).setSection10((Section10) any());
        verify(userDeductions1).setSection24((Section24) any());
        verify(userDeductions1).setSection80C((Section80C) any());
        verify(section102).isMetro();
        verify(section102).getActualRentPaid();
        verify(section102).getChildEducationAllowance();
        verify(section102).getChildHostelAllowance();
        verify(section102).getHra();
        verify(section102).getLta();
        verify(section102).getOtherRepay();
        verify(section102).setActualRentPaid(anyLong());
        verify(section102).setChildEducationAllowance(anyLong());
        verify(section102).setChildHostelAllowance(anyLong());
        verify(section102).setHra(anyLong());
        verify(section102).setLta(anyLong());
        verify(section102).setMetro(anyBoolean());
        verify(section102).setOtherRepay(anyLong());
        verify(section102).setSection10id(anyLong());
    }

    /**
     * Method under test: {@link UserService#calculateTaxes(String)}
     */
    @Test
    void testCalculateTaxes5() throws UserNotFoundException {
        Section10 section10 = new Section10();
        section10.setActualRentPaid(1L);
        section10.setChildEducationAllowance(1L);
        section10.setChildHostelAllowance(1L);
        section10.setHra(1L);
        section10.setLta(1L);
        section10.setMetro(true);
        section10.setOtherRepay(1L);
        section10.setSection10id(1L);

        Section24 section24 = new Section24();
        section24.setInterest(1L);
        section24.setPropertyTax(1L);
        section24.setRent(1L);
        section24.setSection24id(1L);

        Section80C section80C = new Section80C();
        section80C.setElss(1L);
        section80C.setEmployeeEpfContri(1L);
        section80C.setFd(1L);
        section80C.setHomeLoanPrincipal(1L);
        section80C.setLic(1L);
        section80C.setNps_80c(1L);
        section80C.setNsc(1L);
        section80C.setPpf(1L);
        section80C.setSection80cid(1L);
        section80C.setSsy(1L);
        section80C.setTutionFees(1L);
        section80C.setUlip(1L);

        UserDeductions userDeductions = new UserDeductions();
        userDeductions.setAdditionNps(1L);
        userDeductions.setCharityDonation(1L);
        userDeductions.setDeductionid(1L);
        userDeductions.setEducationLoanInterest(1L);
        userDeductions.setEmployerEpfContri(1L);
        userDeductions.setEmployerNpsContri(1L);
        userDeductions.setHomeLoanInterest(1L);
        userDeductions.setMedicalInsurance(1L);
        userDeductions.setSavingAccountInterest(3L);
        userDeductions.setSection10(section10);
        userDeductions.setSection24(section24);
        userDeductions.setSection80C(section80C);

        UserDetails userDetails = new UserDetails();
        userDetails.setAge(1);
        userDetails.setBasicSalary(1L);
        userDetails.setBusinessIncome(1L);
        userDetails.setCapitalGains(1L);
        userDetails.setOtherIncome(1L);
        userDetails.setRentalIncome(1L);
        userDetails.setSex("Sex");
        userDetails.setTaxSaved(1L);
        userDetails.setUserDetailid(1);
        userDetails.setYear(1);

        Section10 section101 = new Section10();
        section101.setActualRentPaid(1L);
        section101.setChildEducationAllowance(1L);
        section101.setChildHostelAllowance(1L);
        section101.setHra(1L);
        section101.setLta(1L);
        section101.setMetro(true);
        section101.setOtherRepay(1L);
        section101.setSection10id(1L);

        Section24 section241 = new Section24();
        section241.setInterest(1L);
        section241.setPropertyTax(1L);
        section241.setRent(1L);
        section241.setSection24id(1L);

        Section80C section80C1 = new Section80C();
        section80C1.setElss(1L);
        section80C1.setEmployeeEpfContri(1L);
        section80C1.setFd(1L);
        section80C1.setHomeLoanPrincipal(1L);
        section80C1.setLic(1L);
        section80C1.setNps_80c(1L);
        section80C1.setNsc(1L);
        section80C1.setPpf(1L);
        section80C1.setSection80cid(1L);
        section80C1.setSsy(1L);
        section80C1.setTutionFees(1L);
        section80C1.setUlip(1L);
        Section10 section102 = mock(Section10.class);
        when(section102.isMetro()).thenReturn(true);
        when(section102.getActualRentPaid()).thenReturn(1L);
        when(section102.getChildEducationAllowance()).thenReturn(1L);
        when(section102.getChildHostelAllowance()).thenReturn(1L);
        when(section102.getHra()).thenReturn(1L);
        when(section102.getLta()).thenReturn(1L);
        when(section102.getOtherRepay()).thenReturn(1L);
        doNothing().when(section102).setActualRentPaid(anyLong());
        doNothing().when(section102).setChildEducationAllowance(anyLong());
        doNothing().when(section102).setChildHostelAllowance(anyLong());
        doNothing().when(section102).setHra(anyLong());
        doNothing().when(section102).setLta(anyLong());
        doNothing().when(section102).setMetro(anyBoolean());
        doNothing().when(section102).setOtherRepay(anyLong());
        doNothing().when(section102).setSection10id(anyLong());
        section102.setActualRentPaid(1L);
        section102.setChildEducationAllowance(1L);
        section102.setChildHostelAllowance(1L);
        section102.setHra(1L);
        section102.setLta(1L);
        section102.setMetro(true);
        section102.setOtherRepay(1L);
        section102.setSection10id(1L);

        Section24 section242 = new Section24();
        section242.setInterest(Long.MAX_VALUE);
        section242.setPropertyTax(1L);
        section242.setRent(1L);
        section242.setSection24id(1L);

        Section80C section80C2 = new Section80C();
        section80C2.setElss(1L);
        section80C2.setEmployeeEpfContri(1L);
        section80C2.setFd(1L);
        section80C2.setHomeLoanPrincipal(1L);
        section80C2.setLic(1L);
        section80C2.setNps_80c(1L);
        section80C2.setNsc(1L);
        section80C2.setPpf(1L);
        section80C2.setSection80cid(1L);
        section80C2.setSsy(1L);
        section80C2.setTutionFees(1L);
        section80C2.setUlip(1L);
        UserDeductions userDeductions1 = mock(UserDeductions.class);
        when(userDeductions1.getSection10()).thenReturn(section102);
        when(userDeductions1.getSection24()).thenReturn(section242);
        when(userDeductions1.getSection80C()).thenReturn(section80C2);
        when(userDeductions1.getAdditionNps()).thenReturn(1L);
        when(userDeductions1.getCharityDonation()).thenReturn(1L);
        when(userDeductions1.getEducationLoanInterest()).thenReturn(1L);
        when(userDeductions1.getEmployerEpfContri()).thenReturn(1L);
        when(userDeductions1.getEmployerNpsContri()).thenReturn(1L);
        when(userDeductions1.getHomeLoanInterest()).thenReturn(1L);
        when(userDeductions1.getMedicalInsurance()).thenReturn(1L);
        when(userDeductions1.getSavingAccountInterest()).thenReturn(3L);
        doNothing().when(userDeductions1).setAdditionNps(anyLong());
        doNothing().when(userDeductions1).setCharityDonation(anyLong());
        doNothing().when(userDeductions1).setDeductionid(anyLong());
        doNothing().when(userDeductions1).setEducationLoanInterest(anyLong());
        doNothing().when(userDeductions1).setEmployerEpfContri(anyLong());
        doNothing().when(userDeductions1).setEmployerNpsContri(anyLong());
        doNothing().when(userDeductions1).setHomeLoanInterest(anyLong());
        doNothing().when(userDeductions1).setMedicalInsurance(anyLong());
        doNothing().when(userDeductions1).setSavingAccountInterest(anyLong());
        doNothing().when(userDeductions1).setSection10((Section10) any());
        doNothing().when(userDeductions1).setSection24((Section24) any());
        doNothing().when(userDeductions1).setSection80C((Section80C) any());
        userDeductions1.setAdditionNps(1L);
        userDeductions1.setCharityDonation(1L);
        userDeductions1.setDeductionid(1L);
        userDeductions1.setEducationLoanInterest(1L);
        userDeductions1.setEmployerEpfContri(1L);
        userDeductions1.setEmployerNpsContri(1L);
        userDeductions1.setHomeLoanInterest(1L);
        userDeductions1.setMedicalInsurance(1L);
        userDeductions1.setSavingAccountInterest(3L);
        userDeductions1.setSection10(section101);
        userDeductions1.setSection24(section241);
        userDeductions1.setSection80C(section80C1);

        UserDetails userDetails1 = new UserDetails();
        userDetails1.setAge(1);
        userDetails1.setBasicSalary(1L);
        userDetails1.setBusinessIncome(1L);
        userDetails1.setCapitalGains(1L);
        userDetails1.setOtherIncome(1L);
        userDetails1.setRentalIncome(1L);
        userDetails1.setSex("Sex");
        userDetails1.setTaxSaved(1L);
        userDetails1.setUserDetailid(1);
        userDetails1.setYear(1);
        User user = mock(User.class);
        when(user.getUserDeductions()).thenReturn(userDeductions1);
        when(user.getUserDetails()).thenReturn(userDetails1);
        doNothing().when(user).setUserCompany((String) any());
        doNothing().when(user).setUserDeductions((UserDeductions) any());
        doNothing().when(user).setUserDetails((UserDetails) any());
        doNothing().when(user).setUserEmail((String) any());
        doNothing().when(user).setUserFirstName((String) any());
        doNothing().when(user).setUserId(anyInt());
        doNothing().when(user).setUserLastName((String) any());
        doNothing().when(user).setUserName((String) any());
        doNothing().when(user).setUserPassword((String) any());
        user.setUserCompany("User Company");
        user.setUserDeductions(userDeductions);
        user.setUserDetails(userDetails);
        user.setUserEmail("jane.doe@example.org");
        user.setUserFirstName("Jane");
        user.setUserId(123);
        user.setUserLastName("Doe");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");
        when(this.userRepository.findByUserEmail((String) any())).thenReturn(user);
        assertEquals(10, this.userService.calculateTaxes("jane.doe@example.org").size());
        verify(this.userRepository).findByUserEmail((String) any());
        verify(user).getUserDeductions();
        verify(user, atLeast(1)).getUserDetails();
        verify(user).setUserCompany((String) any());
        verify(user).setUserDeductions((UserDeductions) any());
        verify(user).setUserDetails((UserDetails) any());
        verify(user).setUserEmail((String) any());
        verify(user).setUserFirstName((String) any());
        verify(user).setUserId(anyInt());
        verify(user).setUserLastName((String) any());
        verify(user).setUserName((String) any());
        verify(user).setUserPassword((String) any());
        verify(userDeductions1).getSection10();
        verify(userDeductions1).getSection24();
        verify(userDeductions1).getSection80C();
        verify(userDeductions1).getAdditionNps();
        verify(userDeductions1).getCharityDonation();
        verify(userDeductions1).getEducationLoanInterest();
        verify(userDeductions1).getEmployerEpfContri();
        verify(userDeductions1).getEmployerNpsContri();
        verify(userDeductions1).getHomeLoanInterest();
        verify(userDeductions1).getMedicalInsurance();
        verify(userDeductions1).getSavingAccountInterest();
        verify(userDeductions1).setAdditionNps(anyLong());
        verify(userDeductions1).setCharityDonation(anyLong());
        verify(userDeductions1).setDeductionid(anyLong());
        verify(userDeductions1).setEducationLoanInterest(anyLong());
        verify(userDeductions1).setEmployerEpfContri(anyLong());
        verify(userDeductions1).setEmployerNpsContri(anyLong());
        verify(userDeductions1).setHomeLoanInterest(anyLong());
        verify(userDeductions1).setMedicalInsurance(anyLong());
        verify(userDeductions1).setSavingAccountInterest(anyLong());
        verify(userDeductions1).setSection10((Section10) any());
        verify(userDeductions1).setSection24((Section24) any());
        verify(userDeductions1).setSection80C((Section80C) any());
        verify(section102).isMetro();
        verify(section102).getActualRentPaid();
        verify(section102).getChildEducationAllowance();
        verify(section102).getChildHostelAllowance();
        verify(section102).getHra();
        verify(section102).getLta();
        verify(section102).getOtherRepay();
        verify(section102).setActualRentPaid(anyLong());
        verify(section102).setChildEducationAllowance(anyLong());
        verify(section102).setChildHostelAllowance(anyLong());
        verify(section102).setHra(anyLong());
        verify(section102).setLta(anyLong());
        verify(section102).setMetro(anyBoolean());
        verify(section102).setOtherRepay(anyLong());
        verify(section102).setSection10id(anyLong());
    }

    /**
     * Method under test: {@link UserService#calculateTaxes(String)}
     */
    @Test
    void testCalculateTaxes6() throws UserNotFoundException {
        Section10 section10 = new Section10();
        section10.setActualRentPaid(1L);
        section10.setChildEducationAllowance(1L);
        section10.setChildHostelAllowance(1L);
        section10.setHra(1L);
        section10.setLta(1L);
        section10.setMetro(true);
        section10.setOtherRepay(1L);
        section10.setSection10id(1L);

        Section24 section24 = new Section24();
        section24.setInterest(1L);
        section24.setPropertyTax(1L);
        section24.setRent(1L);
        section24.setSection24id(1L);

        Section80C section80C = new Section80C();
        section80C.setElss(1L);
        section80C.setEmployeeEpfContri(1L);
        section80C.setFd(1L);
        section80C.setHomeLoanPrincipal(1L);
        section80C.setLic(1L);
        section80C.setNps_80c(1L);
        section80C.setNsc(1L);
        section80C.setPpf(1L);
        section80C.setSection80cid(1L);
        section80C.setSsy(1L);
        section80C.setTutionFees(1L);
        section80C.setUlip(1L);

        UserDeductions userDeductions = new UserDeductions();
        userDeductions.setAdditionNps(1L);
        userDeductions.setCharityDonation(1L);
        userDeductions.setDeductionid(1L);
        userDeductions.setEducationLoanInterest(1L);
        userDeductions.setEmployerEpfContri(1L);
        userDeductions.setEmployerNpsContri(1L);
        userDeductions.setHomeLoanInterest(1L);
        userDeductions.setMedicalInsurance(1L);
        userDeductions.setSavingAccountInterest(3L);
        userDeductions.setSection10(section10);
        userDeductions.setSection24(section24);
        userDeductions.setSection80C(section80C);

        UserDetails userDetails = new UserDetails();
        userDetails.setAge(1);
        userDetails.setBasicSalary(1L);
        userDetails.setBusinessIncome(1L);
        userDetails.setCapitalGains(1L);
        userDetails.setOtherIncome(1L);
        userDetails.setRentalIncome(1L);
        userDetails.setSex("Sex");
        userDetails.setTaxSaved(1L);
        userDetails.setUserDetailid(1);
        userDetails.setYear(1);

        Section10 section101 = new Section10();
        section101.setActualRentPaid(1L);
        section101.setChildEducationAllowance(1L);
        section101.setChildHostelAllowance(1L);
        section101.setHra(1L);
        section101.setLta(1L);
        section101.setMetro(true);
        section101.setOtherRepay(1L);
        section101.setSection10id(1L);

        Section24 section241 = new Section24();
        section241.setInterest(1L);
        section241.setPropertyTax(1L);
        section241.setRent(1L);
        section241.setSection24id(1L);

        Section80C section80C1 = new Section80C();
        section80C1.setElss(1L);
        section80C1.setEmployeeEpfContri(1L);
        section80C1.setFd(1L);
        section80C1.setHomeLoanPrincipal(1L);
        section80C1.setLic(1L);
        section80C1.setNps_80c(1L);
        section80C1.setNsc(1L);
        section80C1.setPpf(1L);
        section80C1.setSection80cid(1L);
        section80C1.setSsy(1L);
        section80C1.setTutionFees(1L);
        section80C1.setUlip(1L);
        Section10 section102 = mock(Section10.class);
        when(section102.isMetro()).thenReturn(true);
        when(section102.getActualRentPaid()).thenReturn(1L);
        when(section102.getChildEducationAllowance()).thenReturn(1L);
        when(section102.getChildHostelAllowance()).thenReturn(1L);
        when(section102.getHra()).thenReturn(1L);
        when(section102.getLta()).thenReturn(1L);
        when(section102.getOtherRepay()).thenReturn(1L);
        doNothing().when(section102).setActualRentPaid(anyLong());
        doNothing().when(section102).setChildEducationAllowance(anyLong());
        doNothing().when(section102).setChildHostelAllowance(anyLong());
        doNothing().when(section102).setHra(anyLong());
        doNothing().when(section102).setLta(anyLong());
        doNothing().when(section102).setMetro(anyBoolean());
        doNothing().when(section102).setOtherRepay(anyLong());
        doNothing().when(section102).setSection10id(anyLong());
        section102.setActualRentPaid(1L);
        section102.setChildEducationAllowance(1L);
        section102.setChildHostelAllowance(1L);
        section102.setHra(1L);
        section102.setLta(1L);
        section102.setMetro(true);
        section102.setOtherRepay(1L);
        section102.setSection10id(1L);

        Section24 section242 = new Section24();
        section242.setInterest(1L);
        section242.setPropertyTax(1L);
        section242.setRent(1L);
        section242.setSection24id(1L);

        Section80C section80C2 = new Section80C();
        section80C2.setElss(1L);
        section80C2.setEmployeeEpfContri(1L);
        section80C2.setFd(1L);
        section80C2.setHomeLoanPrincipal(1L);
        section80C2.setLic(1L);
        section80C2.setNps_80c(1L);
        section80C2.setNsc(1L);
        section80C2.setPpf(1L);
        section80C2.setSection80cid(1L);
        section80C2.setSsy(1L);
        section80C2.setTutionFees(1L);
        section80C2.setUlip(1L);
        UserDeductions userDeductions1 = mock(UserDeductions.class);
        when(userDeductions1.getSection10()).thenReturn(section102);
        when(userDeductions1.getSection24()).thenReturn(section242);
        when(userDeductions1.getSection80C()).thenReturn(section80C2);
        when(userDeductions1.getAdditionNps()).thenReturn(1L);
        when(userDeductions1.getCharityDonation()).thenReturn(Long.MIN_VALUE);
        when(userDeductions1.getEducationLoanInterest()).thenReturn(1L);
        when(userDeductions1.getEmployerEpfContri()).thenReturn(1L);
        when(userDeductions1.getEmployerNpsContri()).thenReturn(1L);
        when(userDeductions1.getHomeLoanInterest()).thenReturn(1L);
        when(userDeductions1.getMedicalInsurance()).thenReturn(1L);
        when(userDeductions1.getSavingAccountInterest()).thenReturn(3L);
        doNothing().when(userDeductions1).setAdditionNps(anyLong());
        doNothing().when(userDeductions1).setCharityDonation(anyLong());
        doNothing().when(userDeductions1).setDeductionid(anyLong());
        doNothing().when(userDeductions1).setEducationLoanInterest(anyLong());
        doNothing().when(userDeductions1).setEmployerEpfContri(anyLong());
        doNothing().when(userDeductions1).setEmployerNpsContri(anyLong());
        doNothing().when(userDeductions1).setHomeLoanInterest(anyLong());
        doNothing().when(userDeductions1).setMedicalInsurance(anyLong());
        doNothing().when(userDeductions1).setSavingAccountInterest(anyLong());
        doNothing().when(userDeductions1).setSection10((Section10) any());
        doNothing().when(userDeductions1).setSection24((Section24) any());
        doNothing().when(userDeductions1).setSection80C((Section80C) any());
        userDeductions1.setAdditionNps(1L);
        userDeductions1.setCharityDonation(1L);
        userDeductions1.setDeductionid(1L);
        userDeductions1.setEducationLoanInterest(1L);
        userDeductions1.setEmployerEpfContri(1L);
        userDeductions1.setEmployerNpsContri(1L);
        userDeductions1.setHomeLoanInterest(1L);
        userDeductions1.setMedicalInsurance(1L);
        userDeductions1.setSavingAccountInterest(3L);
        userDeductions1.setSection10(section101);
        userDeductions1.setSection24(section241);
        userDeductions1.setSection80C(section80C1);

        UserDetails userDetails1 = new UserDetails();
        userDetails1.setAge(1);
        userDetails1.setBasicSalary(1L);
        userDetails1.setBusinessIncome(1L);
        userDetails1.setCapitalGains(1L);
        userDetails1.setOtherIncome(1L);
        userDetails1.setRentalIncome(1L);
        userDetails1.setSex("Sex");
        userDetails1.setTaxSaved(1L);
        userDetails1.setUserDetailid(1);
        userDetails1.setYear(1);
        User user = mock(User.class);
        when(user.getUserDeductions()).thenReturn(userDeductions1);
        when(user.getUserDetails()).thenReturn(userDetails1);
        doNothing().when(user).setUserCompany((String) any());
        doNothing().when(user).setUserDeductions((UserDeductions) any());
        doNothing().when(user).setUserDetails((UserDetails) any());
        doNothing().when(user).setUserEmail((String) any());
        doNothing().when(user).setUserFirstName((String) any());
        doNothing().when(user).setUserId(anyInt());
        doNothing().when(user).setUserLastName((String) any());
        doNothing().when(user).setUserName((String) any());
        doNothing().when(user).setUserPassword((String) any());
        user.setUserCompany("User Company");
        user.setUserDeductions(userDeductions);
        user.setUserDetails(userDetails);
        user.setUserEmail("jane.doe@example.org");
        user.setUserFirstName("Jane");
        user.setUserId(123);
        user.setUserLastName("Doe");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");
        when(this.userRepository.findByUserEmail((String) any())).thenReturn(user);
        assertEquals(10, this.userService.calculateTaxes("jane.doe@example.org").size());
        verify(this.userRepository).findByUserEmail((String) any());
        verify(user, atLeast(1)).getUserDeductions();
        verify(user, atLeast(1)).getUserDetails();
        verify(user).setUserCompany((String) any());
        verify(user).setUserDeductions((UserDeductions) any());
        verify(user).setUserDetails((UserDetails) any());
        verify(user).setUserEmail((String) any());
        verify(user).setUserFirstName((String) any());
        verify(user).setUserId(anyInt());
        verify(user).setUserLastName((String) any());
        verify(user).setUserName((String) any());
        verify(user).setUserPassword((String) any());
        verify(userDeductions1, atLeast(1)).getSection10();
        verify(userDeductions1, atLeast(1)).getSection24();
        verify(userDeductions1, atLeast(1)).getSection80C();
        verify(userDeductions1).getAdditionNps();
        verify(userDeductions1, atLeast(1)).getCharityDonation();
        verify(userDeductions1).getEducationLoanInterest();
        verify(userDeductions1).getEmployerEpfContri();
        verify(userDeductions1).getEmployerNpsContri();
        verify(userDeductions1).getHomeLoanInterest();
        verify(userDeductions1, atLeast(1)).getMedicalInsurance();
        verify(userDeductions1, atLeast(1)).getSavingAccountInterest();
        verify(userDeductions1).setAdditionNps(anyLong());
        verify(userDeductions1).setCharityDonation(anyLong());
        verify(userDeductions1).setDeductionid(anyLong());
        verify(userDeductions1).setEducationLoanInterest(anyLong());
        verify(userDeductions1).setEmployerEpfContri(anyLong());
        verify(userDeductions1).setEmployerNpsContri(anyLong());
        verify(userDeductions1).setHomeLoanInterest(anyLong());
        verify(userDeductions1).setMedicalInsurance(anyLong());
        verify(userDeductions1).setSavingAccountInterest(anyLong());
        verify(userDeductions1).setSection10((Section10) any());
        verify(userDeductions1).setSection24((Section24) any());
        verify(userDeductions1).setSection80C((Section80C) any());
        verify(section102).isMetro();
        verify(section102).getActualRentPaid();
        verify(section102).getChildEducationAllowance();
        verify(section102).getChildHostelAllowance();
        verify(section102).getHra();
        verify(section102, atLeast(1)).getLta();
        verify(section102).getOtherRepay();
        verify(section102).setActualRentPaid(anyLong());
        verify(section102).setChildEducationAllowance(anyLong());
        verify(section102).setChildHostelAllowance(anyLong());
        verify(section102).setHra(anyLong());
        verify(section102).setLta(anyLong());
        verify(section102).setMetro(anyBoolean());
        verify(section102).setOtherRepay(anyLong());
        verify(section102).setSection10id(anyLong());
    }

    /**
     * Method under test: {@link UserService#getSuggestion(User)}
     */
    @Test
    void testGetSuggestion() {
        Section10 section10 = new Section10();
        section10.setActualRentPaid(1L);
        section10.setChildEducationAllowance(1L);
        section10.setChildHostelAllowance(1L);
        section10.setHra(1L);
        section10.setLta(1L);
        section10.setMetro(true);
        section10.setOtherRepay(1L);
        section10.setSection10id(1L);

        Section24 section24 = new Section24();
        section24.setInterest(1L);
        section24.setPropertyTax(1L);
        section24.setRent(1L);
        section24.setSection24id(1L);

        Section80C section80C = new Section80C();
        section80C.setElss(1L);
        section80C.setEmployeeEpfContri(1L);
        section80C.setFd(1L);
        section80C.setHomeLoanPrincipal(1L);
        section80C.setLic(1L);
        section80C.setNps_80c(1L);
        section80C.setNsc(1L);
        section80C.setPpf(1L);
        section80C.setSection80cid(1L);
        section80C.setSsy(1L);
        section80C.setTutionFees(1L);
        section80C.setUlip(1L);

        UserDeductions userDeductions = new UserDeductions();
        userDeductions.setAdditionNps(1L);
        userDeductions.setCharityDonation(1L);
        userDeductions.setDeductionid(1L);
        userDeductions.setEducationLoanInterest(1L);
        userDeductions.setEmployerEpfContri(1L);
        userDeductions.setEmployerNpsContri(1L);
        userDeductions.setHomeLoanInterest(1L);
        userDeductions.setMedicalInsurance(1L);
        userDeductions.setSavingAccountInterest(3L);
        userDeductions.setSection10(section10);
        userDeductions.setSection24(section24);
        userDeductions.setSection80C(section80C);

        UserDetails userDetails = new UserDetails();
        userDetails.setAge(1);
        userDetails.setBasicSalary(1L);
        userDetails.setBusinessIncome(1L);
        userDetails.setCapitalGains(1L);
        userDetails.setOtherIncome(1L);
        userDetails.setRentalIncome(1L);
        userDetails.setSex("Sex");
        userDetails.setTaxSaved(1L);
        userDetails.setUserDetailid(1);
        userDetails.setYear(1);

        User user = new User();
        user.setUserCompany("User Company");
        user.setUserDeductions(userDeductions);
        user.setUserDetails(userDetails);
        user.setUserEmail("jane.doe@example.org");
        user.setUserFirstName("Jane");
        user.setUserId(123);
        user.setUserLastName("Doe");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");
        assertEquals(5, this.userService.getSuggestion(user).size());
    }

    /**
     * Method under test: {@link UserService#getSuggestion(User)}
     */
    @Test
    void testGetSuggestion2() {
        Section10 section10 = new Section10();
        section10.setActualRentPaid(1L);
        section10.setChildEducationAllowance(1L);
        section10.setChildHostelAllowance(1L);
        section10.setHra(1L);
        section10.setLta(1L);
        section10.setMetro(true);
        section10.setOtherRepay(1L);
        section10.setSection10id(1L);

        Section24 section24 = new Section24();
        section24.setInterest(1L);
        section24.setPropertyTax(1L);
        section24.setRent(1L);
        section24.setSection24id(1L);

        Section80C section80C = new Section80C();
        section80C.setElss(1L);
        section80C.setEmployeeEpfContri(1L);
        section80C.setFd(1L);
        section80C.setHomeLoanPrincipal(1L);
        section80C.setLic(1L);
        section80C.setNps_80c(1L);
        section80C.setNsc(1L);
        section80C.setPpf(1L);
        section80C.setSection80cid(1L);
        section80C.setSsy(1L);
        section80C.setTutionFees(1L);
        section80C.setUlip(1L);

        UserDeductions userDeductions = new UserDeductions();
        userDeductions.setAdditionNps(1L);
        userDeductions.setCharityDonation(1L);
        userDeductions.setDeductionid(1L);
        userDeductions.setEducationLoanInterest(1L);
        userDeductions.setEmployerEpfContri(1L);
        userDeductions.setEmployerNpsContri(1L);
        userDeductions.setHomeLoanInterest(1L);
        userDeductions.setMedicalInsurance(1L);
        userDeductions.setSavingAccountInterest(3L);
        userDeductions.setSection10(section10);
        userDeductions.setSection24(section24);
        userDeductions.setSection80C(section80C);

        UserDetails userDetails = new UserDetails();
        userDetails.setAge(1);
        userDetails.setBasicSalary(1L);
        userDetails.setBusinessIncome(1L);
        userDetails.setCapitalGains(1L);
        userDetails.setOtherIncome(1L);
        userDetails.setRentalIncome(1L);
        userDetails.setSex("Sex");
        userDetails.setTaxSaved(1L);
        userDetails.setUserDetailid(1);
        userDetails.setYear(1);

        Section10 section101 = new Section10();
        section101.setActualRentPaid(1L);
        section101.setChildEducationAllowance(1L);
        section101.setChildHostelAllowance(1L);
        section101.setHra(1L);
        section101.setLta(1L);
        section101.setMetro(true);
        section101.setOtherRepay(1L);
        section101.setSection10id(1L);

        Section24 section241 = new Section24();
        section241.setInterest(1L);
        section241.setPropertyTax(1L);
        section241.setRent(1L);
        section241.setSection24id(1L);

        Section80C section80C1 = new Section80C();
        section80C1.setElss(1L);
        section80C1.setEmployeeEpfContri(1L);
        section80C1.setFd(1L);
        section80C1.setHomeLoanPrincipal(1L);
        section80C1.setLic(1L);
        section80C1.setNps_80c(1L);
        section80C1.setNsc(1L);
        section80C1.setPpf(1L);
        section80C1.setSection80cid(1L);
        section80C1.setSsy(1L);
        section80C1.setTutionFees(1L);
        section80C1.setUlip(1L);

        UserDeductions userDeductions1 = new UserDeductions();
        userDeductions1.setAdditionNps(1L);
        userDeductions1.setCharityDonation(1L);
        userDeductions1.setDeductionid(1L);
        userDeductions1.setEducationLoanInterest(1L);
        userDeductions1.setEmployerEpfContri(1L);
        userDeductions1.setEmployerNpsContri(1L);
        userDeductions1.setHomeLoanInterest(1L);
        userDeductions1.setMedicalInsurance(1L);
        userDeductions1.setSavingAccountInterest(3L);
        userDeductions1.setSection10(section101);
        userDeductions1.setSection24(section241);
        userDeductions1.setSection80C(section80C1);

        UserDetails userDetails1 = new UserDetails();
        userDetails1.setAge(1);
        userDetails1.setBasicSalary(1L);
        userDetails1.setBusinessIncome(1L);
        userDetails1.setCapitalGains(1L);
        userDetails1.setOtherIncome(1L);
        userDetails1.setRentalIncome(1L);
        userDetails1.setSex("Sex");
        userDetails1.setTaxSaved(1L);
        userDetails1.setUserDetailid(1);
        userDetails1.setYear(1);
        User user = mock(User.class);
        when(user.getUserDetails()).thenReturn(userDetails1);
        when(user.getUserDeductions()).thenReturn(userDeductions1);
        doNothing().when(user).setUserCompany((String) any());
        doNothing().when(user).setUserDeductions((UserDeductions) any());
        doNothing().when(user).setUserDetails((UserDetails) any());
        doNothing().when(user).setUserEmail((String) any());
        doNothing().when(user).setUserFirstName((String) any());
        doNothing().when(user).setUserId(anyInt());
        doNothing().when(user).setUserLastName((String) any());
        doNothing().when(user).setUserName((String) any());
        doNothing().when(user).setUserPassword((String) any());
        user.setUserCompany("User Company");
        user.setUserDeductions(userDeductions);
        user.setUserDetails(userDetails);
        user.setUserEmail("jane.doe@example.org");
        user.setUserFirstName("Jane");
        user.setUserId(123);
        user.setUserLastName("Doe");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");
        assertEquals(5, this.userService.getSuggestion(user).size());
        verify(user, atLeast(1)).getUserDeductions();
        verify(user, atLeast(1)).getUserDetails();
        verify(user).setUserCompany((String) any());
        verify(user).setUserDeductions((UserDeductions) any());
        verify(user).setUserDetails((UserDetails) any());
        verify(user).setUserEmail((String) any());
        verify(user).setUserFirstName((String) any());
        verify(user).setUserId(anyInt());
        verify(user).setUserLastName((String) any());
        verify(user).setUserName((String) any());
        verify(user).setUserPassword((String) any());
    }

    /**
     * Method under test: {@link UserService#getSuggestion(User)}
     */
    @Test
    void testGetSuggestion3() {
        Section10 section10 = new Section10();
        section10.setActualRentPaid(1L);
        section10.setChildEducationAllowance(1L);
        section10.setChildHostelAllowance(1L);
        section10.setHra(1L);
        section10.setLta(1L);
        section10.setMetro(true);
        section10.setOtherRepay(1L);
        section10.setSection10id(1L);

        Section24 section24 = new Section24();
        section24.setInterest(1L);
        section24.setPropertyTax(1L);
        section24.setRent(1L);
        section24.setSection24id(1L);

        Section80C section80C = new Section80C();
        section80C.setElss(1L);
        section80C.setEmployeeEpfContri(1L);
        section80C.setFd(1L);
        section80C.setHomeLoanPrincipal(1L);
        section80C.setLic(1L);
        section80C.setNps_80c(1L);
        section80C.setNsc(1L);
        section80C.setPpf(1L);
        section80C.setSection80cid(1L);
        section80C.setSsy(1L);
        section80C.setTutionFees(1L);
        section80C.setUlip(1L);

        UserDeductions userDeductions = new UserDeductions();
        userDeductions.setAdditionNps(1L);
        userDeductions.setCharityDonation(1L);
        userDeductions.setDeductionid(1L);
        userDeductions.setEducationLoanInterest(1L);
        userDeductions.setEmployerEpfContri(1L);
        userDeductions.setEmployerNpsContri(1L);
        userDeductions.setHomeLoanInterest(1L);
        userDeductions.setMedicalInsurance(1L);
        userDeductions.setSavingAccountInterest(3L);
        userDeductions.setSection10(section10);
        userDeductions.setSection24(section24);
        userDeductions.setSection80C(section80C);

        UserDetails userDetails = new UserDetails();
        userDetails.setAge(1);
        userDetails.setBasicSalary(1L);
        userDetails.setBusinessIncome(1L);
        userDetails.setCapitalGains(1L);
        userDetails.setOtherIncome(1L);
        userDetails.setRentalIncome(1L);
        userDetails.setSex("Sex");
        userDetails.setTaxSaved(1L);
        userDetails.setUserDetailid(1);
        userDetails.setYear(1);

        Section10 section101 = new Section10();
        section101.setActualRentPaid(1L);
        section101.setChildEducationAllowance(1L);
        section101.setChildHostelAllowance(1L);
        section101.setHra(1L);
        section101.setLta(1L);
        section101.setMetro(true);
        section101.setOtherRepay(1L);
        section101.setSection10id(1L);

        Section24 section241 = new Section24();
        section241.setInterest(1L);
        section241.setPropertyTax(1L);
        section241.setRent(1L);
        section241.setSection24id(1L);

        Section80C section80C1 = new Section80C();
        section80C1.setElss(1L);
        section80C1.setEmployeeEpfContri(1L);
        section80C1.setFd(1L);
        section80C1.setHomeLoanPrincipal(1L);
        section80C1.setLic(1L);
        section80C1.setNps_80c(1L);
        section80C1.setNsc(1L);
        section80C1.setPpf(1L);
        section80C1.setSection80cid(1L);
        section80C1.setSsy(1L);
        section80C1.setTutionFees(1L);
        section80C1.setUlip(1L);

        UserDeductions userDeductions1 = new UserDeductions();
        userDeductions1.setAdditionNps(1L);
        userDeductions1.setCharityDonation(1L);
        userDeductions1.setDeductionid(1L);
        userDeductions1.setEducationLoanInterest(1L);
        userDeductions1.setEmployerEpfContri(1L);
        userDeductions1.setEmployerNpsContri(1L);
        userDeductions1.setHomeLoanInterest(1L);
        userDeductions1.setMedicalInsurance(1L);
        userDeductions1.setSavingAccountInterest(3L);
        userDeductions1.setSection10(section101);
        userDeductions1.setSection24(section241);
        userDeductions1.setSection80C(section80C1);

        UserDetails userDetails1 = new UserDetails();
        userDetails1.setAge(1);
        userDetails1.setBasicSalary(150000L);
        userDetails1.setBusinessIncome(1L);
        userDetails1.setCapitalGains(1L);
        userDetails1.setOtherIncome(1L);
        userDetails1.setRentalIncome(1L);
        userDetails1.setSex("Sex");
        userDetails1.setTaxSaved(1L);
        userDetails1.setUserDetailid(1);
        userDetails1.setYear(1);
        User user = mock(User.class);
        when(user.getUserDetails()).thenReturn(userDetails1);
        when(user.getUserDeductions()).thenReturn(userDeductions1);
        doNothing().when(user).setUserCompany((String) any());
        doNothing().when(user).setUserDeductions((UserDeductions) any());
        doNothing().when(user).setUserDetails((UserDetails) any());
        doNothing().when(user).setUserEmail((String) any());
        doNothing().when(user).setUserFirstName((String) any());
        doNothing().when(user).setUserId(anyInt());
        doNothing().when(user).setUserLastName((String) any());
        doNothing().when(user).setUserName((String) any());
        doNothing().when(user).setUserPassword((String) any());
        user.setUserCompany("User Company");
        user.setUserDeductions(userDeductions);
        user.setUserDetails(userDetails);
        user.setUserEmail("jane.doe@example.org");
        user.setUserFirstName("Jane");
        user.setUserId(123);
        user.setUserLastName("Doe");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");
        assertEquals(6, this.userService.getSuggestion(user).size());
        verify(user, atLeast(1)).getUserDeductions();
        verify(user, atLeast(1)).getUserDetails();
        verify(user).setUserCompany((String) any());
        verify(user).setUserDeductions((UserDeductions) any());
        verify(user).setUserDetails((UserDetails) any());
        verify(user).setUserEmail((String) any());
        verify(user).setUserFirstName((String) any());
        verify(user).setUserId(anyInt());
        verify(user).setUserLastName((String) any());
        verify(user).setUserName((String) any());
        verify(user).setUserPassword((String) any());
    }

    /**
     * Method under test: {@link UserService#getSuggestion(User)}
     */
    @Test
    void testGetSuggestion4() {
        Section10 section10 = new Section10();
        section10.setActualRentPaid(1L);
        section10.setChildEducationAllowance(1L);
        section10.setChildHostelAllowance(1L);
        section10.setHra(1L);
        section10.setLta(1L);
        section10.setMetro(true);
        section10.setOtherRepay(1L);
        section10.setSection10id(1L);

        Section24 section24 = new Section24();
        section24.setInterest(1L);
        section24.setPropertyTax(1L);
        section24.setRent(1L);
        section24.setSection24id(1L);

        Section80C section80C = new Section80C();
        section80C.setElss(1L);
        section80C.setEmployeeEpfContri(1L);
        section80C.setFd(1L);
        section80C.setHomeLoanPrincipal(1L);
        section80C.setLic(1L);
        section80C.setNps_80c(1L);
        section80C.setNsc(1L);
        section80C.setPpf(1L);
        section80C.setSection80cid(1L);
        section80C.setSsy(1L);
        section80C.setTutionFees(1L);
        section80C.setUlip(1L);

        UserDeductions userDeductions = new UserDeductions();
        userDeductions.setAdditionNps(1L);
        userDeductions.setCharityDonation(1L);
        userDeductions.setDeductionid(1L);
        userDeductions.setEducationLoanInterest(1L);
        userDeductions.setEmployerEpfContri(1L);
        userDeductions.setEmployerNpsContri(1L);
        userDeductions.setHomeLoanInterest(1L);
        userDeductions.setMedicalInsurance(1L);
        userDeductions.setSavingAccountInterest(3L);
        userDeductions.setSection10(section10);
        userDeductions.setSection24(section24);
        userDeductions.setSection80C(section80C);

        UserDetails userDetails = new UserDetails();
        userDetails.setAge(1);
        userDetails.setBasicSalary(1L);
        userDetails.setBusinessIncome(1L);
        userDetails.setCapitalGains(1L);
        userDetails.setOtherIncome(1L);
        userDetails.setRentalIncome(1L);
        userDetails.setSex("Sex");
        userDetails.setTaxSaved(1L);
        userDetails.setUserDetailid(1);
        userDetails.setYear(1);

        Section10 section101 = new Section10();
        section101.setActualRentPaid(1L);
        section101.setChildEducationAllowance(1L);
        section101.setChildHostelAllowance(1L);
        section101.setHra(1L);
        section101.setLta(1L);
        section101.setMetro(true);
        section101.setOtherRepay(1L);
        section101.setSection10id(1L);

        Section24 section241 = new Section24();
        section241.setInterest(1L);
        section241.setPropertyTax(1L);
        section241.setRent(1L);
        section241.setSection24id(1L);

        Section80C section80C1 = new Section80C();
        section80C1.setElss(1L);
        section80C1.setEmployeeEpfContri(1L);
        section80C1.setFd(1L);
        section80C1.setHomeLoanPrincipal(1L);
        section80C1.setLic(1L);
        section80C1.setNps_80c(1L);
        section80C1.setNsc(1L);
        section80C1.setPpf(1L);
        section80C1.setSection80cid(1L);
        section80C1.setSsy(1L);
        section80C1.setTutionFees(1L);
        section80C1.setUlip(1L);

        Section10 section102 = new Section10();
        section102.setActualRentPaid(1L);
        section102.setChildEducationAllowance(1L);
        section102.setChildHostelAllowance(1L);
        section102.setHra(1L);
        section102.setLta(1L);
        section102.setMetro(true);
        section102.setOtherRepay(1L);
        section102.setSection10id(1L);

        Section24 section242 = new Section24();
        section242.setInterest(-1L);
        section242.setPropertyTax(1L);
        section242.setRent(1L);
        section242.setSection24id(1L);

        Section80C section80C2 = new Section80C();
        section80C2.setElss(1L);
        section80C2.setEmployeeEpfContri(1L);
        section80C2.setFd(1L);
        section80C2.setHomeLoanPrincipal(1L);
        section80C2.setLic(1L);
        section80C2.setNps_80c(1L);
        section80C2.setNsc(1L);
        section80C2.setPpf(1L);
        section80C2.setSection80cid(1L);
        section80C2.setSsy(1L);
        section80C2.setTutionFees(1L);
        section80C2.setUlip(1L);
        UserDeductions userDeductions1 = mock(UserDeductions.class);
        when(userDeductions1.getCharityDonation()).thenReturn(1L);
        when(userDeductions1.getMedicalInsurance()).thenReturn(1L);
        when(userDeductions1.getSavingAccountInterest()).thenReturn(3L);
        when(userDeductions1.getSection10()).thenReturn(section102);
        when(userDeductions1.getSection24()).thenReturn(section242);
        when(userDeductions1.getSection80C()).thenReturn(section80C2);
        doNothing().when(userDeductions1).setAdditionNps(anyLong());
        doNothing().when(userDeductions1).setCharityDonation(anyLong());
        doNothing().when(userDeductions1).setDeductionid(anyLong());
        doNothing().when(userDeductions1).setEducationLoanInterest(anyLong());
        doNothing().when(userDeductions1).setEmployerEpfContri(anyLong());
        doNothing().when(userDeductions1).setEmployerNpsContri(anyLong());
        doNothing().when(userDeductions1).setHomeLoanInterest(anyLong());
        doNothing().when(userDeductions1).setMedicalInsurance(anyLong());
        doNothing().when(userDeductions1).setSavingAccountInterest(anyLong());
        doNothing().when(userDeductions1).setSection10((Section10) any());
        doNothing().when(userDeductions1).setSection24((Section24) any());
        doNothing().when(userDeductions1).setSection80C((Section80C) any());
        userDeductions1.setAdditionNps(1L);
        userDeductions1.setCharityDonation(1L);
        userDeductions1.setDeductionid(1L);
        userDeductions1.setEducationLoanInterest(1L);
        userDeductions1.setEmployerEpfContri(1L);
        userDeductions1.setEmployerNpsContri(1L);
        userDeductions1.setHomeLoanInterest(1L);
        userDeductions1.setMedicalInsurance(1L);
        userDeductions1.setSavingAccountInterest(3L);
        userDeductions1.setSection10(section101);
        userDeductions1.setSection24(section241);
        userDeductions1.setSection80C(section80C1);

        UserDetails userDetails1 = new UserDetails();
        userDetails1.setAge(1);
        userDetails1.setBasicSalary(1L);
        userDetails1.setBusinessIncome(1L);
        userDetails1.setCapitalGains(1L);
        userDetails1.setOtherIncome(1L);
        userDetails1.setRentalIncome(1L);
        userDetails1.setSex("Sex");
        userDetails1.setTaxSaved(1L);
        userDetails1.setUserDetailid(1);
        userDetails1.setYear(1);
        User user = mock(User.class);
        when(user.getUserDetails()).thenReturn(userDetails1);
        when(user.getUserDeductions()).thenReturn(userDeductions1);
        doNothing().when(user).setUserCompany((String) any());
        doNothing().when(user).setUserDeductions((UserDeductions) any());
        doNothing().when(user).setUserDetails((UserDetails) any());
        doNothing().when(user).setUserEmail((String) any());
        doNothing().when(user).setUserFirstName((String) any());
        doNothing().when(user).setUserId(anyInt());
        doNothing().when(user).setUserLastName((String) any());
        doNothing().when(user).setUserName((String) any());
        doNothing().when(user).setUserPassword((String) any());
        user.setUserCompany("User Company");
        user.setUserDeductions(userDeductions);
        user.setUserDetails(userDetails);
        user.setUserEmail("jane.doe@example.org");
        user.setUserFirstName("Jane");
        user.setUserId(123);
        user.setUserLastName("Doe");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");
        assertEquals(5, this.userService.getSuggestion(user).size());
        verify(user, atLeast(1)).getUserDeductions();
        verify(user, atLeast(1)).getUserDetails();
        verify(user).setUserCompany((String) any());
        verify(user).setUserDeductions((UserDeductions) any());
        verify(user).setUserDetails((UserDetails) any());
        verify(user).setUserEmail((String) any());
        verify(user).setUserFirstName((String) any());
        verify(user).setUserId(anyInt());
        verify(user).setUserLastName((String) any());
        verify(user).setUserName((String) any());
        verify(user).setUserPassword((String) any());
        verify(userDeductions1).getSection10();
        verify(userDeductions1).getSection24();
        verify(userDeductions1).getSection80C();
        verify(userDeductions1).getCharityDonation();
        verify(userDeductions1).getMedicalInsurance();
        verify(userDeductions1).getSavingAccountInterest();
        verify(userDeductions1).setAdditionNps(anyLong());
        verify(userDeductions1).setCharityDonation(anyLong());
        verify(userDeductions1).setDeductionid(anyLong());
        verify(userDeductions1).setEducationLoanInterest(anyLong());
        verify(userDeductions1).setEmployerEpfContri(anyLong());
        verify(userDeductions1).setEmployerNpsContri(anyLong());
        verify(userDeductions1).setHomeLoanInterest(anyLong());
        verify(userDeductions1).setMedicalInsurance(anyLong());
        verify(userDeductions1).setSavingAccountInterest(anyLong());
        verify(userDeductions1).setSection10((Section10) any());
        verify(userDeductions1).setSection24((Section24) any());
        verify(userDeductions1).setSection80C((Section80C) any());
    }

    /**
     * Method under test: {@link UserService#deleteAllUsers()}
     */
    @Test
    void testDeleteAllUsers() {
        doNothing().when(this.userRepository).deleteAll();
        assertEquals("Successfully Deleted All Records", this.userService.deleteAllUsers());
        verify(this.userRepository).deleteAll();
    }

    /**
     * Method under test: {@link UserService#deleteSingleUser(String)}
     */
    @Test
    void testDeleteSingleUser() throws UserNotFoundException {
        Section10 section10 = new Section10();
        section10.setActualRentPaid(1L);
        section10.setChildEducationAllowance(1L);
        section10.setChildHostelAllowance(1L);
        section10.setHra(1L);
        section10.setLta(1L);
        section10.setMetro(true);
        section10.setOtherRepay(1L);
        section10.setSection10id(1L);

        Section24 section24 = new Section24();
        section24.setInterest(1L);
        section24.setPropertyTax(1L);
        section24.setRent(1L);
        section24.setSection24id(1L);

        Section80C section80C = new Section80C();
        section80C.setElss(1L);
        section80C.setEmployeeEpfContri(1L);
        section80C.setFd(1L);
        section80C.setHomeLoanPrincipal(1L);
        section80C.setLic(1L);
        section80C.setNps_80c(1L);
        section80C.setNsc(1L);
        section80C.setPpf(1L);
        section80C.setSection80cid(1L);
        section80C.setSsy(1L);
        section80C.setTutionFees(1L);
        section80C.setUlip(1L);

        UserDeductions userDeductions = new UserDeductions();
        userDeductions.setAdditionNps(1L);
        userDeductions.setCharityDonation(1L);
        userDeductions.setDeductionid(1L);
        userDeductions.setEducationLoanInterest(1L);
        userDeductions.setEmployerEpfContri(1L);
        userDeductions.setEmployerNpsContri(1L);
        userDeductions.setHomeLoanInterest(1L);
        userDeductions.setMedicalInsurance(1L);
        userDeductions.setSavingAccountInterest(3L);
        userDeductions.setSection10(section10);
        userDeductions.setSection24(section24);
        userDeductions.setSection80C(section80C);

        UserDetails userDetails = new UserDetails();
        userDetails.setAge(1);
        userDetails.setBasicSalary(1L);
        userDetails.setBusinessIncome(1L);
        userDetails.setCapitalGains(1L);
        userDetails.setOtherIncome(1L);
        userDetails.setRentalIncome(1L);
        userDetails.setSex("Sex");
        userDetails.setTaxSaved(1L);
        userDetails.setUserDetailid(1);
        userDetails.setYear(1);

        User user = new User();
        user.setUserCompany("User Company");
        user.setUserDeductions(userDeductions);
        user.setUserDetails(userDetails);
        user.setUserEmail("jane.doe@example.org");
        user.setUserFirstName("Jane");
        user.setUserId(123);
        user.setUserLastName("Doe");
        user.setUserName("janedoe");
        user.setUserPassword("iloveyou");
        doNothing().when(this.userRepository).delete((User) any());
        when(this.userRepository.findByUserEmail((String) any())).thenReturn(user);
        assertEquals("User Deleted from Records", this.userService.deleteSingleUser("jane.doe@example.org"));
        verify(this.userRepository).findByUserEmail((String) any());
        verify(this.userRepository).delete((User) any());
    }

    /**
     * Method under test: {@link UserService#getCountOfUsers()}
     */
    @Test
    void testGetCountOfUsers() {
        when(this.userRepository.count()).thenReturn(3L);
        assertEquals(3L, this.userService.getCountOfUsers());
        verify(this.userRepository).count();
    }

    @Test
    void addNewUser() {
    }

    @Test
    void getUserbyEmailId() {
    }

    @Test
    void updateExistingUser() {
    }

    @Test
    void setNewPassword() {
    }

    @Test
    void calculateTaxes() {
    }

    @Test
    void deleteAllUsers() {
    }

    @Test
    void deleteSingleUser() {
    }

    @Test
    void getCountOfUsers() {
    }
}
package com.hashedin.huTaxer.Modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity(name = "user_deduction")
public class UserDeductions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long deductionid;

    private long employerEpfContri;
    private long additionNps;
    private long employerNpsContri;
    private long medicalInsurance; //CHildren + Parent;

    private long educationLoanInterest;
    private long HomeLoanInterest;
    private long savingAccountInterest;

    private long charityDonation;


    @OneToOne(cascade = CascadeType.ALL)
    private Section24 section24;


    @OneToOne(cascade = CascadeType.ALL)
    private Section80C section80C;

    @OneToOne(cascade = CascadeType.ALL)
    private Section10 section10;

    public UserDeductions(){
        this.section10 = new Section10();
        this.section24 = new Section24();
        this.section80C = new Section80C();
    }

}

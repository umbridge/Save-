package com.hashedin.huTaxer.Modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@Entity(name = "user_details")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userDetailid;

    private int year;

    private int age;


    private String sex;

    private long basicSalary;
    private long taxSaved;
    private long rentalIncome;
    private long otherIncome;
    private long capitalGains;
    private long businessIncome;

    public UserDetails() {
        this.basicSalary = 0;
        this.sex = "female";
        this.age = 59;
        this.year = 2022;
    }


}

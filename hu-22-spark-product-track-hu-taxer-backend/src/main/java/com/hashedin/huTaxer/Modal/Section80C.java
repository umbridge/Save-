package com.hashedin.huTaxer.Modal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "section_80C")
public class Section80C {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long section80cid;

    private long ppf;   // max range 1.5lac min = 500
    private long employeeEpfContri;
    private long nsc;
    private long elss; //Equity Linked Saving Schemep
    private long ulip; //Unit Linked Insurance Plan
    private long lic;
    private long fd;      // less than 1.5lac
    private long ssy;//sukanya samridhi Yojna     less than 1.5lac
    private long homeLoanPrincipal;
    private long tutionFees;
    private long nps_80c;

}

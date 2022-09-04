package com.hashedin.huTaxer.Modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "section_10")
public class Section10 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long section10id;

    @Column(columnDefinition = "boolean default false")
    private boolean isMetro;
    private long actualRentPaid;
    private long hra;
    private long lta;
    private long childEducationAllowance;
    private long childHostelAllowance;
    private long otherRepay;



}

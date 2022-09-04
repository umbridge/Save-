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
@Entity(name = "section24")
public class Section24 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long section24id;

    private long rent;
    private long propertyTax;
    private long interest;
}

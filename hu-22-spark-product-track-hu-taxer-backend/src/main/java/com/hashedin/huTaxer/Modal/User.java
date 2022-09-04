package com.hashedin.huTaxer.Modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @NotNull(message = "FirstName is not Valid ")
    private String userFirstName;

    @NotNull(message = "LastName is not Valid ")
    private String userLastName;

    @Column(unique=true)
    @NotNull(message = "Name is not Valid ")
    private String userName;


    @Column(unique=true)
    @NotNull
    @Email(message = "Email is not Valid ")
    private String userEmail;
    @NotNull(message = "Company Name is not Valid ")
    private String userCompany;
    @Length(min = 8, message = "Password Size should be atleast 8 ")
    @NotNull(message = "Password can't be  Null")
    private String userPassword;


    @OneToOne(cascade = CascadeType.ALL)
    private UserDetails userDetails;

    @OneToOne(cascade = CascadeType.ALL)
    private UserDeductions userDeductions;

    public User() {
    this.userDetails = new UserDetails();
    this.userDeductions = new UserDeductions();
    }


}

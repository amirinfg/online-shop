package com.amir.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.security.SecureRandom;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingAddress extends Audit implements Serializable {
    private static final Long serialVersionUID = 105l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billingAddressId;

    @NotEmpty
    private String city;

    @NotEmpty
    private String state;

    @NotEmpty
    private String country;

    @NotEmpty
    private String streetName;

    @NotEmpty
    private String apartmentNumber;

    @NotEmpty
    private String zipCode;

}
package com.amir.data.entities;

import com.amir.validators.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends Audit implements Serializable {

    private static final Long serialVersionUID = 102l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotEmpty
    @Size(min = 5 , max = 30)
    private String name;


    @NotEmpty
    @Email
    private String customerEmail;

    @NotEmpty
    @Phone
    private String customerPhoneNumber;

    @NotEmpty
    @Size(min = 3 , max = 30)
    private String username;

    @NotEmpty
    private String password;

    private boolean enabled;


    @OneToOne(mappedBy = "customer")
    private Cart cart;



    @Valid
    @OneToOne
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;



    @Valid
    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;


}
package com.amir.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.concurrent.CompletionStage;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrder extends Audit implements Serializable {

    private static final long serialVersionUID = 9L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerOrderId;

    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;


    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToOne
    @JoinColumn(name ="shippingAddressId")
    private ShippingAddress shippingAddress;

    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;

}
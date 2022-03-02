package com.amir.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.management.LockInfo;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem extends Audit implements Serializable {
    private static final Long serialVersionUID = 107l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;


    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;


    @ManyToOne
    @JoinColumn(name ="productId")
    private Product product;









}
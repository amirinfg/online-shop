package com.amir.controllers;

import com.amir.data.entities.BillingAddress;
import com.amir.data.entities.Customer;
import com.amir.data.entities.ShippingAddress;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.SecureRandom;

@Controller
@RequestMapping("/customer")
public class RegisterController {

    @RequestMapping("/register")
    public String registerCustomer(Model model){
        Customer customer = new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);
        model.addAttribute("customer" , customer);
        return "registerCustomer";



    }
}
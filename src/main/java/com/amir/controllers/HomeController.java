package com.amir.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/" , "/home"})
public class HomeController {
    @RequestMapping({"/" , "/home"})
    public String home(){
        return "home";
    }

}
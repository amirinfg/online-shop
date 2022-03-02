package com.amir.controllers;

import com.amir.models.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/product/rest")
public class ProductRestService {

    @Autowired
    Logger logger;

    ArrayList<ProductDTO> list = new ArrayList<ProductDTO>() {
        {
            add(new ProductDTO(1, "a", 1000, "home"));
            add(new ProductDTO(2, "b", 2000, "work"));
        }
    };

    @GetMapping(value = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO detail(@PathVariable("id") int id) {
        logger.debug(id);
        return list.get(0);
    }

}
package com.amir.controllers;

import com.amir.models.ProductDTO;
import com.amir.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping("/product")
@Log4j
@AllArgsConstructor
public class ProductController {






    ProductService productService;


    @GetMapping("/show")
    public String show(@ModelAttribute("dto") ProductDTO productDTO) {
        return "product-show";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("dto") ProductDTO.CREATE productDTO, BindingResult result, Locale locale) {

        // messageSource.getMessage("error.name" , new Locale(locale.getLanguage()));

        if (result.hasErrors()) {
            //Post Back
            return "product-show";
        }
        log.debug(productDTO);
        productService.save(productDTO);
        return "redirect:/";
    }

    @GetMapping("/get-all")
    public String getAll(Model model) {
        List<ProductDTO> productDTOList = productService.findAll();
        model.addAttribute("products" , productDTOList);
        return "product-list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id) {

        return "product-detail";
    }

    @GetMapping("/delete")
    public String delete(ProductDTO.DELETE delete){
        productService.delete(delete);


        return "redirect:/product/get-all";

    }



}
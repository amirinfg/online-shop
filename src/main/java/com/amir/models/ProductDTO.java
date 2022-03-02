package com.amir.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@ToString
@Component
@AllArgsConstructor
public class ProductDTO {

    private int id;
    @NotEmpty
    @Size(min=3 , message = "{error.name}")
    private String name;
    @Min(value = 1000 , message = "{error.price}")
    private int price;
    private String type;

    private String color;

    private ArrayList<Integer> sizes;

    private Map<String,String> validTypes;

    public ProductDTO(){
        validTypes = new HashMap<>();
        validTypes.put("1","home");
        validTypes.put("2","work");
        validTypes.put("3","school");
    }

    public ProductDTO(int id, String name, int price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public static class CREATE extends ProductDTO {

    }
    @Data
    public static class DELETE {
        private int id;
    }

}
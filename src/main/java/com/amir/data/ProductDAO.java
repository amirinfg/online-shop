package com.amir.data;

import com.amir.data.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductDAO {

    void save(Product product);

    List<Product> findAll();

    void delete(int id);
}
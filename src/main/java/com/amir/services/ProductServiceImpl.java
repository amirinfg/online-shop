package com.amir.services;

import com.amir.data.ProductDAO;
import com.amir.data.entities.Product;
import com.amir.models.ProductDTO;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@Log4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void save(ProductDTO dto) {
        Product product = modelMapper.map(dto, Product.class);
        productDAO.save(product);
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = productDAO.findAll();
        List<ProductDTO> productDTOList = products.stream().map(product -> modelMapper.map(product , ProductDTO.class )).collect(Collectors.toList());
        //modelMapper.map(products, productDTOList);
        return productDTOList;
    }

    @Override
    public void delete(ProductDTO.DELETE delete) {
        log.info(delete);
        productDAO.delete(delete.getId());
    }


}
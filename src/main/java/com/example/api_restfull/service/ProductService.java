package com.example.api_restfull.service;

import com.example.api_restfull.converter.ProductMapper;
import com.example.api_restfull.dto.ProductDto;
import com.example.api_restfull.entity.Product;
import com.example.api_restfull.exceptions.MyException;
import com.example.api_restfull.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProductService {

    @Autowired
    ProductRepository productReposity;

    @Autowired
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productReposity, ProductMapper productMapper) {
        this.productReposity = productReposity;
        this.productMapper = productMapper;
    }

    @Transactional
    public void addProduct(ProductDto productoDto) throws MyException {

        Product product = productMapper.convertToEntity(productoDto);

        productReposity.save(product);

    }


}

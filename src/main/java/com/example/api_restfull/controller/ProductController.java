package com.example.api_restfull.controller;
import com.example.api_restfull.dto.ClientDto;
import com.example.api_restfull.dto.ProductDto;
import com.example.api_restfull.exceptions.MyException;
import com.example.api_restfull.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> addProduct(@Validated @RequestBody ProductDto productDto) throws MyException {
        productService.addProduct(productDto);
        return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<String> updateClient(@PathVariable Long productId, @Validated @RequestBody ProductDto updatedProductDto) throws MyException {
        productService.updateClient(productId, updatedProductDto);
        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> lstProducts = productService.getAllProducts();
        return new ResponseEntity<>(lstProducts, HttpStatus.OK);
    }


}

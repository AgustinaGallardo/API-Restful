package com.example.api_restfull.converter;

import com.example.api_restfull.dto.OrderDto;
import com.example.api_restfull.dto.ProductDto;
import com.example.api_restfull.entity.Order;
import com.example.api_restfull.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    private final ModelMapper modelMapper;

    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductDto convertToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    public Product convertToEntity(ProductDto product) {
        return modelMapper.map(product, Product.class);
    }
}

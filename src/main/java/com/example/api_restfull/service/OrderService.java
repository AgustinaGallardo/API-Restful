package com.example.api_restfull.service;
import com.example.api_restfull.converter.OrderMapper;
import com.example.api_restfull.dto.OrderDto;
import com.example.api_restfull.entity.Client;
import com.example.api_restfull.entity.Order;
import com.example.api_restfull.entity.Product;
import com.example.api_restfull.exceptions.MyException;
import com.example.api_restfull.repository.ClientRepository;
import com.example.api_restfull.repository.OrderRepository;
import com.example.api_restfull.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProductRepository productRepository;

    OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Transactional
    public OrderDto addOrder(OrderDto orderDto) throws MyException {

        validate(orderDto);
        Order order = orderMapper.convertToEntity(orderDto);
        Client client = clientRepository.findById(order.getClientOrder()
                .getIdClient()).orElse(null);
        
        order.setClientOrder(client);
        List<Product> products = new ArrayList<>();
        for (Long productId : orderDto.getProductIds()) {
            Product product = productRepository.findById(productId).orElse(null);
            if (product != null) {
                products.add(product);
            }
        }
        order.setProducts(products);

        Order savedOrder = orderRepository.save(order);

        return orderMapper.convertToDto(savedOrder);
    }

    private void validate(OrderDto orderDto) throws MyException {
        if (orderDto.getDate() == null) {
            throw new MyException("Date can't be null or empty");
        }
        if (orderDto.getOrderNumber() == null) {
            throw new MyException("Orders number can't be null or empty");
        }

    }


}

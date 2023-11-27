package com.example.api_restfull.service;
import com.example.api_restfull.converter.OrderMapper;
import com.example.api_restfull.dto.OrderDto;
import com.example.api_restfull.entity.Order;
import com.example.api_restfull.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Transactional
    public void addOrder(OrderDto orderDto){
        Order order = orderMapper.convertToEntity(orderDto);
        //order.setDateOrder();  buscar poner
        orderRepository.save(order);
    }


}

package com.example.api_restfull.controller;

import com.example.api_restfull.dto.OrderDto;
import com.example.api_restfull.exceptions.MyException;
import com.example.api_restfull.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
public class OrderController {
    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> addOrder(@RequestBody OrderDto orderDto) throws MyException {
        orderService.addOrder(orderDto);
        return new ResponseEntity<>("Order added successfully", HttpStatus.CREATED);
    }

}

package com.example.api_restfull.service;
import com.example.api_restfull.entity.Client;
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



    @Transactional
    private void createOrder(Client client, Date date){




    }


}

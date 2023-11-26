package com.example.api_restfull.converter;
import com.example.api_restfull.dto.OrderDto;
import com.example.api_restfull.entity.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    private final ModelMapper modelMapper;
    public OrderMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public OrderDto convertToDto(Order order) {
        return modelMapper.map(order, OrderDto.class);
    }
    public Order convertToEntity(OrderDto order) {
        return modelMapper.map(order, Order.class);
    }
}

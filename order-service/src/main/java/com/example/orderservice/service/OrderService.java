package com.example.orderservice.service;

import com.example.orderservice.client.UserClient;
import com.example.orderservice.dto.UserDto;
import com.example.orderservice.response.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final UserClient userClient;

    public OrderService(UserClient userClient) {
        this.userClient = userClient;
    }

    public OrderResponse createOrder(Long userId){
        UserDto userDto = userClient.getUserById(userId);
        return new OrderResponse(101L, "Order Created!!", userDto.getName());
    }
}

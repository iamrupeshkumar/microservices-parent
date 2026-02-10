package com.example.orderservice.service;

import com.example.dto.UserDto;
import com.example.orderservice.client.UserClient;
import com.example.orderservice.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final UserClient userClient;

    public OrderResponse createOrder(Long userId){
        UserDto userDto = userClient.getUserById(userId);
        return new OrderResponse(101L, "Order Created!!", userDto.getName());
    }
}

package com.example.orderservice.service;

import com.example.dto.UserDto;
import com.example.error.ErrorCode;
import com.example.exception.BusinessException;
import com.example.orderservice.client.UserClient;
import com.example.orderservice.response.OrderResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final UserClient userClient;

    @CircuitBreaker(name = "userService", fallbackMethod = "createOrderFallback")
    public OrderResponse createOrder(Long userId){
        UserDto userDto = userClient.getUserById(userId);
        return new OrderResponse(101L, "Order Created!!", userDto.getName());
    }

    public OrderResponse createOrderFallback(Long userId, Exception ex){
        throw new BusinessException(ErrorCode.INTERNAL_SERVER_ERROR, "User service is currently unavailable");
    }
}

package com.example.orderservice.service;

import com.example.dto.UserDto;
import com.example.error.ErrorCode;
import com.example.exception.BusinessException;
import com.example.exception.ResourceNotFoundException;
import com.example.orderservice.client.UserClient;
import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.response.OrderResponse;
import com.example.response.ApiResponse;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final UserClient userClient;

    private final OrderRepository orderRepository;

    @CircuitBreaker(name = "userService", fallbackMethod = "createOrderFallback")
    public Order createOrder(Order order) {

        ApiResponse<UserDto> response =
                userClient.getUserById(order.getUserId());

        return orderRepository.save(order);
    }

    public Order createOrderFallback(Order order, Throwable ex) {

        Throwable cause = (ex instanceof ExecutionException && ex.getCause() != null)
                ? ex.getCause()
                : ex;

        if (cause instanceof BusinessException) {
            throw (BusinessException) cause;
        }

        throw new BusinessException(
                ErrorCode.SERVICE_UNAVAILABLE,
                "User service is currently unavailable!!"
        );
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Order not found with id: "+id
        ));
    }
}

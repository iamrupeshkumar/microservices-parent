package com.example.orderservice.controller;

import com.example.orderservice.entity.Order;
import com.example.orderservice.response.OrderResponse;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.utils.MappingConstant;
import com.example.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(MappingConstant.OrderMapping.BASE)
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping(MappingConstant.OrderMapping.HELLO)
    public String greet(){
        return "Hello from Order Service!!";
    }

    @PostMapping(MappingConstant.OrderMapping.CREATE)
    public ApiResponse<Order> placeOrder(@RequestBody Order order){
        Order orderResponse = orderService.createOrder(order);
        return ApiResponse.<Order>builder()
                .success(true)
                .message("Order placed successfully")
                .data(orderResponse)
                .error(null)
                .timestamp(LocalDateTime.now())
                .build();
    }

    @GetMapping
    public ApiResponse<List<Order>> getAllOrders(){

        return ApiResponse.<List<Order>>builder()
                .success(true)
                .message("Orders fetched successfully")
                .data(orderService.getOrders())
                .error(null)
                .timestamp(LocalDateTime.now())
                .build();
    }

    @GetMapping(MappingConstant.OrderMapping.GET_BY_ID)
    public ApiResponse<Order> getOrderById(@PathVariable("id") Long id){
        return ApiResponse.<Order>builder()
                .success(true)
                .message("Order fetched successfully")
                .data(orderService.getOrderById(id))
                .error(null)
                .timestamp(LocalDateTime.now())
                .build();
    }

}

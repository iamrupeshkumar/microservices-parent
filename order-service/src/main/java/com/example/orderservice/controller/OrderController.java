package com.example.orderservice.controller;

import com.example.orderservice.response.OrderResponse;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/hello")
    public String greet(){
        return "Hello from Order Service!!";
    }

    @GetMapping("/{userId}")
    public OrderResponse placeOrder(@PathVariable("userId") Long userId){
        return orderService.createOrder(userId);
    }

}

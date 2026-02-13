package com.example.orderservice.controller;

import com.example.orderservice.response.OrderResponse;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.utils.MappingConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MappingConstant.OrderMapping.BASE)
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping(MappingConstant.OrderMapping.HELLO)
    public String greet(){
        return "Hello from Order Service!!";
    }

    @GetMapping(MappingConstant.OrderMapping.CREATE)
    public OrderResponse placeOrder(@PathVariable("userId") Long userId){
        return orderService.createOrder(userId);
    }

}

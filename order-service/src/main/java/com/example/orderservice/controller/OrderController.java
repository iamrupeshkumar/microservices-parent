package com.example.orderservice.controller;

import com.example.orderservice.response.OrderResponse;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.utils.MappingConstant;
import com.example.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

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
    public ResponseEntity<ApiResponse<OrderResponse>> placeOrder(@PathVariable("userId") Long userId){
        OrderResponse orderResponse = orderService.createOrder(userId);
        ApiResponse<OrderResponse> apiResponse = ApiResponse.<OrderResponse>builder()
                .success(true)
                .message("Order placed successfully")
                .data(orderResponse)
                .error(null)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

}

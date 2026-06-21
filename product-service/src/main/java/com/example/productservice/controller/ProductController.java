package com.example.productservice.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.entity.Product;
import com.example.productservice.service.ProductService;
import com.example.productservice.utils.MappingConstant;
import com.example.response.ApiResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(MappingConstant.ProductMapping.BASE)
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;
	
    @GetMapping(MappingConstant.ProductMapping.HELLO)
    public String greet(){
        return "Hello from Product Service!!";
    }
    
    @PostMapping(MappingConstant.ProductMapping.CREATE)
    public ApiResponse<Product> placeOrder(@RequestBody Product product){
    	Product orderResponse = productService.createProduct(product);
        return ApiResponse.<Product>builder()
                .success(true)
                .message("Product created successfully")
                .data(orderResponse)
                .error(null)
                .timestamp(LocalDateTime.now())
                .build();
    }

    @GetMapping
    public ApiResponse<List<Product>> getAllOrders(){

        return ApiResponse.<List<Product>>builder()
                .success(true)
                .message("Products fetched successfully")
                .data(productService.getProducts())
                .error(null)
                .timestamp(LocalDateTime.now())
                .build();
    }

    @GetMapping(MappingConstant.ProductMapping.GET_BY_ID)
    public ApiResponse<Product> getOrderById(@PathVariable("id") Long id){
        return ApiResponse.<Product>builder()
                .success(true)
                .message("Product fetched successfully")
                .data(productService.getOrderById(id))
                .error(null)
                .timestamp(LocalDateTime.now())
                .build();
    }

}

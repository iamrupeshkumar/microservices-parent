package com.example.orderservice.client;

import com.example.dto.UserDto;
import com.example.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/api/v1/users/{id}")
    ApiResponse<UserDto> getUserById(@PathVariable("id") Long userId);
}

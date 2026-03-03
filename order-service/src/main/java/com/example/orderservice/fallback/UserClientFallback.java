package com.example.orderservice.fallback;

import com.example.dto.UserDto;
import com.example.orderservice.client.UserClient;
import com.example.response.ApiResponse;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {

    @Override
    public ApiResponse<UserDto> getUserById(Long userId) {
        return null;
    }
}

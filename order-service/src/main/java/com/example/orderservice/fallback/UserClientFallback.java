package com.example.orderservice.fallback;

import com.example.dto.UserDto;
import com.example.orderservice.client.UserClient;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {

    @Override
    public UserDto getUserById(Long userId) {
        return new UserDto(userId,"UNKNOWN","fallback@user-service.com");
    }
}

package com.example.userservice.controller;

import com.example.userservice.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/hello")
    public String greet(){
        return "Hello from User Service!!";
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable("userId") Long userId){
        return new UserDto(userId, "Rupesh", "rupesh@email.com");
    }

}

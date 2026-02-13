package com.example.userservice.controller;

import com.example.dto.UserDto;
import com.example.userservice.utils.MappingConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MappingConstant.UserMapping.BASE)
public class UserController {

    @GetMapping(MappingConstant.UserMapping.HELLO)
    public String greet(){
        return "Hello from User Service!!";
    }

    @GetMapping(MappingConstant.UserMapping.GET_BY_ID)
    public UserDto getUserById(@PathVariable("userId") Long userId){
        return new UserDto(userId, "Rupesh", "rupesh@email.com");
    }

}

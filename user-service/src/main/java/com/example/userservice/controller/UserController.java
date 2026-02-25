package com.example.userservice.controller;

import com.example.dto.UserDto;
import com.example.response.ApiResponse;
import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import com.example.userservice.utils.MappingConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(MappingConstant.UserMapping.BASE)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(MappingConstant.UserMapping.HELLO)
    public String greet(){
        return "Hello from User Service!!";
    }

    @PostMapping(MappingConstant.UserMapping.CREATE)
    public ApiResponse<User> create(@RequestBody User user){
        return ApiResponse.<User>builder()
                .success(true)
                .message("User created successfully")
                .data(userService.create(user))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @GetMapping(MappingConstant.UserMapping.GET_BY_ID)
    public ApiResponse<User> getUserById(@PathVariable("id") Long id){
        return ApiResponse.<User>builder()
                .success(true)
                .message("User fetched successfully")
                .data(userService.getById(id))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @GetMapping(MappingConstant.UserMapping.GET_ALL)
    public ApiResponse<List<User>> getAll(){
        return ApiResponse.<List<User>>builder()
                .success(true)
                .message("Users fetched successfully")
                .data(userService.getAll())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @PutMapping(MappingConstant.UserMapping.UPDATE)
    public ApiResponse<User> update(@PathVariable("id") Long id ,@RequestBody User user){
        return ApiResponse.<User>builder()
                .success(true)
                .message("User updated successfully")
                .data(userService.update(id, user))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @DeleteMapping(MappingConstant.UserMapping.DELETE)
    public ApiResponse<Void> delete(@PathVariable("id") Long id){
        userService.delete(id);
        return ApiResponse.<Void>builder()
                .success(true)
                .message("User deleted successfully")
                .timestamp(LocalDateTime.now())
                .build();
    }

}

package com.example.userservice.service;

import com.example.exception.ResourceNotFoundException;
import com.example.userservice.entity.User;
import com.example.userservice.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public User getById(Long id){
        return userRepository.findById(id)
                .orElseThrow(
                        () ->
                                new ResourceNotFoundException("user not found with id: "+id));
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User update(Long id, User updatedUser){
        User user = getById(id);
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}

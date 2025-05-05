package com.example.demo.controller;

import com.example.demo.dto.request.UserCreationRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    User createUser(@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    void deleteUserById(@PathVariable String id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    User updateUser(@PathVariable String id, @RequestBody UserCreationRequest request) {
        return userService.updateUser(id, request);
    }
}

package com.example.demo.controller;

import com.example.demo.dto.request.ApiResponse;
import com.example.demo.dto.request.UserCreationRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> response = new ApiResponse<>();
        User user = userService.createUser(request);
        response.setCode(200);
        response.setMessage("Success");
        response.setResult(user);
        return response;
    }

    @GetMapping
    ApiResponse<List<User>> getAllUsers() {
        ApiResponse<List<User>> response = new ApiResponse<>();
        response.setCode(200);
        response.setMessage("Success");
        response.setResult(userService.getAllUsers());
        response.setTotalRecords(
                userService.getAllUsers().size()
        );
        return response;
    }

    @GetMapping("/{id}")
    ApiResponse<UserResponse> getUserById(@PathVariable String id) {
        ApiResponse<UserResponse> response = new ApiResponse<>();
        response.setCode(200);
        response.setMessage("Success");
        response.setResult(userService.getUserById(id));
        response.setTotalRecords(
                userService.getUserById(id) != null ? 1 : 0
        );
        return response;
    }

    @DeleteMapping("/{id}")
    ApiResponse<Void> deleteUserById(@PathVariable String id) {
        ApiResponse<Void> response = new ApiResponse<>();
        userService.deleteUserById(id);
        response.setCode(200);
        response.setMessage("Success");
        return response;
    }

    @PutMapping("/{id}")
    ApiResponse<User> updateUser(@PathVariable String id, @RequestBody UserCreationRequest request) {
        ApiResponse<User> response = new ApiResponse<>();
        response.setCode(200);
        response.setMessage("Success");
        response.setResult(userService.updateUser(id, request));
        return response;
    }
}

package com.example.demo.service;

import com.example.demo.dto.request.UserCreationRequest;
import com.example.demo.entity.User;
import com.example.demo.exception.AppException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User createUser(UserCreationRequest request) {
        User user = new User();
        if(userRepository.existsByName(request.getName())) {
            throw new AppException(ErrorCode.USER_EXITED);
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXITED);
        }
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng với id: " + id));
    }
    public void deleteUserById(String id) {
         userRepository.deleteById(id);
    }
    public User updateUser(String id, UserCreationRequest request) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(request.getName());
            user.setPassword(request.getPassword());
            user.setEmail(request.getEmail());
            user.setDob(request.getDob());
            return userRepository.save(user);
        }
        return null;
    }
}

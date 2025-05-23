package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByName(String name);
    boolean existsByEmail(String email);
    Optional<User> findByName(String name);
}

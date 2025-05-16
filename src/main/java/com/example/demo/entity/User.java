package com.example.demo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor()
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Document
public class User {
    @Id
    String id;
    String name;
    String password;
    String email;
    LocalDate dob;
    String imageUrl;
    String phone;
    Set<String> roles;
}

package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor()
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String email;
    String phone;
    String name;
    String notes;
    String address;
    String userId;
}

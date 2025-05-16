package com.example.demo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor()
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Document
public class Contact {
    @Id
    String id;
    String email;
    String phone;
    String name;
    String notes;
    String address;
    String userId;
}

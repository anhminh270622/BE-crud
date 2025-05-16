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
public class Cart {
    @Id
    String id;
    String userId;
    String name;
    int price;
    String imageUrl;
    String size;
    String color;
    int quantity;
}

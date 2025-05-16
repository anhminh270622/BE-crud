package com.example.demo.entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    String id;
    String name;
    String description;
    String imageUrl;
    double price;
    String category;
    String brand;
    int salePrice;
    int quantity;
}

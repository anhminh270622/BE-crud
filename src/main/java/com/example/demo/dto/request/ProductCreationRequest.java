package com.example.demo.dto.request;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCreationRequest {
    String name;
    String description;
    double price;
    int quantity;
    String category;
    String imageUrl;
    String brand;
    int salsePrice;
}

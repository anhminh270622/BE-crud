package com.example.demo.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderCreationRequest {
    @Size(min = 2, max = 50, message = "USER_NOT_VALID")
    String name;
    String description;
    String imageUrl;
    double price;
    String category;
    String brand;
    int salePrice;
    int quantity;
}

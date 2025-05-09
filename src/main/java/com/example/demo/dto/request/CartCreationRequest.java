package com.example.demo.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartCreationRequest {
    String userId;
    String name;
    int price;
    String imageUrl;
    String size;
    String color;
    int quantity;
}

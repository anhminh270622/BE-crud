package com.example.demo.entity;

import com.example.demo.dto.request.ImageRequest;
import com.example.demo.dto.request.SizeRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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
    List<String> description;
    List<String> parameter;
    int price;
    int price_sale;
    String trademark;
    List<ImageRequest> images;
    String type;
    List<SizeRequest> sizes;
    int quantity;
}

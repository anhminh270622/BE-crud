package com.example.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCreationRequest {
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

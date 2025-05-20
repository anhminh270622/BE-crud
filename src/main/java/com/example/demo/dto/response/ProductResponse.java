package com.example.demo.dto.response;

import com.example.demo.dto.request.ImageRequest;
import com.example.demo.dto.request.SizeRequest;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {
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

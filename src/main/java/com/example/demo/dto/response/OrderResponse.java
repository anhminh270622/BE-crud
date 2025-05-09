package com.example.demo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponse {
    String userId;
    String productId;
    String productName;
    String nameOrder;
    String imageUrl;
    int statusId;
    String statusName;
    String address;
    String note;
    String phone;
    int totalPrice;
}

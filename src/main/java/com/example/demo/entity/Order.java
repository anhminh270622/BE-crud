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
public class Order {
    @Id
    String id;
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

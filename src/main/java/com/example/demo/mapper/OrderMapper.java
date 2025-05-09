package com.example.demo.mapper;

import com.example.demo.dto.request.OrderCreationRequest;
import com.example.demo.dto.response.OrderResponse;
import com.example.demo.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order toOrder(OrderCreationRequest orderCreationRequest);

    OrderResponse toOrderResponse(Order order);

    java.util.List<OrderResponse> toOrderResponseList(java.util.List<Order> orders);
}

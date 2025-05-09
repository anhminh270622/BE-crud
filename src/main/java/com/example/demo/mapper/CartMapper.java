package com.example.demo.mapper;

import com.example.demo.dto.request.CartCreationRequest;
import com.example.demo.dto.response.CartResponse;
import com.example.demo.entity.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    Cart toCart(CartCreationRequest cartCreationRequest);

    CartResponse toCartResponse(Cart cart);

    java.util.List<CartResponse> toCartResponseList(java.util.List<Cart> cart);
}

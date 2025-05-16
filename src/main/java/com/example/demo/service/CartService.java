package com.example.demo.service;

import com.example.demo.dto.request.CartCreationRequest;
import com.example.demo.dto.response.CartResponse;
import com.example.demo.entity.Cart;
import com.example.demo.mapper.CartMapper;
import com.example.demo.repository.CartRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PACKAGE, makeFinal = true)
@RequiredArgsConstructor
public class CartService {
    CartRepository cartRepository;
    CartMapper cartMapper;

    public CartResponse addToCart(CartCreationRequest request) {
        Cart cart = cartMapper.toCart(request);
        return cartMapper.toCartResponse(cartRepository.save(cart));
    }

    public void deleteCart(String id) {
        if (cartRepository.existsById(id)) {
            cartRepository.deleteById(id);
        } else {
            throw new RuntimeException("Không tìm thấy giỏ hàng với id: " + id);
        }
    }

    public CartResponse updateCart(String id, CartCreationRequest request) {
        if (cartRepository.existsById(id)) {
            Cart cart = cartMapper.toCart(request);
            cart.setId(id);
            return cartMapper.toCartResponse(cartRepository.save(cart));
        } else {
            throw new RuntimeException("Không tìm thấy giỏ hàng với id: " + id);
        }
    }

    public List<CartResponse> getAllCart() {
        return cartMapper.toCartResponseList(cartRepository.findAll());
    }
}

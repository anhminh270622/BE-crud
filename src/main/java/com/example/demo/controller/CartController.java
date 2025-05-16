package com.example.demo.controller;

import com.example.demo.dto.request.ApiResponse;
import com.example.demo.dto.request.CartCreationRequest;
import com.example.demo.dto.response.CartResponse;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping()
    ApiResponse<CartResponse> addToCart(@RequestBody CartCreationRequest request) {
        ApiResponse<CartResponse> response = new ApiResponse<>();
        CartResponse cart = cartService.addToCart(request);
        response.setCode(200);
        response.setMessage("Success");
        response.setResult(cart);
        return response;
    }

    @PutMapping()
    ApiResponse<CartResponse> updateCart(@PathVariable String id, @RequestBody CartCreationRequest request) {
        ApiResponse<CartResponse> response = new ApiResponse<>();
        CartResponse cart = cartService.updateCart(id, request);
        response.setCode(200);
        response.setMessage("Success");
        response.setResult(cart);
        return response;
    }

    @GetMapping()
    ApiResponse<List<CartResponse>> getAllCart() {
        ApiResponse<List<CartResponse>> response = new ApiResponse<>();
        response.setCode(200);
        response.setMessage("Success");
        response.setResult(cartService.getAllCart());
        response.setTotalRecords(
                cartService.getAllCart().size()
        );
        return response;
    }

    @DeleteMapping("/{id}")
    ApiResponse<Void> deleteFromCart(@PathVariable String id) {
        ApiResponse<Void> response = new ApiResponse<>();
        cartService.deleteCart(id);
        response.setCode(200);
        response.setMessage("Success");
        return response;
    }


}

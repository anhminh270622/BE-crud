package com.example.demo.controller;

import com.example.demo.dto.request.ApiResponse;
import com.example.demo.dto.request.OrderCreationRequest;
import com.example.demo.dto.response.OrderResponse;
import com.example.demo.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping()
    ApiResponse<OrderResponse> createOrder(@RequestBody @Valid OrderCreationRequest orderCreationRequest) {
        ApiResponse<OrderResponse> response = new ApiResponse<>();
        OrderResponse order = orderService.createOrder(orderCreationRequest);
        response.setCode(200);
        response.setMessage("Success");
        response.setResult(order);
        return response;
    }
    @GetMapping()
    ApiResponse<List<OrderResponse>> getAllOrders() {
        ApiResponse<List<OrderResponse>> response = new ApiResponse<>();
        response.setCode(200);
        response.setMessage("Success");
        response.setResult(orderService.getAllOrders());
        response.setTotalRecords(
                orderService.getAllOrders().size()
        );
        return response;
    }
    @GetMapping("/{id}")
    ApiResponse<OrderResponse> getOrderById(@PathVariable String id) {
        ApiResponse<OrderResponse> response = new ApiResponse<>();
        response.setCode(200);
        response.setMessage("Success");
        response.setResult(orderService.getOrderById(id));
        response.setTotalRecords(
                orderService.getOrderById(id) != null ? 1 : 0
        );
        return response;
    }
    @DeleteMapping("/{id}")
    ApiResponse<Void> deleteOrderById(@PathVariable String id) {
        ApiResponse<Void> response = new ApiResponse<>();
        orderService.deleteOrderById(id);
        response.setCode(200);
        response.setMessage("Success");
        return response;
    }
    @PutMapping("/{id}")
    ApiResponse<OrderResponse> updateOrder(@PathVariable String id, @RequestBody @Valid OrderCreationRequest orderCreationRequest) {
        ApiResponse<OrderResponse> response = new ApiResponse<>();
        OrderResponse order = orderService.updateOrder(id, orderCreationRequest);
        response.setCode(200);
        response.setMessage("Success");
        response.setResult(order);
        return response;
    }
}

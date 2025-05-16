package com.example.demo.service;

import com.example.demo.dto.request.OrderCreationRequest;
import com.example.demo.dto.response.OrderResponse;
import com.example.demo.entity.Order;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class OrderService {
    OrderRepository orderRepository;
    OrderMapper orderMapper;

    public OrderResponse createOrder(OrderCreationRequest orderResponse) {
        Order order = orderMapper.toOrder(orderResponse);
        return orderMapper.toOrderResponse(orderRepository.save(order));
    }
    public OrderResponse getOrderById(String id) {
        return orderMapper.toOrderResponse(orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy đơn hàng với id: " + id)));
    }
    public void deleteOrderById(String id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
        } else {
            throw new RuntimeException("Không tìm thấy đơn hàng với id: " + id);
        }
    }
    public OrderResponse updateOrder(String id, OrderCreationRequest orderResponse) {
        if (orderRepository.existsById(id)) {
            Order order = orderMapper.toOrder(orderResponse);
            order.setId(id);
            return orderMapper.toOrderResponse(orderRepository.save(order));
        } else {
            throw new RuntimeException("Không tìm thấy đơn hàng với id: " + id);
        }
    }
    public List<OrderResponse> getAllOrders() {
        return orderMapper.toOrderResponseList(orderRepository.findAll());
    }
}

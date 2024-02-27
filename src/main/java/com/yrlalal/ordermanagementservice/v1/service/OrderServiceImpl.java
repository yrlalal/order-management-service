package com.yrlalal.ordermanagementservice.v1.service;

import com.yrlalal.ordermanagementservice.exception.OrderNotFoundException;
import com.yrlalal.ordermanagementservice.v1.model.Order;
import com.yrlalal.ordermanagementservice.v1.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Override
    public Order getOrder(Integer orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order with id " + orderId + " is not found"));
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
//        return orderRepository.save(order);
        return null;
    }

    @Override
    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
    }
}

package com.yrlalal.ordermanagementservice.impl.v1.service;

import com.yrlalal.ordermanagementservice.api.v1.model.OrderStatus;
import com.yrlalal.ordermanagementservice.impl.exception.OrderNotFoundException;
import com.yrlalal.ordermanagementservice.impl.v1.repository.OrderRepository;
import com.yrlalal.ordermanagementservice.api.v1.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Override
    public Order getOrder(String orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order with id " + orderId + " is not found"));
    }

    @Override
    public Order createOrder(Order order) {
        initializeOrder(order);
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(String orderId, Order order) {
        order.setOrderId(orderId);
        Order dbOrder = getOrder(order.getOrderId());
        order.setOrderItems(dbOrder.getOrderItems());
        order.setCreated(dbOrder.getCreated());
        order.setOrderStatus(dbOrder.getOrderStatus());
        order.setOrderItems(dbOrder.getOrderItems());
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(String orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public Order updateOrderStatus(String orderId, OrderStatus orderStatus) {
        Order order = getOrder(orderId);
        order.setOrderStatus(orderStatus);

        // TODO: Add logic to validate order status flow

        return orderRepository.save(order);
    }

    private static void initializeOrder(Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        order.setOrderItems(null);
        order.setCreated(ZonedDateTime.now());
        order.setOrderStatus(OrderStatus.NEW);
    }
}

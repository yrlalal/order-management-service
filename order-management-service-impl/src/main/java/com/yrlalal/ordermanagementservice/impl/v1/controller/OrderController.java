package com.yrlalal.ordermanagementservice.impl.v1.controller;

import com.yrlalal.ordermanagementservice.api.v1.api.OrderApi;
import com.yrlalal.ordermanagementservice.api.v1.model.Order;
import com.yrlalal.ordermanagementservice.api.v1.model.OrderStatus;
import com.yrlalal.ordermanagementservice.impl.v1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderApi {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @Override
    public Order getOrder(String orderId) {
        return orderService.getOrder(orderId);
    }

    @Override
    public Order createOrder(Order order) {
        return orderService.createOrder(order);
    }

    @Override
    public Order updateOrder(String orderId, Order order) {
        return orderService.updateOrder(orderId, order);
    }

    @Override
    public void deleteOrder(String orderId) {
        orderService.deleteOrder(orderId);
    }

    @Override
    public Order updateOrderStatus(String orderId, OrderStatus orderStatus) {
        return orderService.updateOrderStatus(orderId, orderStatus);
    }
}

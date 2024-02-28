package com.yrlalal.ordermanagementservice.v1.service;

import com.yrlalal.ordermanagementservice.v1.entity.Order;
import com.yrlalal.ordermanagementservice.v1.entity.OrderStatus;

public interface OrderService {
    Order getOrder(String orderId);
    Order createOrder(Order order);

    Order updateOrder(String orderId, Order order);

    void deleteOrder(String orderId);

    Order updateOrderStatus(String orderId, OrderStatus orderStatus);
}

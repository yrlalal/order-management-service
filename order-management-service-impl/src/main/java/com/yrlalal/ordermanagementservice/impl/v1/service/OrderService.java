package com.yrlalal.ordermanagementservice.impl.v1.service;

import com.yrlalal.ordermanagementservice.api.v1.model.Order;
import com.yrlalal.ordermanagementservice.api.v1.model.OrderStatus;

public interface OrderService {
    Order getOrder(String orderId);
    Order createOrder(Order order);

    Order updateOrder(String orderId, Order order);

    void deleteOrder(String orderId);

    Order updateOrderStatus(String orderId, OrderStatus orderStatus);
}

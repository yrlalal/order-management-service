package com.yrlalal.ordermanagementservice.v1.service;

import com.yrlalal.ordermanagementservice.v1.model.Order;
import com.yrlalal.ordermanagementservice.v1.model.OrderStatus;

public interface OrderService {
    Order getOrder(Integer orderId);
    Order createOrder(Order order);

    Order updateOrder(Integer orderId, Order order);

    void deleteOrder(Integer orderId);

    Order updateOrderStatus(Integer orderId, OrderStatus orderStatus);
}

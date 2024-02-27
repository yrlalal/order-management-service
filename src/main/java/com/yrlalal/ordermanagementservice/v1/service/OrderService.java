package com.yrlalal.ordermanagementservice.v1.service;

import com.yrlalal.ordermanagementservice.v1.model.Order;

public interface OrderService {
    Order getOrder(Integer orderId);
    Order createOrder(Order order);

    Order updateOrder(Order order);

    void deleteOrder(Integer orderId);
}

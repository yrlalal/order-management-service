package com.yrlalal.ordermanagementservice.v1.service;

import com.yrlalal.ordermanagementservice.exception.BadRequestException;
import com.yrlalal.ordermanagementservice.exception.OrderNotFoundException;
import com.yrlalal.ordermanagementservice.v1.model.Order;
import com.yrlalal.ordermanagementservice.v1.model.OrderStatus;
import com.yrlalal.ordermanagementservice.v1.repository.OrderRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

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
        validateOrder(order);
        initializeOrder(order);
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Integer orderId, Order order) {
        validateOrder(order);
        order.setOrderId(orderId);
        Order dbOrder = getOrder(order.getOrderId());
        order.setOrderItems(dbOrder.getOrderItems());
        order.setCreated(dbOrder.getCreated());
        order.setOrderStatus(dbOrder.getOrderStatus());
        order.setOrderItems(dbOrder.getOrderItems());
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public Order updateOrderStatus(Integer orderId, OrderStatus orderStatus) {
        Order order = getOrder(orderId);
        order.setOrderStatus(orderStatus);

        // TODO: Add logic to validate order status flow

        return orderRepository.save(order);
    }

    private void validateOrder(Order order) {
        if (order == null) {
            throw new BadRequestException("order data in request body is required.");
        }

        if (Strings.isBlank(order.getCustomerId())) {
            throw new BadRequestException("customerId field is required.");
        }
    }

    private static void initializeOrder(Order order) {
        order.setOrderId(null);
        order.setOrderItems(null);
        order.setCreated(Calendar.getInstance().getTime());
        order.setOrderStatus(OrderStatus.NEW);
    }
}

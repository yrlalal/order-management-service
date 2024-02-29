package com.yrlalal.ordermanagementservice.v1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yrlalal.ordermanagementservice.exception.OrderNotFoundException;
import com.yrlalal.ordermanagementservice.v1.entity.Order;
import com.yrlalal.ordermanagementservice.v1.entity.OrderStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@SpringBootTest
public class OrderControllerTest {
    @Autowired
    private OrderController orderController;
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Test
    public void createOrderSuccessTest() throws IOException {
        Order order = createOrder();
        Assertions.assertTrue(StringUtils.hasText(order.getOrderId()));
        Assertions.assertEquals(OrderStatus.NEW, order.getOrderStatus());
        Assertions.assertTrue(CollectionUtils.isEmpty(order.getOrderItems()));
    }

    @Test
    public void getOrderSuccessTest() throws IOException {
        Order order = createOrder();
        Assertions.assertDoesNotThrow(() -> orderController.getOrder(order.getOrderId()));
    }

    @Test()
    public void getOrderNotFoundTest() {
        Assertions.assertThrows(OrderNotFoundException.class,
                () -> orderController.getOrder(UUID.randomUUID().toString()));
    }

    @Test
    public void updateOrderTest() throws IOException {
        Order order = createOrder();
        String newCustomerId = UUID.randomUUID().toString();
        order.setCustomerId(newCustomerId);
        Order updatedOrder = orderController.updateOrder(order.getOrderId(), order);
        Assertions.assertEquals(newCustomerId, updatedOrder.getCustomerId());
    }

    @Test
    public void deleteOrderTest() throws IOException {
        Order order = createOrder();
        orderController.deleteOrder(order.getOrderId());
        Assertions.assertThrows(OrderNotFoundException.class, () -> orderController.getOrder(order.getOrderId()));
    }

    private Order createOrder() throws IOException {
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("testjson/create_order.json")) {
            Order order = objectMapper.readValue(inputStream, Order.class);
            return orderController.createOrder(order);
        }
    }
}

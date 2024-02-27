package com.yrlalal.ordermanagementservice.v1.controller;

import com.yrlalal.ordermanagementservice.v1.model.Order;
import com.yrlalal.ordermanagementservice.v1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("{orderId}")
    public Order getOrder(@PathVariable("orderId") Integer orderId) {
        return orderService.getOrder(orderId);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @DeleteMapping("{orderId}")
    public void deleteOrder(@PathVariable("orderId") Integer orderId) {
        orderService.deleteOrder(orderId);
    }
}

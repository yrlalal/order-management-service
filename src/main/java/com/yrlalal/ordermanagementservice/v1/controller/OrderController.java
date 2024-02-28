package com.yrlalal.ordermanagementservice.v1.controller;

import com.yrlalal.ordermanagementservice.v1.entity.Order;
import com.yrlalal.ordermanagementservice.v1.entity.OrderStatus;
import com.yrlalal.ordermanagementservice.v1.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/orders")
@Validated
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("{orderId}")
    public Order getOrder(@PathVariable("orderId") String orderId) {
        return orderService.getOrder(orderId);
    }

    @PostMapping
    public Order createOrder(@Valid @RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PutMapping("{orderId}")
    public Order updateOrder(@PathVariable("orderId") String orderId, @RequestBody Order order) {
        return orderService.updateOrder(orderId, order);
    }

    @DeleteMapping("{orderId}")
    public void deleteOrder(@PathVariable("orderId") String orderId) {
        orderService.deleteOrder(orderId);
    }

    @PostMapping("{orderId}/status/{orderStatus}")
    public Order updateOrderStatus(@PathVariable("orderId") String orderId,
                                   @PathVariable("orderStatus") OrderStatus orderStatus) {
        return orderService.updateOrderStatus(orderId, orderStatus);
    }
}

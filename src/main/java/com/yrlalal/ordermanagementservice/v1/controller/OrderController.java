package com.yrlalal.ordermanagementservice.v1.controller;

import com.yrlalal.ordermanagementservice.v1.entity.Order;
import com.yrlalal.ordermanagementservice.v1.entity.OrderStatus;
import com.yrlalal.ordermanagementservice.v1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable("orderId") String orderId) {
        return ResponseEntity.ok(orderService.getOrder(orderId));
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @PutMapping("{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable("orderId") String orderId, @RequestBody Order order) {
        return ResponseEntity.ok(orderService.updateOrder(orderId, order));
    }

    @DeleteMapping("{orderId}")
    public void deleteOrder(@PathVariable("orderId") String orderId) {
        orderService.deleteOrder(orderId);
    }

    @PostMapping("{orderId}/status/{orderStatus}")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable("orderId") String orderId,
                                   @PathVariable("orderStatus") OrderStatus orderStatus) {
        return ResponseEntity.ok(orderService.updateOrderStatus(orderId, orderStatus));
    }
}

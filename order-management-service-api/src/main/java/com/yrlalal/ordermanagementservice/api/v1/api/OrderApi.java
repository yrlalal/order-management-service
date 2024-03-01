package com.yrlalal.ordermanagementservice.api.v1.api;

import com.yrlalal.ordermanagementservice.api.v1.model.Order;
import com.yrlalal.ordermanagementservice.api.v1.model.OrderStatus;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/api/v1/orders")
@Validated
public interface OrderApi {
    @GetMapping("{orderId}")
    Order getOrder(@PathVariable("orderId") String orderId);

    @PostMapping
    Order createOrder(@Valid @RequestBody Order order);

    @PutMapping("{orderId}")
    Order updateOrder(@PathVariable("orderId") String orderId, @RequestBody Order order);

    @DeleteMapping("{orderId}")
    void deleteOrder(@PathVariable("orderId") String orderId);

    @PostMapping("{orderId}/status/{orderStatus}")
    Order updateOrderStatus(@PathVariable("orderId") String orderId,
                            @PathVariable("orderStatus") OrderStatus orderStatus);
}

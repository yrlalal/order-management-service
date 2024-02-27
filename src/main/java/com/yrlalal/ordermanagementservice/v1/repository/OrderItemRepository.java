package com.yrlalal.ordermanagementservice.v1.repository;

import com.yrlalal.ordermanagementservice.v1.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}

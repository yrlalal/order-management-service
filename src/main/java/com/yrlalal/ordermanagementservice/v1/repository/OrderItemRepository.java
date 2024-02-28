package com.yrlalal.ordermanagementservice.v1.repository;

import com.yrlalal.ordermanagementservice.v1.entity.OrderItem;
import com.yrlalal.ordermanagementservice.v1.entity.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}

package com.yrlalal.ordermanagementservice.impl.v1.repository;

import com.yrlalal.ordermanagementservice.api.v1.model.OrderItem;
import com.yrlalal.ordermanagementservice.api.v1.model.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}

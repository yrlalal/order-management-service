package com.yrlalal.ordermanagementservice.impl.v1.repository;

import com.yrlalal.ordermanagementservice.api.v1.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}

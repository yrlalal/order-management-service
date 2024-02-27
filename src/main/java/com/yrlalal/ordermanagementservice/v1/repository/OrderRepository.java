package com.yrlalal.ordermanagementservice.v1.repository;

import com.yrlalal.ordermanagementservice.v1.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}

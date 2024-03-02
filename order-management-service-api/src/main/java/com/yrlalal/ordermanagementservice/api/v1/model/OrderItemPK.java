package com.yrlalal.ordermanagementservice.api.v1.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

public class OrderItemPK implements Serializable {
    private Integer orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}

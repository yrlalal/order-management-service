package com.yrlalal.ordermanagementservice.v1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@IdClass(OrderItemPK.class)
@Table(name = "order_item")
public class OrderItem {
    @Id
    @Column(name = "order_item_id")
    private Integer orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @Id
    @JsonIgnore
    private Order order;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "price")
    private Double price;

    @Column(name = "order_item_status")
    private OrderItemStatus orderItemStatus;

    @Column(name = "created")
    private Date created;

    @Column(name = "quantity")
    private Integer quantity;
}

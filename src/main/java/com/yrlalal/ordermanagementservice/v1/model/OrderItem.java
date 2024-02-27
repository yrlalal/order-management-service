package com.yrlalal.ordermanagementservice.v1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "orderItem")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderItemId")
    private Integer orderItemId;

//    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @Column(name = "productId")
    private String productId;

    @Column(name = "price")
    private Double price;

    @Column(name = "orderItemStatus")
    private OrderItemStatus orderItemStatus;

    @Column(name = "created")
    private Date created;

    @Column(name = "quantity")
    private Integer quantity;
}

package com.yrlalal.ordermanagementservice.v1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "dborder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Integer orderId;

    @Column(name = "customerId")
    private String customerId;

    @Column(name = "created")
    private Date created;

    @Column(name = "orderStatus")
    private OrderStatus orderStatus;

//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
}

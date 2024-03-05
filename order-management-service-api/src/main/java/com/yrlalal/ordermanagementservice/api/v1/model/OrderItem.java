package com.yrlalal.ordermanagementservice.api.v1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

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
    private BigDecimal price;

    @Column(name = "order_item_status")
    private OrderItemStatus orderItemStatus;

    @Column(name = "created")
    @Schema(description = "Represents order item creation time. It follows ISO-8601 format of yyyy-mm-ddT hh:mm:ss+|– hh:mm", example = "2024-03-04T14:09:50.2371549-08:00")
    private ZonedDateTime created;

    @Column(name = "quantity")
    private Integer quantity;
}

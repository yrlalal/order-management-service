package com.yrlalal.ordermanagementservice.api.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "db_order")
public class Order {
    @Id
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "customer_id")
    @NotBlank(message = "customerId is required")
    private String customerId;

    @Column(name = "created")
    @Schema(description = "Represents order creation time. It follows ISO-8601 format of yyyy-mm-ddT hh:mm:ss+|– hh:mm", example = "2024-03-04T14:09:50.2371549-08:00")
    private ZonedDateTime created;

    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
}

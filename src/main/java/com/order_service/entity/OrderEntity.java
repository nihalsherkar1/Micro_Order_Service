package com.order_service.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orderEntity")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "product_id")
    private  Long productId;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "order_date")
    private Instant orderDate;

    @Column(name = "status")
    private String orderStatus;

    @Column(name = "total_amount")
    private Long amount;
}

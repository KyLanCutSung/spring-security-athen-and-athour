package com.example.test.modules.orders.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name="orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ORDER_SEQ")
    @SequenceGenerator(name = "orders", sequenceName = "ORDER_SEQ", allocationSize = 1)
    @Column(name = "ORDER_ID")
    private Long orderId;
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "SHIPPING_ADDRESS")
    private String shippingAddress;
    @Column(name = "PRODUCT_ID")
    private Long productId;
    @Column(name = "RECEIVED_DAY")
    private Instant receivedDay;
}

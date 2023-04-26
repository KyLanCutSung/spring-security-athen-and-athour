package com.example.test.models.orders.dtos;

import lombok.Data;

import java.time.Instant;

@Data
public class OrdersBillDetail {
    private String name;
    private String productName;
    private String shippingAddress;
    private Long productPrice;
    private Instant receivedDay;
}

package com.example.test.models.orders.dtos;

import lombok.Data;

import javax.persistence.Column;
import java.time.Instant;

@Data
public class OrdersDto {
    private Long userId;
    private Long productId;
    private String shippingAddress;
}

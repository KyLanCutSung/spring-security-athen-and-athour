package com.example.test.modules.orders.dtos;

import lombok.Data;

@Data
public class OrdersDto {
    private Long userId;
    private Long productId;
    private String shippingAddress;
}

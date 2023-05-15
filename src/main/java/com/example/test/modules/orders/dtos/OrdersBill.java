package com.example.test.modules.orders.dtos;

import lombok.Data;

@Data
public class OrdersBill {
    private String name;
    private String productName;
    private Long quantity;
    private Long totalPrice;
}

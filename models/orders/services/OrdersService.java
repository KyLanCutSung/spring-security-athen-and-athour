package com.example.test.models.orders.services;

import com.example.test.models.orders.dtos.OrdersBill;
import com.example.test.models.orders.dtos.OrdersBillDetail;
import com.example.test.models.orders.dtos.OrdersDto;

import java.util.List;

public interface OrdersService {
    OrdersBillDetail getBill(OrdersDto ordersDto);
    List<OrdersBillDetail> billDetails(Long userId);
    List<OrdersBill> totalBill();
}

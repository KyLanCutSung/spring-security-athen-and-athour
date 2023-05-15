package com.example.test.modules.orders.services;

import com.example.test.modules.orders.dtos.OrdersBill;
import com.example.test.modules.orders.dtos.OrdersBillDetail;
import com.example.test.modules.orders.dtos.OrdersDto;

import java.util.List;

public interface OrdersService {
    OrdersBillDetail getBill(OrdersDto ordersDto);
    List<OrdersBillDetail> billDetails(Long userId);
    List<OrdersBill> totalBill();
}

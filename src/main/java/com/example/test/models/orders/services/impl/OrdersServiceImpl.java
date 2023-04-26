package com.example.test.models.orders.services.impl;

import com.example.test.dtos.UserDto;
import com.example.test.models.orders.dtos.OrdersBill;
import com.example.test.models.orders.dtos.OrdersBillDetail;
import com.example.test.models.orders.dtos.OrdersDto;
import com.example.test.models.orders.entities.OrdersEntity;
//import com.example.test.models.orders.repo.OrdersBillRepository;
import com.example.test.models.orders.repo.OrdersBillRepository;
import com.example.test.models.orders.repo.OrdersRepository;
import com.example.test.models.orders.services.OrdersService;
import com.example.test.models.products.dtos.ProductDto;
import com.example.test.models.products.services.ProductService;
import com.example.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrdersBillRepository ordersBillRepository;
    @Override
    public OrdersBillDetail getBill(OrdersDto ordersDto){
        UserDto userDto = userService.findByUserId(ordersDto.getUserId());
        ProductDto productDto = productService.findByProductId(ordersDto.getProductId());
            OrdersEntity ordersEntity = new OrdersEntity();
            ordersEntity.setProductId(productDto.getProductId());
            ordersEntity.setUserId(userDto.getUserId());
            ordersEntity.setShippingAddress(ordersDto.getShippingAddress());
            ordersEntity.setReceivedDay(Instant.now().plus(Period.ofDays(5)).truncatedTo(ChronoUnit.DAYS));
            ordersRepository.save(ordersEntity);
        OrdersBillDetail ordersBillDetail = new OrdersBillDetail();
            ordersBillDetail.setProductName(productDto.getProductName());
            ordersBillDetail.setName(userDto.getName());
            ordersBillDetail.setProductPrice(productDto.getProductPrice());
            ordersBillDetail.setShippingAddress(ordersDto.getShippingAddress());
            ordersBillDetail.setReceivedDay(Instant.now().plus(Period.ofDays(5)).truncatedTo(ChronoUnit.DAYS));
        return ordersBillDetail;
    }
    public List<OrdersBillDetail> billDetails(Long userId){
        List<OrdersBillDetail> ordersBillDetails = ordersBillRepository.billDetails(userId);
        return ordersBillDetails;
    }
    public List<OrdersBill> totalBill(){
        List<OrdersBill> ordersBills = ordersBillRepository.totalBill();
        return ordersBills;
    }
}

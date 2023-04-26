package com.example.test.controllers;

import com.example.test.models.orders.dtos.OrdersBill;
import com.example.test.models.orders.dtos.OrdersBillDetail;
import com.example.test.models.orders.dtos.OrdersDto;
import com.example.test.models.orders.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @PostMapping("/bill")
    public ResponseEntity<OrdersBillDetail> getBill(@RequestBody OrdersDto ordersDto){
        OrdersBillDetail ordersBillDetail = ordersService.getBill(ordersDto);
        return new ResponseEntity<OrdersBillDetail>(ordersBillDetail, HttpStatus.OK);
    }
    @GetMapping("/bill_detail")
    public ResponseEntity<List<OrdersBillDetail>> billDetails(@RequestParam(required = false) Long userId){
        List<OrdersBillDetail> ordersBillDetails = ordersService.billDetails(userId);
        return new ResponseEntity<>(ordersBillDetails, HttpStatus.OK);
    }
    @GetMapping("/total_bill")
    public ResponseEntity<List<OrdersBill>> totalBill(){
        List<OrdersBill> ordersBills = ordersService.totalBill();
        return new ResponseEntity<>(ordersBills, HttpStatus.OK);
    }
}

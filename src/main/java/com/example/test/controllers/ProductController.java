package com.example.test.controllers;

import com.example.test.models.products.dtos.ProductDto;
import com.example.test.models.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/product")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/get_all")
    public ResponseEntity<?> getAllProduct(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "3") Integer pageSize
    ){
        List<ProductDto> productDtoList = productService.getAllProducts(pageNo, pageSize);
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }
}

package com.example.test.controllers;

import com.example.test.models.products.dtos.ProductDto;
import com.example.test.models.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/product")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/get_all")
    public ResponseEntity<?> getAllProduct(){
        List<ProductDto> productDtoList = productService.getAllProducts();
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }
}

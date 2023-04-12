package com.example.test.models.products.services;

import com.example.test.models.products.dtos.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto findByProductId(Long productId);
}

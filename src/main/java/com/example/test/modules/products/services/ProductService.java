package com.example.test.modules.products.services;

import com.example.test.modules.products.dtos.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts(Integer pageNo, Integer pageSize);
    ProductDto findByProductId(Long productId);
}

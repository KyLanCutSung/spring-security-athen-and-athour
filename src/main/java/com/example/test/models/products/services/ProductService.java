package com.example.test.models.products.services;

import com.example.test.models.products.dtos.ProductDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts(Integer pageNo, Integer pageSize);
    ProductDto findByProductId(Long productId);
}

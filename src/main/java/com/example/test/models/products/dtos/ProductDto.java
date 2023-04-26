package com.example.test.models.products.dtos;

import com.example.test.models.brands.dtos.BrandDto;
import com.example.test.models.product_categories.dtos.ProductCategoryDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ProductDto {
    private Long productId;
    private String productName;
    private Long productPrice;
    private String status;
    private ProductCategoryDto productCategoryDto;
    private BrandDto brandDto;
}

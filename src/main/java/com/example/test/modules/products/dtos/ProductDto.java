package com.example.test.modules.products.dtos;

import com.example.test.modules.brands.dtos.BrandDto;
import com.example.test.modules.product_categories.dtos.ProductCategoryDto;
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

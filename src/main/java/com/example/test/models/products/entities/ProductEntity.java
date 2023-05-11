package com.example.test.models.products.entities;

import com.example.test.models.brands.entities.BrandEntity;
import com.example.test.models.product_categories.entities.ProductCategoryEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "PRODUCT_SEQ")
    @SequenceGenerator(name = "product", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
    @Column(name = "PRODUCT_ID")
    private Long productId;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "PRODUCT_CATEGORY_ID")
    private Long productCategoryId;
    @Column(name = "PRODUCT_PRICE")
    private Long productPrice;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "BRAND_ID")
    private Long brandId;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("PRODUCT_CATEGORY_ID")
    @JoinColumn(name = "PRODUCT_CATEGORY_ID")
    private ProductCategoryEntity productCategoryEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("BRAND_ID")
    @JoinColumn(name = "BRAND_ID")
    private BrandEntity brandEntity;
}

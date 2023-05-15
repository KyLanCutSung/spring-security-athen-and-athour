package com.example.test.modules.product_categories.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_category")
public class ProductCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "PRODUCT_CATEGORY_SEQ")
    @SequenceGenerator(name = "product", sequenceName = "PRODUCT_CATEGORY_SEQ", allocationSize = 1)
    @Column(name = "PRODUCT_CATEGORY_ID")
    private Long productCategoryId;
    @Column(name = "PRODUCT_CATEGORY_NAME")
    private String productCategoryName;
}

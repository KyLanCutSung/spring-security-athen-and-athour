package com.example.test.modules.brands.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "brand")
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "BRAND_SEQ")
    @SequenceGenerator(name = "brand", sequenceName = "BRAND_SEQ", allocationSize = 1)
    @Column(name = "brand_id")
    private Long brandId;
    @Column(name = "brand_name")
    private String brandName;
}

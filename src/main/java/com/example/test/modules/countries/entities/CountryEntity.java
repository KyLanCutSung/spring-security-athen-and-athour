package com.example.test.modules.countries.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "COUNTRY_SEQ")
    @SequenceGenerator(name = "country", sequenceName = "COUNTRY_SEQ", allocationSize = 1)
    @Column(name = "country_id")
    private Long countryId;
    @Column(name = "country_name")
    private String countryName;
}

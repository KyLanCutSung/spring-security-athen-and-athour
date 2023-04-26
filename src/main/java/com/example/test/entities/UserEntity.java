package com.example.test.entities;

import com.example.test.models.countries.entities.CountryEntity;
import com.example.test.models.products.entities.ProductEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @SequenceGenerator(name = "users", sequenceName = "USER_TOKEN_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users")
    private Long userId;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "COUNTRY_ID")
    private Long countryId;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    Set<RoleEntity> roleEntities = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "orders",
    joinColumns = @JoinColumn(name = "USER_ID"),
    inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    Set<ProductEntity> productEntities = new HashSet<>();
    @ManyToOne
    @MapsId("COUNTRY_ID")
    @JoinColumn(name = "COUNTRY_ID")
    private CountryEntity countryEntity;
    public UserEntity(String email,
                      String name,
                      String username,
                      String phone,
                      Long countryId,
                      String encode) {
        this.email = email;
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.countryId = countryId;
        this.password = encode;

    }

    public UserEntity() {

    }
}

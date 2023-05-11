package com.example.test.entities;

import com.example.test.models.countries.entities.CountryEntity;
import com.example.test.models.products.entities.ProductEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @SequenceGenerator(name = "users", sequenceName = "USER_TOKEN_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users")
    @NotNull
    private Long userId;
    @Column(name = "USERNAME")
    @NotNull
    private String username;
    @Column(name = "NAME")
    @NotNull
    private String name;
    @Column(name = "PASSWORD")
    @NotNull
    private String password;
    @Column(name = "EMAIL")
    @NotNull
    private String email;
    @Column(name = "PHONE")
    @NotNull
    private String phone;
    @Column(name = "COUNTRY_ID")
    @NotNull
    private Long countryId;
    @ManyToMany()
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    Set<RoleEntity> roleEntities = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "orders",
    joinColumns = @JoinColumn(name = "USER_ID"),
    inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    Set<ProductEntity> productEntities = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
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

}

package com.example.test.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "refreshtoken")
public class RefreshToken {
    @Id
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "token", nullable = false, unique = true)
    private String token;
    @Column(name = "expirydate",nullable = false)
    private Instant expiryDate;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity userEntity;
}

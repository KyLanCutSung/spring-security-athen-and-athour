package com.example.test.entities;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class RoleEntity {
    @Id
    @SequenceGenerator(name = "roles", sequenceName = "ROLE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles")
    private Long roleId;
    @Column(name = "role_name")
    private String roleName;
}

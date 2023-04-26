package com.example.test.models.admin_groups_role.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ADMIN_GROUPS_ROLE")
public class AdminGroupsRoleEntity {
    @Id
    @SequenceGenerator(name = "ADMIN_GROUPS_ROLE", sequenceName = "ADMIN_GROUPS_ROLE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADMIN_GROUPS")
    @Column(name = "ROLE_ID")
    private Long roleId;
    @Column(name = "ROLE_NAME")
    private String roleName;
}

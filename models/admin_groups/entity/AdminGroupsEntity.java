package com.example.test.models.admin_groups.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ADMIN_GROUPS")
public class AdminGroupsEntity {
    @Id
    @SequenceGenerator(name = "ADMIN_GROUPS", sequenceName = "ADMIN_GROUPS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADMIN_GROUPS")
    @Column(name = "ADMIN_GROUPS_ID")
    private Long adminGroupsId;
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "GROUP_ID")
    private Long groupId;
    @Column(name = "ROLE_ID")
    private Long roleId;
}

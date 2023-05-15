package com.example.test.modules.group_user.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "GROUP_USER")
public class GroupUserEntity {
    @EmbeddedId
    private GroupUserId groupUserId;
    @Column(name = "APPROVAL")
    private Long approval;
}

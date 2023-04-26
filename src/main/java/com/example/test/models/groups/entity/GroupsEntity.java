package com.example.test.models.groups.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "GROUPS")
public class GroupsEntity {
    @Id
    @SequenceGenerator(name = "GROUPS", sequenceName = "GROUP_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GROUPS")
    @Column(name = "GROUP_ID")
    private Long groupId;
    @Column(name = "GROUP_NAME")
    private String groupName;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "MAIN_IMG")
    private String mainImg;
}

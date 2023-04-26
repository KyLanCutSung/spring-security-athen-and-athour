package com.example.test.models.relation.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "relation")
public class RelationEntity {
    @EmbeddedId
    private RelationId relationId;
    @Column(name = "RELATION")
    private Long relation;
    @Column(name = "NOTIFICATION_USER")
    private String notificationUser;
    @Column(name = "NOTIFICATION_FRIEND")
    private String notificationFriend;
//    @ManyToOne
//    @MapsId("USER_ID")
//    @JoinColumn(name = "USER_ID")
//    private UserEntity userEntity;
//    @ManyToOne
//    @MapsId("FRIEND_ID")
//    @JoinColumn(name = "FRIEND_ID")
//    private UserEntity userEntity1;
}

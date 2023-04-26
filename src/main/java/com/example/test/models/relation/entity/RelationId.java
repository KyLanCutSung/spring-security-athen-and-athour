package com.example.test.models.relation.entity;

import com.example.test.entities.UserEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Embeddable
public class RelationId implements Serializable {
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "FRIEND_ID")
    private Long friendId;
}

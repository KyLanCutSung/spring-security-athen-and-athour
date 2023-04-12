package com.example.test.models.group_user.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class GroupUserId implements Serializable {
    public Long groupId;
    public Long userId;
}

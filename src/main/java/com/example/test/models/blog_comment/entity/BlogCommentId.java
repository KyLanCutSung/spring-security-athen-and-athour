package com.example.test.models.blog_comment.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class BlogCommentId implements Serializable {
    private Long blogId;
    private Long userId;
}

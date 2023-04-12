package com.example.test.models.blog_comment.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "BLOG_COMMENT")
public class BlogCommentEntity {
    @EmbeddedId
    private BlogCommentId blogCommentId;
    @Column(name = "COMMENT_STATUS")
    private String commentStatus;
}

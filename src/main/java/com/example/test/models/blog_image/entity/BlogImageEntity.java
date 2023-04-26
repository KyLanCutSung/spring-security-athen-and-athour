package com.example.test.models.blog_image.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "BLOG_IMAGE")
public class BlogImageEntity {
    @Id
    @SequenceGenerator(name = "BLOG_IMAGE", sequenceName = "BLOG_IMAGE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BLOG_IMAGE")
    @Column(name = "BLOG_IMAGE_ID")
    private Long blogImageId;
    @Column(name = "BLOG_ID")
    private Long blogId;
    @Column(name = "IMAGE")
    private String image;
}

package com.example.test.models.blog.entity;

import com.example.test.entities.RoleEntity;
import com.example.test.models.category.entity.CategoryEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "BLOG")
public class BlogEntity {
    @Id
    @SequenceGenerator(name = "BLOG", sequenceName = "BLOG_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BLOG")
    @Column(name = "BLOG_ID")
    private Long blogId;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "SUB_CONTENT")
    private String subContent;
    @Column(name = "POST_TIME")
    private Instant postTime;
    @Column(name = "GROUP_ID")
    private Long groupId;
    @Column(name = "USER_ID")
    private Long userId;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "category_blog",
            joinColumns = @JoinColumn(name = "BLOG_ID"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
    Set<CategoryEntity> categoryEntities = new HashSet<>();
}

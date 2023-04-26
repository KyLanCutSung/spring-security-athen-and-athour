package com.example.test.models.blog.dto;

import lombok.Data;

import java.time.Instant;
import java.util.Set;

@Data
public class BlogDto {
    private Long blogId;
    private String title;
    private String content;
    private String subContent;
    private Instant postTime;
    private Long groupId;
    private Long userId;
    Set<String> categoryDtos;
}

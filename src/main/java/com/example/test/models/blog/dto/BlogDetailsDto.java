package com.example.test.models.blog.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class BlogDetailsDto {

    private String title;
    private String content;
    private String subContent;
    private Instant postTime;
    private Long groupName;
    private Long userName;
}

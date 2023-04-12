package com.example.test.models.blog_image.repo;

import com.example.test.models.blog_image.entity.BlogImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogImageRepository extends JpaRepository<BlogImageEntity, Long> {
}

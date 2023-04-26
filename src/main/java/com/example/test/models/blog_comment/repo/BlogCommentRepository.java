package com.example.test.models.blog_comment.repo;

import com.example.test.models.blog_comment.entity.BlogCommentEntity;
import com.example.test.models.blog_comment.entity.BlogCommentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogCommentRepository extends JpaRepository<BlogCommentEntity, BlogCommentId> {
}

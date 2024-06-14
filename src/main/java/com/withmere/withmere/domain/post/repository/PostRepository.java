package com.withmere.withmere.domain.post.repository;

import com.withmere.withmere.domain.post.Category;
import com.withmere.withmere.domain.post.Post;
import com.withmere.withmere.domain.post.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {
}

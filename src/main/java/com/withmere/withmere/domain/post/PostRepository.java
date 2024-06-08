package com.withmere.withmere.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByCategory(Category category);
    List<Post> findAllByTitleContainingOrContentContaining(String title, String content);
}

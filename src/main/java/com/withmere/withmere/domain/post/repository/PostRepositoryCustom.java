package com.withmere.withmere.domain.post.repository;

import com.withmere.withmere.domain.post.Category;
import com.withmere.withmere.domain.post.Field;
import com.withmere.withmere.domain.post.Post;
import com.withmere.withmere.domain.post.Status;

import java.util.List;

public interface PostRepositoryCustom {
    List<Post> findAllByCategory(Category category);
    List<Post> findAllByCategoryAndTitleContainingOrContentContaining(Category category, String title, String content);
    List<Post> findAllByStatus(Status status);
    List<Post> findAllByCategoryAndStatus(Category category, Status status);
    List<Post> findAllByTitleContainingOrContentContaining(String title, String content);
    List<Post> findAllByCategoryAndFieldAndStatusOrderByDesc(Category category, Field field, Status status, String sort);
    List<Post> findAllByCategoryAndStatusOrderByCreatedDateDesc(Category category, Status status, String sort);
    List<Post> findAllByUserId(Long userId);
    Long countAllByUserId(Long userId);
}

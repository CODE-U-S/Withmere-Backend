package com.withmere.withmere.domain.like;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findAllByPostId(Long postId);
    List<Like> findAllByUserId(Long userId);

    Long countAllByPostId(Long postId);

    boolean existsByUserIdAndPostId(Long userId, Long postId);
}

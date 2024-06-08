package com.withmere.withmere.domain.like.dto;

import com.withmere.withmere.domain.like.Like;
import com.withmere.withmere.domain.post.Post;
import com.withmere.withmere.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class LikeResponse {
    private final Long id;
    private final User user;
    private final Post post;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public LikeResponse(Like like) {
        this.id = like.getId();
        this.user = like.getUser();
        this.post = like.getPost();
        this.createdDate = like.getCreatedDate();
        this.modifiedDate = like.getModifiedDate();
    }
}

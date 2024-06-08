package com.withmere.withmere.domain.like.dto;

import com.withmere.withmere.domain.like.Like;
import com.withmere.withmere.domain.post.Post;
import com.withmere.withmere.domain.user.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddLikeRequest {
    @NotNull(message = "user의 id를 넣어주세요.")
    private User user;

    @NotNull(message = "post의 id를 넣어주세요.")
    private Post post;

    public Like toEntity() {
        return Like.builder()
                .user(user)
                .post(post)
                .build();
    }
}

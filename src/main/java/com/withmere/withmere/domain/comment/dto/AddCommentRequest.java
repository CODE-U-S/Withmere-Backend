package com.withmere.withmere.domain.comment.dto;

import com.withmere.withmere.domain.comment.Comment;
import com.withmere.withmere.domain.post.Post;
import com.withmere.withmere.domain.user.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddCommentRequest {
    @NotNull(message = "user의 id를 넣어주세요.")
    private User user;

    @NotNull(message = "post의 id를 넣어주세요.")
    private Post post;

    @NotEmpty(message = "댓글을 작성해주세요.")
    private String comment;

    public Comment toEntity() {
        return Comment.builder()
                .user(user)
                .post(post)
                .comment(comment)
                .build();
    }
}

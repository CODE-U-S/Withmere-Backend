package com.withmere.withmere.domain.comment.dto;

import com.withmere.withmere.domain.comment.Comment;
import com.withmere.withmere.domain.post.Post;
import com.withmere.withmere.domain.user.User;
import lombok.Getter;

@Getter
public class CommentResponse {
    private final Long id;
    private final User user;
    private final Post post;
    private final String comment;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.user = comment.getUser();
        this.post = comment.getPost();
        this.comment = comment.getComment();
    }
}

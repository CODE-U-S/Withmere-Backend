package com.withmere.withmere.domain.post.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.withmere.withmere.domain.post.Category;
import com.withmere.withmere.domain.post.Field;
import com.withmere.withmere.domain.post.Post;
import com.withmere.withmere.domain.post.Status;
import com.withmere.withmere.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final User user;
    private final Category category;
    private final Field field;
    private final Status status;

//    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDateTime createdDate;

//    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDateTime modifiedDate;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.user = post.getUser();
        this.category = post.getCategory();
        this.field = post.getField();
        this.status = post.getStatus();
        this.createdDate = post.getCreatedDate();
        this.modifiedDate = post.getModifiedDate();
    }
}

package com.withmere.withmere.domain.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.withmere.withmere.domain.comment.Comment;
import com.withmere.withmere.domain.user.User;
import com.withmere.withmere.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {
    private String title;

    @Column(columnDefinition = "text")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Field field;

    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonIgnore
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> commentList;

    @Builder
    public Post(String title, String content, User user, Category category, Field field, Status status) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.category = category;
        this.field = field;
        this.status = status;
    }

    public void update(String title, String content, Field field) {
        this.title = title;
        this.content = content;
        this.field = field;
    }

    public void updateStatus(Status status) {
        this.status = status;
    }
}

package com.withmere.withmere.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.withmere.withmere.domain.comment.Comment;
import com.withmere.withmere.domain.post.Post;
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
public class User extends BaseEntity {
    private String name;

    @Column(unique = true)
    private String email;

    private String description;

    @JsonIgnore
    private String pw;

    @Enumerated(EnumType.STRING)
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> postList;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> commentList;

    @Builder
    public User(String name, String description, String email, String pw, Category category) {
        this.name = name;
        this.description = description;
        this.email = email;
        this.pw = pw;
        this.category = category;
    }

    public void updateName(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }
}

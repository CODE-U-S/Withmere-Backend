package com.withmere.withmere.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.withmere.withmere.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String pw;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Builder
    public User(String name, String email, String pw, Category category) {
        this.name = name;
        this.email = email;
        this.pw = pw;
        this.category = category;
    }
}

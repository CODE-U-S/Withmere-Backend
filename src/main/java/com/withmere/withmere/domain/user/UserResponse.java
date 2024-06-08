package com.withmere.withmere.domain.user;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponse {
    private final Long id;
    private final String name;
    private final String email;
    private final Category category;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.category = user.getCategory();
        this.createdDate = user.getCreatedDate();
        this.modifiedDate = user.getModifiedDate();
    }
}

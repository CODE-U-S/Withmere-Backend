package com.withmere.withmere.domain.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Category {
    TEAM("팀프로젝트"),
    DEVELOPER("개발자"),
    DESIGNER("디자이너"),
    STUDY("스터디");

    private final String description;

    public static Category findByCategory(String description) {
        return Arrays.stream(Category.values())
                .filter(category -> category.hasDescription(description))
                .findAny()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    public boolean hasDescription(String description) {
        return getDescription().equals(description);
    }
}

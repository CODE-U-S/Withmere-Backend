package com.withmere.withmere.domain.post;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    TEAM("팀프로젝트"),
    DEVELOPER("개발자"),
    DESIGNER("디자이너"),
    STUDY("스터디");

    @JsonValue
    private final String description;
}

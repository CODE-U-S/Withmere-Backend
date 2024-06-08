package com.withmere.withmere.domain.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Field {
    App("App(모바일 애플리케이션)"),
    Web("Web(웹 애플리케이션)"),
    DESKTOP("데스크톱 애플리케이션"),
    GAME("게임"),
    VR_OR_AR("가상 현실(VR) 및 증강 현실(AR)"),
    Embedded_SYSTEM_OR_IOT("임베디드 시스템 및 Iot"),
    AI("인공지능 및 머신러닝"),
    CLOUD("클라우드 솔루션 및  DevOps"),
    SCRIPTING("자동화 및 스크립팅"),
    UI_UX("UI/UX 디자인"),
    GRAPHIC("그래픽 디자인"),
    ILLUSTRATE("일러스트레이션"),
    INDUSTRY("산업 디자인"),
    PASSION("패션 디자인"),
    INTERIOR("인테리어 디자인"),
    MOTION_GRAPHIC("모션 그래픽 디자인"),
    BRAND("브랜드 디자인");

    private final String description;

    public static Field findByField(String description) {
        return Arrays.stream(Field.values())
                .filter(field -> field.hasDescription(description))
                .findAny()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    public boolean hasDescription(String description) {
        return getDescription().equals(description);
    }
}

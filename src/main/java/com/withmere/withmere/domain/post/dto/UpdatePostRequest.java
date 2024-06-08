package com.withmere.withmere.domain.post.dto;

import com.withmere.withmere.domain.post.Field;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdatePostRequest {
    private String title;
    private String content;
    private Field field;
}

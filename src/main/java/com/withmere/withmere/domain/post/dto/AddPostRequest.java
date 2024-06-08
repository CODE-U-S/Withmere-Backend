package com.withmere.withmere.domain.post.dto;

import com.withmere.withmere.domain.post.Category;
import com.withmere.withmere.domain.post.Field;
import com.withmere.withmere.domain.post.Post;
import com.withmere.withmere.domain.user.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddPostRequest {
    @NotEmpty(message = "제목 칸이 비어있습니다.")
    private String title;

    private String content;

    @NotNull(message = "user의 id를 넣어주세요.")
    private User user;

    private Category category;

    private Field field;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .user(user)
                .category(category)
                .field(field)
                .build();
    }
}

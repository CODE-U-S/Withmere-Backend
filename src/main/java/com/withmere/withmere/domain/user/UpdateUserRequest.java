package com.withmere.withmere.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateUserRequest {
    @NotEmpty(message = "이름을 작성해주세요.")
    private String name;

    @NotNull(message = "한줄소개를 작성해주세요.")
    private String description;

    @NotEmpty(message = "이메일을 작성해주세요.")
    @Email(message = "이메일 형식이 맞지 않습니다.")
    private String email;
}

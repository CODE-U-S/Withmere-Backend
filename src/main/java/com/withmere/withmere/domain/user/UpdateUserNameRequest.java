package com.withmere.withmere.domain.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateUserNameRequest {
    @NotEmpty(message = "이름을 작성해주세요.")
    private String name;
}

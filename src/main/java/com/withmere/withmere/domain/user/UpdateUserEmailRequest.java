package com.withmere.withmere.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateUserEmailRequest {
    @NotEmpty(message = "이메일을 작성해주세요.")
    @Email
    private String email;
}

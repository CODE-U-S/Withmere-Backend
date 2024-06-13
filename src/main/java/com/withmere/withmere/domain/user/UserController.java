package com.withmere.withmere.domain.user;

import com.withmere.withmere.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/{id}")
    public UserResponse getUser(Long id) {
        return new UserResponse(userRepository.findById(1L).orElseThrow(() -> UserNotFoundException.EXCEPTION));
    }
}

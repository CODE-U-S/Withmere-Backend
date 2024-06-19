package com.withmere.withmere.domain.user;

import com.withmere.withmere.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable("id") Long id) {
        return new UserResponse(userRepository.findById(1L).orElseThrow(() -> UserNotFoundException.EXCEPTION));
    }

    @PutMapping("/{id}")
    public UserResponse updateUserName(
            @PathVariable("id") Long id,
            @RequestBody UpdateUserNameRequest request
    ) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        user.updateName(request.getName());

        return new UserResponse(user);
    }

    @PutMapping("/{id}")
    public UserResponse updateUserEmail(
            @PathVariable("id") Long id,
            @RequestBody UpdateUserEmailRequest request
    ) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        user.updateEmail(request.getEmail());

        return new UserResponse(user);
    }

}

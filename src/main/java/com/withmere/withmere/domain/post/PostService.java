package com.withmere.withmere.domain.post;

import com.withmere.withmere.domain.post.PostRepository;
import com.withmere.withmere.domain.post.dto.AddPostRequest;
import com.withmere.withmere.domain.post.dto.PostResponse;
import com.withmere.withmere.domain.user.UserRepository;
import com.withmere.withmere.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public PostResponse save(AddPostRequest request) {
        if(!userRepository.existsById(request.getUser().getId())) throw UserNotFoundException.EXCEPTION;
        return new PostResponse(postRepository.save(request.toEntity()));
    }
}

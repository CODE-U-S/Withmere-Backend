package com.withmere.withmere.domain.like;

import com.withmere.withmere.domain.like.dto.AddLikeRequest;
import com.withmere.withmere.domain.like.dto.LikeResponse;
import com.withmere.withmere.domain.post.PostRepository;
import com.withmere.withmere.domain.user.UserRepository;
import com.withmere.withmere.global.exception.PostNotFoundException;
import com.withmere.withmere.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional
    public LikeResponse save(AddLikeRequest request) {
        if(!userRepository.existsById(request.getUser().getId())) throw UserNotFoundException.EXCEPTION;
        if(!postRepository.existsById(request.getPost().getId())) throw PostNotFoundException.EXCEPTION;
        return new LikeResponse(likeRepository.save(request.toEntity()));
    }


}

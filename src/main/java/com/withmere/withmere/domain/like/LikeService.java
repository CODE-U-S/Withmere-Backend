package com.withmere.withmere.domain.like;

import com.withmere.withmere.domain.like.dto.AddLikeRequest;
import com.withmere.withmere.domain.like.dto.LikeResponse;
import com.withmere.withmere.domain.post.PostRepository;
import com.withmere.withmere.domain.user.UserRepository;
import com.withmere.withmere.global.exception.LikeDuplicateException;
import com.withmere.withmere.global.exception.LikeNotFoundException;
import com.withmere.withmere.global.exception.PostNotFoundException;
import com.withmere.withmere.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
        if(likeRepository.existsByUserIdAndPostId(
                request.getUser().getId(),
                request.getPost().getId()
        )) throw LikeDuplicateException.EXCEPTION;
        return new LikeResponse(likeRepository.save(request.toEntity()));
    }

    @Transactional(readOnly = true)
    public List<LikeResponse> findAllByPostId(Long postId) {
        if(!postRepository.existsById(postId)) throw PostNotFoundException.EXCEPTION;
        return likeRepository.findAllByPostId(postId)
                .stream()
                .map(LikeResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Long countAllByPostId(Long postId) {
        if(!postRepository.existsById(postId)) throw PostNotFoundException.EXCEPTION;
        return likeRepository.countAllByPostId(postId);
    }

    @Transactional
    public void delete(Long id) {
        if(!likeRepository.existsById(id)) throw LikeNotFoundException.EXCEPTION;
        likeRepository.deleteById(id);
    }
}

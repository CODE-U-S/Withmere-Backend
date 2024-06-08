package com.withmere.withmere.domain.comment;

import com.withmere.withmere.domain.comment.dto.AddCommentRequest;
import com.withmere.withmere.domain.comment.dto.CommentResponse;
import com.withmere.withmere.domain.post.PostRepository;
import com.withmere.withmere.domain.user.UserRepository;
import com.withmere.withmere.global.exception.PostNotFoundException;
import com.withmere.withmere.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional
    public CommentResponse save(AddCommentRequest request) {
        if(!userRepository.existsById(request.getUser().getId())) throw UserNotFoundException.EXCEPTION;
        if(!postRepository.existsById(request.getPost().getId())) throw PostNotFoundException.EXCEPTION;
        return new CommentResponse(commentRepository.save(request.toEntity()));
    }
}

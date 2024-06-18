package com.withmere.withmere.domain.comment;

import com.withmere.withmere.domain.comment.dto.AddCommentRequest;
import com.withmere.withmere.domain.comment.dto.CommentResponse;
import com.withmere.withmere.domain.comment.dto.UpdateCommentRequest;
import com.withmere.withmere.domain.post.repository.PostRepository;
import com.withmere.withmere.domain.user.UserRepository;
import com.withmere.withmere.global.exception.CommentNotFoundException;
import com.withmere.withmere.global.exception.PostNotFoundException;
import com.withmere.withmere.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public List<CommentResponse> findAllByPostId(Long postId) {
        if(!postRepository.existsById(postId)) throw PostNotFoundException.EXCEPTION;

        return commentRepository.findAllByPostId(postId)
                .stream()
                .map(CommentResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long countAllByPostId(Long postId) {
        if(!postRepository.existsById(postId)) throw PostNotFoundException.EXCEPTION;
        return commentRepository.countAllByPostId(postId);
    }

    @Transactional
    public void delete(Long id) {
        if(!commentRepository.existsById(id)) throw CommentNotFoundException.EXCEPTION;
        commentRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, UpdateCommentRequest request) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);

        comment.update(request.getComment());
    }
}

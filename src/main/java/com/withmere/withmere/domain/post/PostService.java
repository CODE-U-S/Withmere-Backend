package com.withmere.withmere.domain.post;

import com.withmere.withmere.domain.post.dto.AddPostRequest;
import com.withmere.withmere.domain.post.dto.PostResponse;
import com.withmere.withmere.domain.post.dto.UpdatePostRequest;
import com.withmere.withmere.domain.post.repository.PostRepository;
import com.withmere.withmere.domain.user.UserRepository;
import com.withmere.withmere.global.exception.PostNotFoundException;
import com.withmere.withmere.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public List<PostResponse> findAllByCategory(Category category) {
        return postRepository.findAllByCategory(category)
                .stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> findAllByCategoryAndTitleContainingOrContentContaining(Category category, String search) {
        return postRepository.findAllByCategoryAndTitleContainingOrContentContaining(category, search, search)
                .stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> findAllByStatus(Status status) {
        return postRepository.findAllByStatus(status)
                .stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> findAllByCategoryAndStatus(Category category, Status status) {
        return postRepository.findAllByCategoryAndStatus(category, status)
                .stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> findAllByTitleOrContent(String title, String content) {
        return postRepository.findAllByTitleContainingOrContentContaining(title, content)
                .stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostResponse findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);
        return new PostResponse(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> findAllByUserId(Long userId) {
        if(!userRepository.existsById(userId)) throw UserNotFoundException.EXCEPTION;

        return postRepository.findAllByUserId(userId)
                .stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Long countAllByUserId(Long userId) {
        if(!userRepository.existsById(userId)) throw UserNotFoundException.EXCEPTION;
        return postRepository.countAllByUserId(userId);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> findAllByFieldAndStatusAndSort(Category category, Field field, Status status, String sort) {
        List<PostResponse> response = null;

        switch (sort) {
            case "likes":
                response = postRepository.findAllByCategoryAndFieldAndStatusOrderByLikeCountDesc(category, field, status)
                        .stream()
                        .map(PostResponse::new)
                        .toList();
                break;

            case "comments":
                response = postRepository.findAllByCategoryAndFieldAndStatusOrderByCommentCountDesc(category, field, status)
                        .stream()
                        .map(PostResponse::new)
                        .toList();
                break;

            default:
                response = postRepository.findAllByCategoryAndFieldAndStatusOrderByCreatedDateDesc(category, field, status)
                        .stream()
                        .map(PostResponse::new)
                        .toList();
        }

        return response;
    }

    @Transactional
    public void update(Long id, UpdatePostRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        post.update(request.getTitle(), request.getContent(), request.getCategory(), request.getField());
    }

    @Transactional
    public void updateStatus(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        post.updateStatus(Status.CLOSE);
    }

    @Transactional
    public void delete(Long id) {
        if(!postRepository.existsById(id)) throw PostNotFoundException.EXCEPTION;
        postRepository.deleteById(id);
    }
}

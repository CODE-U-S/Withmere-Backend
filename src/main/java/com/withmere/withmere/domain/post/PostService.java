package com.withmere.withmere.domain.post;

import com.withmere.withmere.domain.post.dto.AddPostRequest;
import com.withmere.withmere.domain.post.dto.PostResponse;
import com.withmere.withmere.domain.post.dto.UpdatePostRequest;
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
    public List<PostResponse> findAllByStatus(Status status) {
        return postRepository.findAllByStatus(status)
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

    @Transactional
    public void update(Long id, UpdatePostRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        post.update(request.getTitle(), request.getContent(), request.getField());
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

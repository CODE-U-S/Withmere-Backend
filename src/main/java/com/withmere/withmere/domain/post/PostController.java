package com.withmere.withmere.domain.post;

import com.withmere.withmere.domain.post.dto.AddPostRequest;
import com.withmere.withmere.domain.post.dto.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping
    public PostResponse savePost(@RequestBody AddPostRequest request) {
        return postService.save(request);
    }
}

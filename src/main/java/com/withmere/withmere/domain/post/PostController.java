package com.withmere.withmere.domain.post;

import com.withmere.withmere.domain.post.dto.AddPostRequest;
import com.withmere.withmere.domain.post.dto.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostResponse savePost(@RequestBody AddPostRequest request) {
        return postService.save(request);
    }

    @GetMapping("/{category}")
    public List<PostResponse> findAllByCategoryPost(@PathVariable String category) {
        return postService.findAllByCategory(Category.findByCategory(category));
    }
}

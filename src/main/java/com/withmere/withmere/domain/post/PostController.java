package com.withmere.withmere.domain.post;

import com.withmere.withmere.domain.post.dto.AddPostRequest;
import com.withmere.withmere.domain.post.dto.PostResponse;
import com.withmere.withmere.domain.post.dto.UpdatePostRequest;
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

    @GetMapping("/category/{category}/field/{field}/status/{status}/sort/{sort}")
    public List<PostResponse> findAllByFieldAndStatusSort(@PathVariable("category") String category, @PathVariable("field") String field, @PathVariable("status") String status, @PathVariable("sort") String sort) {
        return postService.findAllByFieldAndStatusAndSort(
                Category.findByCategory(category),
                Field.findByField(field),
                Status.valueOf(status),
                sort
        );
    }

    @GetMapping("/category/{category}")
    public List<PostResponse> findAllByCategoryPost(@PathVariable("category") String category) {
        return postService.findAllByCategory(Category.findByCategory(category));
    }

    @GetMapping("/category/{category}/search/{search}")
    public List<PostResponse> findAllByCategoryAndTitleContainingOrContentContaining(@PathVariable("category") String category, @PathVariable("search") String search) {
        return postService.findAllByCategoryAndTitleContainingOrContentContaining(Category.findByCategory(category), search);
    }

    @GetMapping("/status/{status}")
    public List<PostResponse> findAllByStatusPost(@PathVariable("status") String status) {
        return postService.findAllByStatus(Status.valueOf(status));
    }

    @GetMapping("/category/{category}/status/{status}")
    public List<PostResponse> findAllByCategoryAndStatus(@PathVariable("category") String category, @PathVariable("status") String status) {
        return postService.findAllByCategoryAndStatus(Category.findByCategory(category), Status.valueOf(status));
    }

    @GetMapping("/search/{search}")
    public List<PostResponse> findAllByTitleOrContentPost(@PathVariable("search") String search) {
        return postService.findAllByTitleOrContent(search, search);
    }

    @GetMapping("/{id}")
    public PostResponse findByIdPost(@PathVariable("id") Long id) {
        return postService.findById(id);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable("id") Long id, @RequestBody UpdatePostRequest request) {
        postService.update(id, request);
    }

    @PutMapping("/status/{id}")
    public void updateStatusPost(@PathVariable("id") Long id) {
        postService.updateStatus(id);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") Long id) {
        postService.delete(id);
    }
}

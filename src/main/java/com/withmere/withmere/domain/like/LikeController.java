package com.withmere.withmere.domain.like;

import com.withmere.withmere.domain.like.dto.AddLikeRequest;
import com.withmere.withmere.domain.like.dto.LikeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")
public class LikeController {
    private final LikeService likeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LikeResponse saveLike(@RequestBody AddLikeRequest request) {
        return likeService.save(request);
    }

    @GetMapping("/post/{id}")
    public List<LikeResponse> findAllByPostIdLike(@PathVariable("id") Long id) {
        return likeService.findAllByPostId(id);
    }

    @GetMapping("/user/{id}")
    public List<LikeResponse> findAllByUserIdLike(@PathVariable("id") Long id) {
        return likeService.findAllByUserId(id);
    }

    @GetMapping("/post/count/{id}")
    public Long countAllByPostIdLike(@PathVariable("id") Long id) {
        return likeService.countAllByPostId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLike(@PathVariable("id") Long id) {
        likeService.delete(id);
    }
}

package com.withmere.withmere.domain.like;

import com.withmere.withmere.domain.like.dto.AddLikeRequest;
import com.withmere.withmere.domain.like.dto.LikeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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


}

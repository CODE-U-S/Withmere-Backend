package com.withmere.withmere.domain.comment;

import com.withmere.withmere.domain.comment.dto.AddCommentRequest;
import com.withmere.withmere.domain.comment.dto.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponse saveComment(@RequestBody AddCommentRequest request) {
        return commentService.save(request);
    }
}

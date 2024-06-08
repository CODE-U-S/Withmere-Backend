package com.withmere.withmere.domain.comment;

import com.withmere.withmere.domain.comment.dto.AddCommentRequest;
import com.withmere.withmere.domain.comment.dto.CommentResponse;
import com.withmere.withmere.domain.comment.dto.UpdateCommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/post/{id}")
    public List<CommentResponse> findAllByPostIdComment(@PathVariable Long id) {
        return commentService.findAllByPostId(id);
    }

    @PutMapping("/{id}")
    public void updateComment(@PathVariable Long id, @RequestBody UpdateCommentRequest request) {
        commentService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.delete(id);
    }
}

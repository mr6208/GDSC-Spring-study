package com.study.study.controller;


import com.study.study.dto.comment.request.CommentCreateRequest;
import com.study.study.dto.comment.request.CommentUpdateRequest;
import com.study.study.dto.comment.response.CommentListResponse;
import com.study.study.dto.comment.response.CommentResponse;
import com.study.study.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    // 댓글 생성
    @PostMapping("/{id}")
    public ResponseEntity<CommentResponse> createComment(@PathVariable Long id, @RequestBody CommentCreateRequest request) {
        return ResponseEntity.ok(commentService.createComment(id, request));
    }

    // 전체 조회
    @GetMapping("/{id}")
    public ResponseEntity<CommentListResponse> findAllByPostId(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.findAllByPostId(id));
    }

    // 업데이트
    @Transactional
    @PutMapping
    public ResponseEntity<CommentResponse> updateComment(@RequestBody CommentUpdateRequest request) {
        return ResponseEntity.ok(commentService.updateComment(request));
    }

    // soft delete
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.delete(id);
    }
}

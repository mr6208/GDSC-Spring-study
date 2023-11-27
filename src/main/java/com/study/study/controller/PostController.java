package com.study.study.controller;

import com.study.study.dto.request.PostCreateRequest;
import com.study.study.dto.request.PostUpdateRequest;
import com.study.study.dto.response.PostListResponse;
import com.study.study.dto.response.PostResponse;
import com.study.study.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;


    // 생성
    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestBody PostCreateRequest request) {
        return ResponseEntity.ok(postService.createPost(request));
    }

    // 전체조회
    @GetMapping
    public ResponseEntity<PostListResponse> findALl() {
        return ResponseEntity.ok(postService.findAll());
    }


    // 단건조회
    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    // 업데이트
    @PutMapping
    public ResponseEntity<PostResponse> updatePost(@RequestBody PostUpdateRequest postUpdateRequest) {
        return ResponseEntity.ok(postService.updatePost(postUpdateRequest));
    }


    // soft delete
    @DeleteMapping("{id}")
    public void deletePost(@PathVariable Long id) {
        postService.delete(id);
    }
}
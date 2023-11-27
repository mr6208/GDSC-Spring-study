package com.study.study.service;

import com.study.study.dto.request.PostCreateRequest;
import com.study.study.dto.request.PostUpdateRequest;
import com.study.study.dto.response.PostListResponse;
import com.study.study.dto.response.PostResponse;
import com.study.study.entity.Post;
import com.study.study.mapper.PostMapper;
import com.study.study.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostResponse createPost(PostCreateRequest postRequest) {
        Post post = postRepository.save(postMapper.toEntity(postRequest));
        return postMapper.toResponse(post);
    }

    @Transactional
    public PostResponse updatePost(PostUpdateRequest request) {
        Post post = postRepository.findById(request.getId()).orElseThrow(IllegalStateException::new);
        post.update(request.getTitle(), request.getContent());
        return postMapper.toResponse(post);
    }

    public PostListResponse findAll() {
        List<Post> posts = postRepository.findAll();
        return postMapper.toListResponse(posts);
    }

    public PostResponse findById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(IllegalStateException::new);
        return postMapper.toResponse(post);
    }

    @Transactional
    public void delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow(IllegalStateException::new);
        post.delete();
    }
}

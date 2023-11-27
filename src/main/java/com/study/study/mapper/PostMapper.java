package com.study.study.mapper;

import com.study.study.dto.request.PostCreateRequest;
import com.study.study.dto.response.PostListResponse;
import com.study.study.dto.response.PostResponse;
import com.study.study.entity.Post;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {

    public Post toEntity(PostCreateRequest request) {
        return Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    public PostResponse toResponse(Post post) {
        return PostResponse.builder()
                .id(post.getPostId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    public PostListResponse toListResponse(List<Post> postList) {
        List<PostResponse> postResponseList =
                postList.stream().map(this::toResponse).collect(Collectors.toList());
        return PostListResponse.builder()
                .postList(postResponseList)
                .build();
    }

}

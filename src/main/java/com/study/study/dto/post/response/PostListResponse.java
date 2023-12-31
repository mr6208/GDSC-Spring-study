package com.study.study.dto.post.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class PostListResponse {
    private List<PostResponse> postList;
}
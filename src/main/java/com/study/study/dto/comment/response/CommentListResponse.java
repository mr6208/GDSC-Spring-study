package com.study.study.dto.comment.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class CommentListResponse {

    private List<CommentResponse> commentList;
}

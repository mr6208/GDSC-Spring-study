package com.study.study.dto.comment.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class CommentResponse {

    private Long id;
    private String writer;
    private String comment;
}

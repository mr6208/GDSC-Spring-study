package com.study.study.mapper;


import com.study.study.dto.comment.request.CommentCreateRequest;
import com.study.study.dto.comment.response.CommentListResponse;
import com.study.study.dto.comment.response.CommentResponse;
import com.study.study.entity.Comment;
import com.study.study.entity.Post;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentMapper {

    public Comment toEntity(CommentCreateRequest request, Post post) {
        return Comment.builder()
                .writer(request.getWriter())
                .comment(request.getComment())
                .post(post)
                .build();
    }

    public CommentResponse toResponse(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getCommentId())
                .writer(comment.getWriter())
                .comment(comment.getComment())
                .build();
    }

    public CommentListResponse toListResponse(List<Comment> commentList) {
        List<CommentResponse> commentResponseList =
                commentList.stream().map(this::toResponse).collect(Collectors.toList());
        return CommentListResponse.builder()
                .commentList(commentResponseList)
                .build();
    }
}

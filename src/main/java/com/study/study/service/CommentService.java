package com.study.study.service;

import com.study.study.dto.comment.request.CommentCreateRequest;
import com.study.study.dto.comment.request.CommentUpdateRequest;
import com.study.study.dto.comment.response.CommentListResponse;
import com.study.study.dto.comment.response.CommentResponse;
import com.study.study.entity.Comment;
import com.study.study.entity.Post;
import com.study.study.mapper.CommentMapper;
import com.study.study.repository.CommentRepository;
import com.study.study.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentResponse createComment(Long postId, CommentCreateRequest commentRequest) {
        Post post = postRepository.findById(postId).orElseThrow(IllegalStateException::new);
        Comment comment = commentRepository.save(commentMapper.toEntity(commentRequest,post));

        return commentMapper.toResponse(comment);
    }

    @Transactional
    public CommentResponse updateComment(CommentUpdateRequest request) {
        Comment comment = commentRepository.findById(request.getId()).orElseThrow(IllegalStateException::new);
        comment.update(request.getComment());

        return commentMapper.toResponse(comment);
    }

    public CommentListResponse findAllByPostId(Long id) {
        Post post = postRepository.findById(id).orElseThrow(IllegalStateException::new);
        List<Comment> comments = commentRepository.findCommentsByPost(post);
        
        return commentMapper.toListResponse(comments);
    }

    @Transactional
    public void delete(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(IllegalStateException::new);
        comment.delete();
    }

}

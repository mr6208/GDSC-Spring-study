package com.study.study.repository;

import com.study.study.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post save(Post post);
    Optional<Post> findById(Long id);
    List<Post> findAll();


}

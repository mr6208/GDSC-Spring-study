package com.study.study.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "comment")
@EntityListeners(AuditingEntityListener.class)
@Where(clause = "is_deleted is null")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String writer;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment;

    @Column(name = "create_at")
    @CreatedDate
    private String createAt;

    @Column(name = "modified_at")
    @LastModifiedDate
    private String modifiedAt;

    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;

    @Builder
    public Comment(String writer, String comment, Post post) {
        this.writer = writer;
        this.comment = comment;
        this.post = post;
    }

    public void update(String comment) {
        this.comment = comment;
    }

    public void delete() {
        this.isDeleted = true;
    }
}

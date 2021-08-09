package com.example.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.backend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findById(Long commentId);

    Page<Comment> findByOwner(Long ownerId, Pageable pageable);

    List<Comment> findByPostId(Long postId);

    List<Comment> findByPostIds(List<Long> postIds);
}

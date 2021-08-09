package com.example.backend.repository;

import com.example.backend.model.Category;
import com.example.backend.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long postId);

    @Query(value = "SELECT * FROM posts WHERE post_owner_id = ?1", nativeQuery = true)
    List<Post> findByUserId(Long userId);
}


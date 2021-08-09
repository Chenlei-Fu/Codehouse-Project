package com.example.backend.repository;

import com.example.backend.model.Post;
import org.springframework.data.domain.Page;
import com.example.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c.postList FROM Category c where c.categoryId = :categoryId")
    List<Post> getPostsByCategoryId(@Param("categoryId") Long categoryId);

    @Query("SELECT c.postList FROM Category c where c.categoryName = :categoryName")
    List<Post> getPostsByCategoryName(@Param("categoryName") String categoryName);
    
    @Query(value = "SELECT * FROM Category", nativeQuery = true)
    List<Category> findAllCategories();
}

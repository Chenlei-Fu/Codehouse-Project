package com.example.backend.service;

import com.example.backend.exception.AppException;
import com.example.backend.exception.BadRequestException;
import com.example.backend.model.Category;
import com.example.backend.model.Post;
import com.example.backend.model.Comment;
import com.example.backend.payload.CategoryRequest;
import com.example.backend.payload.CommentRequest;
import com.example.backend.payload.CommentResponse;
import com.example.backend.payload.PagedResponse;
import com.example.backend.payload.PostRequest;
import com.example.backend.payload.PostResponse;
import com.example.backend.repository.PostRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.repository.CategoryRepository;
import com.example.backend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;

    public Post createPost(PostRequest postRequest) {
        Post post = new Post();
        post.setPostTitle(postRequest.getPostTitle());

        post.setPostBody(postRequest.getPostBody());

        post.setPostOwnerId(postRequest.getPostOwnerId());

        Instant createTime = Instant.now();
        post.setCreateTime(createTime);

        if(postRequest.getCategoryList() != null) {
            List<Category> categoryList = postRequest.getCategoryList();
            for(int i = 0; i < categoryList.size(); i++) {
                post.addCategory(categoryList.get(i));
            }
        }
        return postRepository.save(post);
    }

    public Comment createPostComment(CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setCommentBody(commentRequest.getCommentBody());
        comment.setCommentOwnerId(commentRequest.getCommentOwnerId());
        Post post = postRepository.findById(commentRequest.getCommentOwnerId()).orElseThrow(() -> new AppException("Fail to Create Post Comment"));
        comment.setPost(post);
        return commentRepository.save(comment);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAllPosts();
    }

    public List<Post> getPostsByCategoryId(Long id) {
        List<Post> posts = categoryRepository.getPostsByCategoryId(id);
        return posts;
    }
    
    public List<Post> getPostsByCategoryName(String categoryName) {
        List<Post> posts = categoryRepository.getPostsByCategoryName(categoryName);
        return posts;
    }

    public Post getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new AppException("get Post by Title failed"));
        return post;
    }

    public PostResponse getCommentsByPostId(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new AppException("get Comment By Id failed"));
        List<Comment> comments = post.getComments();
        PostResponse postResponse = new PostResponse();
        postResponse.setComments(comments);
        return postResponse;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAllCategories();
    }

    public List<PostResponse> getPostByUser(Long userId) {
        List<Post> posts = postRepository.findByUserId(userId);
        List<PostResponse> postResponseList = new ArrayList();
        for(Post post: posts){
            PostResponse postResponse = new PostResponse();
            postResponse.setId(post.getPostId());
            postResponse.setPostBody(post.getPostBody());
            postResponse.setPostTitle(post.getPostTitle());
            postResponse.setPostOwnerId(post.getPostOwnerId());
            postResponse.setCategoryList(post.getCategories());
            postResponse.setComments(post.getComments());
            postResponse.setCreateTime(post.getCreateTime());
            postResponseList.add(postResponse);
        }
        return postResponseList;
    }

}

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

    public PagedResponse<PostResponse> getAllPosts(Long currentUser, int page, int size) {
        validatePageNumberAndSize(page, size);
        // Retrieve Posts
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        Page<Post> posts = postRepository.findAll(pageable);

        if(posts.getNumberOfElements() == 0) {
        return new PagedResponse<>(Collections.emptyList(), posts.getNumber(),
                posts.getSize(), posts.getTotalElements(), posts.getTotalPages(), posts.isLast());
        }

        //Map posts to PostResponse
        List<Long> postIds = post.map(Post::getPostId).getContent();
        
        List<PostResponse> postResponseList = new ArrayList();
        for(Post post: postIds){
            PostResponse postResponse = new PostResponse();
            postResponse.setId(post.getPostId());
            postResponse.setPostBody(post.getPostBody());
            postResponse.setPostTitle(post.getPostTitle());
            postResponse.setPostOwnerId(post.getPostOwnerId());
            postResponse.addCategory(post.getCategory());
            postResponse.setComments(post.getComments());
            postResponse.setCreateTime(post.getCreateTime());
            postResponseList.add(postResponse);
        }
        return new PagedResponse<postResponses, posts.getNumber, posts.getSize(),
         posts.getTotalElements(), posts.getTotalPages(), posts.isLast());
    }
    
    public List<Post> getPostsByCategoryId(CategoryRequest categoryRequest) {
        List<Post> posts = categoryRepository.getPostsByCategoryId(categoryRequest.getCategoryId());
        return posts;
    }

    public List<Post> getPostsByCategoryName(CategoryRequest categoryRequest) {
        List<Post> posts = categoryRepository.getPostsByCategoryName(categoryRequest.getCategoryName());
        return posts;
    }

    public PostResponse getCommentsByPostId(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new AppException("get Comment By Id failed"));
        List<Comment> comments = post.getComments();
        PostResponse postResponse = new PostResponse();
        postResponse.setComments(comments);
        return postResponse;
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

    private void validatePageNumberAndSize(int page, int size) {
        if(page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if(size > AppConstants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }
    }
}

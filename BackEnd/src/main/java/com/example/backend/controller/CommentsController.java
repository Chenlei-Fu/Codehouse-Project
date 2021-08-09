package com.example.backend.controller;

import com.example.backend.model.Comment;
import com.example.backend.payload.ApiResponse;
import com.example.backend.payload.CommentRequest;
import com.example.backend.payload.CommentResponse;
import com.example.backend.repository.CommentRepository;
import com.example.backend.repository.PostRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.security.CurrentUser;
import com.example.backend.security.UserPrincipal;
import com.example.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
@RestController
@RequestMapping("/posts/comments")
public class CommentsController {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<?> createComments(@Valid @RequestBody CommentRequest commentsRequest) {
        Comment comment = postService.createPostComment(commentsRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{commentsId}")
                .buildAndExpand(comment.getCommentId()).toUri();
        return ResponseEntity.created(location).body(new ApiResponse(true, "Comments Create successfully"));
    }
}

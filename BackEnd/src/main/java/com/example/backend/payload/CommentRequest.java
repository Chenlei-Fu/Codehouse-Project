package com.example.backend.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CommentRequest {
    @NotBlank
    @Size(max = 160)
    private String commentBody;

    private Long commentOwnerId;

    private Long commentParentId;

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public Long getCommentOwnerId() {
        return commentOwnerId;
    }

    public void setCommentOwnerId(Long commentOwnerId) {
        this.commentOwnerId = commentOwnerId;
    }

    public Long getCommentParentId() {
        return commentParentId;
    }

    public void setCommentParentId(Long commentParentId) {
        this.commentParentId = commentParentId;
    }
}

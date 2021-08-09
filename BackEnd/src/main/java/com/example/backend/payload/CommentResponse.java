package com.example.backend.payload;

import java.time.Instant;

/**
 * A CommentResponse represents
 */
public class CommentResponse {
    private Long commentId;

    public Long getId() {
        return commentId;
    }

    public void setId(Long commentId) {
        this.commentId = commentId;
    }
    
    private String commentBody;

	public String getCommentBody() {
		return this.commentBody;
	}

	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}

    //owner of this comment - user id
	private Long commentOwnerId;

	public Long getCommentOwnerId() {
		return commentOwnerId;
	}

	public void setCommentOwnerId(Long commentOwnerId) {
		this.commentOwnerId = commentOwnerId;
	}

    //parent post of this comment - what is the topic for this comment
    private Long commentParentPostId;
    public Long getCommentParentPostId() {
        return commentParentPostId;
    }

    public void setCommentParentPostId(Long commentParentPostId) {
        this.commentParentPostId = commentParentPostId;
    }

    //parent comment of this comment - which comment does it replies to
    private Long commentParentCommentId;
    public Long getCommentParentCommentId() {
        return commentParentCommentId;
    }

    public void setCommentParentCommentId(Long commentParentCommentId) {
        this.commentParentCommentId = commentParentCommentId;
    }

    private Instant createTime;

	public Instant getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Instant createTime) {
		this.createTime = createTime;
	}
}

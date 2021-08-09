package com.example.backend.model;
import lombok.Builder;
import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private String commentBody;

    @Column(nullable = false)
    private Long commentOwnerId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    private Instant createTime;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

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

	public Instant getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Instant createTime) {
		this.createTime = createTime;
	}
}

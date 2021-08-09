package com.example.backend.model;
import com.example.backend.model.audit.UserDateAudit;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
@Entity
@Table(name = "posts")
public class Post{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    
    @Column(nullable = false)
    private String postTitle;

    @Column(nullable = false)
    private String postBody;

    @Column(nullable = false)
    private Long postOwnerId;


	@ManyToMany
    private List<Category> categories = new ArrayList<>();

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@OneToMany(
		mappedBy = "commentParentPostId",
		cascade = CascadeType.ALL,
		fetch = FetchType.EAGER,
		orphanRemoval = true
	)
	private List<Comment> comments = new ArrayList<>();

    private Instant createTime;

	public Instant getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Instant createTime) {
		this.createTime = createTime;
	}

	public Long getPostId() {
		return this.postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return this.postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostBody() {
		return this.postBody;
	}

	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}

	public Long getPostOwnerId() {
		return this.postOwnerId;
	}

	public void setPostOwnerId(Long postOwnerId) {
		this.postOwnerId = postOwnerId;
	}

	public void addCategory(Category category) {
		this.categories.add(category);
		category.addPost(this);
	}

	public void removeCategory(Category category) {
		this.categories.remove(category);
		category.removePost(this);
	}


	public List<Comment> getComments() {return this.comments;}

	public void addComment(Comment comment) {
		this.comments.add(comment);
		comment.setPost(this);
	}

	public void removeComment(Comment comment) {
		this.comments.remove(comment);
		comment.setPost(null);
	}
}

package com.example.backend.payload;
import com.example.backend.model.Category;
import com.example.backend.model.Comment;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;

public class PostResponse {
    private Long postId;

    public Long getId() {
        return postId;
    }

    public void setId(Long postId) {
        this.postId = postId;
    }
    
    private String postTitle;

	public String getPostTitle() {
		return this.postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

    private String postBody;

	public String getPostBody() {
		return this.postBody;
	}

	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}

	private Long postOwnerId;

	public Long getPostOwnerId() {
		return postOwnerId;
	}

	public void setPostOwnerId(Long postOwnerId) {
		this.postOwnerId = postOwnerId;
	}

    private List<Comment> comments;
    public List<Comment> getComments() {
        return comments;
    }
	public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

	private List<Category> categoryList;

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	private Instant createTime;

	public Instant getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Instant createTime) {
		this.createTime = createTime;
	}
}

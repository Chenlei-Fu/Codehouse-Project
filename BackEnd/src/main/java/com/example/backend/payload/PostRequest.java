package com.example.backend.payload;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import com.example.backend.model.Category;
import com.example.backend.model.Comment;

public class PostRequest {
    @NotBlank
    @Size(max=140)
    @Valid
    private String postTitle;

	public String getPostTitle() {
		return this.postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

    @NotBlank
    @Valid
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

	private List<Category> categoryList;

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	private List<Comment> comments;

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}

package com.example.backend.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String categoryName;

    private Long categoryCount;

	@ManyToMany
    private List<Post> postList = new ArrayList<>();

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getCategoryCount() {
		return this.categoryCount;
	}

	public void setCategoryCount(Long categoryCount) {
		this.categoryCount = categoryCount;
	}

	public void addPost(Post post) {this.postList.add(post);}

	public void removePost(Post post) {this.postList.remove(post);}
}

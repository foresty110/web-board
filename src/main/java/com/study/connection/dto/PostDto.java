package com.study.connection.dto;

import java.time.LocalDateTime;

public class PostDto {
    private long id;
    private int categoryId;
    private String title;
    private String author;
    private String password;
    private String content;
    private int viewCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String categoryName; //TODO Join을 통해 가져올 카테고리 이름을 담을 필드

    public PostDto() {}

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public int getViewCount() { return viewCount; }
    public void setViewCount(int viewCount) { this.viewCount = viewCount; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
}

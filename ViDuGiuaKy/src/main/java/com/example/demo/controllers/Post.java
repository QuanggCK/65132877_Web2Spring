package com.example.demo.controllers;

public class Post {
    public String id;
    public String title;
    public String content;
    public String categoryId;
    public String thumbnailImage;
    public Post() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public Post(String id, String title, String content, String categoryId, String thumbnailImage) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.categoryId = categoryId;
        this.thumbnailImage = thumbnailImage;
    }


}

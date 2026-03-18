package com.example.demo.controllers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pages") 
public class Page {


    @Id
    @Column(name="id")
    private String id;
    
    @Column(name="pageName")
    private String pageName;
    
    @Column(name="keyword")
    private String keyword; 
    
    @Column(name="content")
    private String content; 
    
    @Column(name="parentPageId")
    private String parentPageId;

    // Hàm khởi tạo rỗng (Bắt buộc phải có cho Spring Boot / JPA)
    public Page() {
    }

    // Hàm khởi tạo có tham số
    public Page(String id, String pageName, String keyword, String content, String parentPageId) {
        this.id = id;
        this.pageName = pageName;
        this.keyword = keyword;
        this.content = content;
        this.parentPageId = parentPageId;
    }

    // Các hàm Getter và Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getParentPageId() {
        return parentPageId;
    }

    public void setParentPageId(String parentPageId) {
        this.parentPageId = parentPageId;
    }
}
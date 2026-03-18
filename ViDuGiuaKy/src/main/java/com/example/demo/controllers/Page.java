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
    private int id;
    
    @Column(name="pagename")
    private String pageName;
    
    @Column(name="keyword")
    private String keyword; 
    
    @Column(name="content")
    private String content; 
    
    @Column(name="parentpageid")
    private String parentPageId;

    public Page() {
    }

    public Page(int id, String pageName, String keyword, String content, String parentPageId) {
        this.id = id;
        this.pageName = pageName;
        this.keyword = keyword;
        this.content = content;
        this.parentPageId = parentPageId;
    }

    // Các hàm Getter và Setter
    public int getId() {
        return id;
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
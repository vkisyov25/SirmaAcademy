package com.academy.sirma.restdbapp.Model;

public class Article {
    private int id;
    private String title;
    private String content;
    private int userId;

    public Article(int id, String title, String content, int userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }
    public Article() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                "}\n";
    }
}

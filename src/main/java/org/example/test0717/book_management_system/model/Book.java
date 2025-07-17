package org.example.test0717.book_management_system.model;

import java.time.LocalDateTime;

public class Book {
    private String id;
    private String title;
    private String author;
    private LocalDateTime createdAt;



    public Book (String id, String title, String author, LocalDateTime createAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.createdAt = LocalDateTime.now();


    }

    public updateBook (String id, String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;


    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public LocalDateTime getCreatedAt() { return createdAt;}

    public void setTitle(String title) { this. title = title; }
    public void setAuthor(String author) { this.author = author; }



    @Override
    public String toString() {
        return "ID: " + id +
                ", Title: " + title +
                ", Author: " + author +
                "Time: " + createdAt;
    }
}

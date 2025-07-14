package org.example.chapter12.model;

/*
    Book 클래스
    : 책 객체를 정의하는 클래스

    @Field
    : 제목(String), 저자(String), 출판사(String)

    @Method
    : 각 필드의 getter & toString 재정의

    @Constuctor
    : 각 필드를 초기화

 */

public class Book {
    private String title;
    private String author;
    private String publisher;

    public Book(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getPublisher() { return publisher; }

    @Override
    public String toString() {
        return "Title:" + title + ", Author:" + author + ", Publisher:" + publisher;
    }
}

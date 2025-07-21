package org.example.chapter13.practice.model;

public class Fiction extends Book{
    private String genre; // 추리, 미스테리, 로멘드, 판타지 등

    public Fiction(String id, String title, String author, String genre) {
        super (id, title, author); // 추상 클래스의 생성자 호출
        this.genre = genre;
    }

    @Override
    public String toString() {
        return super.toString() + ", Genre: " + genre;
    }
}

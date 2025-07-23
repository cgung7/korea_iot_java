package org.example.chapter15.c_board_app.entity;

/*
    === Entity(실재) ===
    : 현실 세계에서 구별 가능한 개별적인 항목이나 객체를 나타냄
    - 객체 지향 프로그래밍에서 클래스의 인스턴스로 표현
        >> 데이터의 집합

    cf) Model
    : 일반적으로 데이터를 표현하고 처리하는 일련의 규칙과 메서드를 정의하는 부분
    - MVC 패턴
        >> View(요청) - Controller(제어) = Model(비즈니스 로직 & 데이터)

 */

/*
    === 게시판(Board) ===
    - id: 게시판 고유 번호
    - title: 게시판 제목
    - content: 게시판 내용
    - author: 게시판 작성자

 */

import lombok.Data;

@Data // Getter, Setter, ToString, RequiredArgsConstructor, EqualsAndHashCode
public class Board {
    private Long id;
    private String title;
    private String content;
    private String author;

    public Board(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

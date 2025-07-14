package org.example.chapter12;

/*
    === 도서 관리 시스템 ===

    1. 요구 사항 분석
        - 새로운 도서 추가: addBook
        - 모든 도서 정보 출력: getAllBooks
        - 도서 검색 (도서 제목으로 검색): searchBookByTitle

    2. 프로그램 구조

    Model(도서 정보 담당)
        - Book 클래스: 도서 정보 저장(제목, 저자, 출판사 등)

    View(사용자 인터페이스 UI를 담당)
        - BookView 클래스: 사용자의 입력을 받아 Controller에게 전달 & Controller에게 받은 정보를 출력

    Controller(사용자의 입력을 처리 - Model과 View 사이를 중재)
        - BookController 클래스: 사용자의 입력에 따라 적절한 Model 메서드를 호출

 */

import org.example.chapter12.controller.BookController;
import org.example.chapter12.model.Book;
import org.example.chapter12.view.BookView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        // 테스트용 더미 도서 리스트를 생성

        // cf) Dummy Data(더미 데이터)
        //      : 실제 데이터처럼 보이지만, 테스트나 개발 목적으로 임시로 만든 가짜 데이터
        List<Book> dummyBooks = new ArrayList<>();
        dummyBooks.add(new Book("자바자바자바","이승아","코리아"));
        dummyBooks.add(new Book("자바를 잡아","이도경","나이스"));

        BookController controller = new BookController(dummyBooks);
        Scanner sc = new Scanner(System.in);

        // 의존성 주입 - DIP?
        BookView bookView = new BookView(controller, sc);
        bookView.showMenu();
    }
}

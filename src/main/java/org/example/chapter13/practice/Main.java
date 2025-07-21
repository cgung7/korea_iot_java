package org.example.chapter13.practice;

/*
    MVC 패턴 + 도서 관리 시스템

    @Model (모델 계층)
            : 도메인 객체 정의, 실제 비즈니스에서 다루는 데이터와 상태를 표현
            Book 클래스(부모)
            Fiction, NonFiction 클래스(자식)

    @View (뷰 계층)
            : 사용자에게 정보를 출력하고 입력받는 역할(프론드엔드)
            - 콘솔 기반(sout & Scanner 사용)
            - 비즈니스 로직을 포함 X, 사용자의 입출력만 처리

    @Controller (컨트롤러 계층)
            : View와 Service 사이를 연결하는 역할
            - 사용자의 입력을 받고, 적절한 비즈니스 로직을 호출하여 처리
            - 결과(응답)을 다시 View에 전달

    @Service
            : 비즈니스 로직을 구현하는 계층
            - 실제 데이터 처리를 담당

    @Repository
            : 데이터를 저장, 조회, 삭제 등의 역할을 담당
            - DB와 연결 (Service 에만 연결 - 외부에서 직접 접근 불가)

    [사용자] <<>> View <<>> Controller <<>> Service <<>> Repository <<>> [3데이터]
 */


import org.example.chapter13.practice.controller.BookController;

public class Main {
    public static void main(String[] args) {
        BookController controller = new BookController();
        controller.start();

    }
}

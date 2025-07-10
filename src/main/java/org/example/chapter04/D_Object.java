package org.example.chapter04;

// 클래스 Book
class Book {
    // 클래스 내부의 데이터(속성, 필드)
    String title;
    String publisher;
    int pageNumber;

    // 클래스 내부 동작(행동 메서드)
    void displayInfo() {
        System.out.println(title + " " + publisher);
        // void: 반환값이 없는 경우 - return 생략 || return;

        // cf) 반환값이 있는 경우: return 반환값;

        // >> return 키워드는 해당 메서드의 종료를 가리킴
        return;
        // System.out.println("실행 안됨"); - 해당 코드에 접근 불가
    }

    // 클래스 생성자
    // : 반드시 하나의 class 내부에는 한 개 이상의 생성자가 존재
    // - new 연산자를 사용하여 호출 될 메서드
    // - 필드값 초기화에 주로 사용
    //      >> 생략 시 속성에 기본값 할당: int (0), boolean(false), char(''), 참조타입(null)

    // +) 사용자 정의 상성자 메서드 생략 시
    //      >> 클래스명과 동일하면서 '매개변수'와 '동작'이 없는 메서드가 생략
    Book () {}

    Book (String title, String publisher, int pageNumber) {
        this.title = title;
        this.publisher = publisher;
        this.pageNumber = pageNumber;
    }
}

public class D_Object {
    public static void main(String[] args) {
        Book myBook1 = new Book();
        System.out.println(myBook1.title);
        System.out.println(myBook1.publisher);
        System.out.println(myBook1.pageNumber);

        Book myBook2 = new Book("백설공주", "코리아출판사", 50);
        Book myBook3 = new Book("신데렐라", "에이원플라자", 100);

        System.out.println(myBook2.title); // 백설공주
        System.out.println(myBook3.title); // 신데렐라

        myBook1.displayInfo(); // null null
        myBook2.displayInfo(); // 백설공주 코리아출판사
        myBook3.displayInfo(); // 신데렐라 에이원플라자

        myBook1.title = "개구리왕자";
        myBook1.publisher = "개굴출판사";
        myBook1.displayInfo(); // 개구리왕자 개굴출판사

        myBook2.title = "콩쥐팥쥐";
        System.out.println(myBook2.title); // 콩쥐팥쥐


    }
}

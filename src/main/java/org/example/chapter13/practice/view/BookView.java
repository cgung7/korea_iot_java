package org.example.chapter13.practice.view;

import org.example.chapter13.practice.model.Book;
import org.example.chapter13.practice.model.Fiction;
import org.example.chapter13.practice.model.NonFiction;

import java.util.List;
import java.util.Scanner;

// 사용자의 요청을 받고, 응답을 제공
public class BookView {
    private final Scanner sc = new Scanner(System.in);

    public void showMenu(){
        System.out.println("=== 도서 관리 시스템 ===");
        System.out.println("1. 도서 추가");
        System.out.println("2. 도서 단건 조회");
        System.out.println("3. 도서 전체 조회");
        System.out.println("4. 도서 수정");
        System.out.println("5. 도서 삭제");
        System.out.println("0. 프로그램 종료");
        System.out.print("선택 >> ");
    }

    // 사용자 입력값에 대한 데이터 유효성 검증 로직
    public int getInputMenuNumber() {
        int choice;

        try {
            choice = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
            sc.nextLine();
            return -1; // 메서드 종료 + 오류 신호 전달
        }

        return choice;
    }

    // 문자열 데이터 입력
    public String getInputString(String data) {
        System.out.println("도서" + data + "(을)를 입력하세요.");
        String value = sc.nextLine().trim(); // 문자열.trim() : 문자열 양쪽의 공백을 제거 "안녕    " >> "안녕"
        if (value.isEmpty()) {
            // 문자열 내용값이 없는 경우: 빈 문자열
            System.out.println(data + " 값은 필수 입니다. (비워둘 수 없습니다.)");
            return null;
        }
        return value;
    }

    // 책 상태 정보 입력
    public Book getBookDetails() {

        String id = getInputString("ID");
        if (id == null) return null;
        String title = getInputString("TITLE");
        if (title == null) return null;
        String author = getInputString("AUTHOR");
        if (author == null) return null;

        System.out.println("1. Fiction / 2. NonFiction");
        int type = getInputMenuNumber();
        if (type == -1) return null;

        if (type == 1) {
            //Fiction
            String genre = getInputString("장르");
            if (genre == null) return null;
            return new Fiction(id, title, author, genre);
        } else if (type == 2) {
            // NomFiction
            String field = getInputString("분야");
            if (field == null) return null;
            return new NonFiction(id, title, author, field);
        } else {
            System.out.println("잘못된 선택입니다. 1 또는 2를 입력하세요.");
            return null;
        }
    }

    public void displayBooks(List<Book> books) {
        if (books.isEmpty()) {
            // 배열 내부에 요소가 없는 경우
            System.out.println("등록된 도서가 없습니다.");
        } else {
            for (Book book: books) {
                System.out.println(book);
            }
        }
    }

    public void displayBook(Book book) {
        if (book == null) {
            System.out.println("해당 도서를 찾을 수 없습니다.");
        } else {
            System.out.println(book);
        }
    }

}

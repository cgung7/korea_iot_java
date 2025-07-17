package org.example.test0717.book_management_system;

import org.example.test0717.book_management_system.model.Book;
import org.example.test0717.book_management_system.service.BookService;

import java.util.List;
import java.util.Scanner;


public class Main {
    private final Scanner scanner;
    private final BookService controller;

    public Main(Scanner scanner, BookService controller) {
        this.scanner = scanner;
        this.controller = controller;
    }

    public void showMenu() {
        while (true) {
            try {
                System.out.println("=== 도서관 ===");
                System.out.println("1. 책 추가");
                System.out.println("2. 책 전채 조회");
                System.out.println("3. 책 검색");
                System.out.println("4. 책 수정");
                System.out.println("5. 책 삭제");
                System.out.println("6. 프로그램 종료");
                System.out.println("메뉴를 선택 >> ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1 -> addBook();
                    case 2 -> getAllBooks();
                    case 3 -> searchBook();
                    case 4 -> updateBook();
                    case 5 -> removeBook();
                    case 6 -> {
                        System.out.println("프로그램을 종료합니다. :)");

                        return;
                    }
                    default -> System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                }


            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해야 합니다.");
            } catch (Exception e) {
                System.out.println("오류가 발생했습니다" + e.getMessage());
            }
        }
    }

    private void addBook() {
        System.out.println("책 번호: ");
        String id = scanner.nextLine();
        System.out.println("책 제목: ");
        String title = scanner.nextLine();
        System.out.println("책 저자: ");
        String author = scanner.nextLine();

        Book book = new Book(id,title, author);
        controller.addBook(book);
    }
    private void getAllBooks() {
        List<BookService> allBooks = controller.getAllBooks();

        for (BookService book : allBooks) {
            System.out.println(book);
        }

    }


    private void searchBook() {
        List<Book> list = controller.getAllBooks();

        if(list.isEmpty()) {
            System.out.println("등록된 책이 없습니다.");
        } else {
            for (Book book:list) {
                System.out.println(book);
            }
        }
    }


    private void updateBook() {
        System.out.println("수정할 책번호 입력: ");
        String id = scanner.nextLine();

        System.out.println("새 제목: ");
        String title = scanner.nextLine();

        System.out.println("새 저자: ");
        String author = scanner.nextLine();

        Book book = new Book(id, title, author);

        boolean result = controller.updateBook(book);

        System.out.println(result ? "수정 완료!" : "해당 학번의 학생을 찾을 수 없습니다." + id);

    }




    private void removeBook() {
        System.out.println("삭제할 책 번호: ");
        String id = scanner.nextLine();

        boolean result = controller.removeBook(id);

        System.out.println(result ? "삭제 완료!" : "해당 책을 찾을 수 없습니다.");
    }


}



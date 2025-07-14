package org.example.chapter12.view;

import org.example.chapter12.controller.BookController;
import org.example.chapter12.model.Book;

import java.util.List;
import java.util.Scanner;

public class BookView {
    private final BookController controller;
    private final Scanner sc;

    public BookView(BookController controller, Scanner sc) {
        this.controller = controller;
        this.sc = sc;
    }

    public void showMenu() {
        int choice = 0;

        while (choice != 4) {
            System.out.println("== Book Management System ==");
            System.out.println("1. Add a Book");
            System.out.println("2. Show add Book");
            System.out.println("3. Search for a book title");
            System.out.println("4. Quit");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addBookView();
                    break;
                case 2:
                    showAllBooksView();
                    break;
                case 3:
                    searchBookView();
                    break;
                case 4:
                    System.out.println("종료하겠습니다.");
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    break;
            }
        }
    }

    private void addBookView() {
        System.out.println("책 제목 입력");
        String title = sc.nextLine();
        System.out.println("책 저자 입력");
        String author = sc.nextLine();
        System.out.println("책 출판사 입력");
        String publisher = sc.nextLine();

        controller.addBook(title, author, publisher);
    }

    private void showAllBooksView() {
        List<Book> allBooks = controller.getAllBooks();

        for (Book book: allBooks) {
            System.out.println(book);
        }

    }

    private void searchBookView() {
        // view(요청)
        System.out.println("책을 검색해주세요.");

        String title = sc.nextLine();


        // controller
        List<Book> foundBooks = controller.searchBook(title);

        // view(응답)
        for (Book book: foundBooks) {
            System.out.println(book);
        }

    }


}

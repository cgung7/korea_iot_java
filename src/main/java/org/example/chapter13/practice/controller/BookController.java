package org.example.chapter13.practice.controller;


import org.example.chapter13.practice.model.Book;
import org.example.chapter13.practice.service.BookServiceImpl;
import org.example.chapter13.practice.view.BookView;

import java.util.List;

// 사용자의 요청을 처리
public class BookController {
    // 싱글통 패턴 인스턴스화 (BookServiceImpl)
    private final BookServiceImpl service = BookServiceImpl.getInstance();
    private final BookView view =  new BookView();

    public void start() {
        while(true) {
            view.showMenu();
            int choice = view.getInputMenuNumber();

            switch (choice) {
                case 1: // 책 추가: 요청 데이터 O, 반환 데이터 X
                    Book book = view.getBookDetails();

                    if (book != null) service.addBook(book);
                    else System.out.println("필수 데이터 값을 다시 확인하여주세요.");
                    break;
                case 2: // 단건 조회: 요청데이터 O, 반환 데이터 O
                    String findBookId = view.getInputString("ID");
                    if(findBookId != null) {
                        Book foundBook = service.findBookById(findBookId);
                        view.displayBook(foundBook);
                    }
                    break;
                case 3: // 전체 조회: 요청 데이터 X, 반환 데이터 O
                    List<Book> books = service.listAllBooks();
                    view.displayBooks(books);
                    break;
                case 4: // 도서 수정
                    String updateId = view.getInputString("ID");
                    if (updateId != null) {
                        Book updateBook = view.getBookDetails();
                        if (updateBook != null) {
                            service.updateBook(updateId, updateBook);
                        } else {
                            System.out.println("수정할 도서 정보가 유효하지 않습니다.");
                        }
                    }
                    break;
                case 5: // 도서 삭제
                    String removeId = view.getInputString("ID");
                    if (removeId != null) {
                        service.deleteBook(removeId);
                    }
                    break;
                case 0:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 메뉴 번호를 다시 입력해주세요.");
            }

        }
    }

}

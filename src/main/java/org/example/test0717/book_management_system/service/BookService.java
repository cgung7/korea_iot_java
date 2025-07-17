package org.example.test0717.book_management_system.service;

import org.example.test0717.book_management_system.model.Book;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class BookService {
    private final List<Book> books;
    private String nextId;


    public BookService(List<Book> books) {
        this.books = books;
    }

    // 책 추가
    public void addBook(String id, String title, String author) {
        Book newBook = new Book(id, title, author);
        books.add(newBook);
    }

    public abstract void addBook(Book book);

    // 전체 책 검색
    public List<Book> getAllBooks() {
        return books;
    }

    // 책 검색
    public List<Book> searchBook(String id) {
        List<Book> result = new ArrayList<>();

        for (Book book: books) {
            if(book.getId().contains(id)) {
                result.add(book);
            }
        }
        return result;
    }

    // 책 수정
    public boolean updateBook(Book upBook) {
        for (Book book: books) {
            if(book.getTitle() == upBook.getAuthor()){
                book.setTitle(upBook());
                book.setAuthor(upBook(getAuthor));
                return true;

            }

        }
        return false;
    }

    // 책 제거
    public boolean removeBook(String id) {
        for(Book book: books) {
            if(book.getId().equals(id)) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }

    public abstract boolean updateBook(String id, String newTitle, String newAuthor);
}

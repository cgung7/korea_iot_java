package org.example.test0717.book_management_system.service;


import org.example.chapter09_practice.exception.UserNotFoundException;
import org.example.test0717.book_management_system.exception.BookNotFoundException;
import org.example.test0717.book_management_system.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookServiceelmpl extends BookService {

    private final List<Book> bookList = new ArrayList<>();

    public BookServiceelmpl(List<Book> books) {
        super(books);
    }

    @Override
    public void addBook(Book book) {
        bookList.add(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookList);
    }


    @Override
    public boolean removeBook(String id) {
        Book bookToRemove = null;

        for (Book book:bookList) {
            if(book.getId() == id) {
                bookToRemove = book;
                break;
            }
            bookList.remove(bookToRemove);
        }

        if (bookToRemove == null) {
            throw new BookNotFoundException("책 ID에 " + id + "값이 없습니다.(삭제 실패)")
        }
        return false;
    }

    @Override
    public List<Book> searchBook(String id) {
        List<Book> result = new ArrayList<>();

        for(Book book:bookList) {
            if (book.getId().equals(id)) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public boolean updateBook(String id, String newTitle, String newAuthor) {
        Book book = getBookById(id);
        book.setTitle(newTitle);
        book.setAuthor(newAuthor);
    }
}

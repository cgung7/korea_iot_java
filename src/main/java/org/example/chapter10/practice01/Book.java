package org.example.chapter10.practice01;


// 제품이 가져야 할 필수 구성을 상속받은 Book 클래스
public class Book extends Item {
    // id, name
    private String isbn;
    private String author;
    private String publisher;
    private int publishYear;
    private int price;
    private int stock;
    private String category;

    public Book(String id, String name, String isbn, String author, String publisher,
                int publishYear, int price, int stock, String category) {
        super(id, name); // ID, name 고정 값. 변경불가
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public String getIsbn() { return  isbn;}
    public String getAuthor() { return  author;}
    public String getPublisher() { return  publisher;}
    public String getCategory() { return category;}
    public int getPrice() { return  price;}
    public int getStock() { return  stock;}
    public int getPublishYear() { return  publishYear;}

    public void updateStock(int quantity) {
        this.stock =quantity;
    }


    @Override
    public void display() {
        System.out.println("ID: " + getId() + ", Name: " + getName() + ", ISBN" + isbn);

    }
}

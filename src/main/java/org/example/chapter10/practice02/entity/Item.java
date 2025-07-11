package org.example.chapter10.practice02.entity;

public abstract class Item {
    private String id;
    private String name;
    private int price;
    private int quantity;

    public Item(String id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getPrice() { return price;}
    public int getQuantity() { return quantity;}

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }
    public abstract String getCategory();

    @Override
    public String toString() {
        return "ID: " + id + ", NAME: " + name + ", Price:" + price + ", Quantity:" + quantity;
    }
}



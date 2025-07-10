package org.example.chapter07.orderApp;

/*
 * Food 클래스
 * - Product(제품)를 상속받는 하위 클래스
 * - 식품은 세금 면제 (오버라이딩)
 * */
public class Food extends Product {

    Food(String name, int price) {
        super(name, price);
    }

    @Override
    double calculateTax() {
        return 0;
    }
}
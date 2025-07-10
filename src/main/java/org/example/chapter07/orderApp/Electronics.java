package org.example.chapter07.orderApp;

/*
 * Electronics 클래스
 *
 * - Product(제품)를 상속받는 하위 클래스
 * - (추가) 전자 제품은 특별 세율 적용: 15% (오버라이딩)
 * */
public class Electronics extends Product {

    Electronics(String name, int price) {
        super(name, price);
    }

    @Override
    double calculateTax() {
        return getPrice() * 0.15;
    }
}
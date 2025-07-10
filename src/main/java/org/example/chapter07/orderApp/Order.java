package org.example.chapter07.orderApp;

/*
 * Order 클래스
 * : 실제 주문 로직이 구현
 * - 특정 제품(Product)과 수량을 기반으로 주문을 생성
 *
 * >> 총 가격(세금 포함)을 계산하는 역할
 * */
public class Order {
    private Product product;
    private int quantity;

    Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // 총 가격 계산 메서드
    double calculateTotalPrice() {
        double tax = product.calculateTax(); // 각 제품별 재정의 메서드가 실행
        double totalPrice = (product.getPrice() + tax) * quantity;
        return totalPrice;
    }

    // 주문 정보 반환 메서드
    // : 모든 객체(Object) 타입에 존재하는 메서드
    // - sout에 객체(참조) 타입 출력 시 해당 메서드가 실행
    // - 클래스 타입의 경우 참조 주소값이 반환
    @Override
    public String toString() {
        return "Order Detail[ " + product.getName() + " * " + "Quantity: " + quantity
                + " >> " + calculateTotalPrice() + " ]";

        // Order Detail[ cake * 2 >> 18000 ]

        // cf) toString();
        // '클래스명@해당객체의주소값'이 문자열로 출력
        // - 객체를 문자열로 표현할 때 사용 (재정의하여 사용자 편의 문자 출력 가능)
        // - 모든 클래스의 최상위 클래스인 Object 클래스에 정의
    }
}
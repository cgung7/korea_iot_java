//package org.example.chapter00;
//
//// 음료수 클래스
//
//// 1) 브랜드 클래스
//// : 속성) brand(String. 불변성), name(String 불변성),
////      soldOut(boolean),inStock(boolean)
//// : 매서드) soldOut(), displayInfo(), inStockInfo()
//// : 생성자) 매개변수 - brand, name
//
//class Brand {
//    private final String brand;
//    private final String name;
//    private boolean soldOut;
//
//
//    Brand(String brand, String name) {
//        this.brand = brand;
//        this.name = name;
//        soldOut = false;
//
//    }
//    // 브랜드 판매 메서드
//    void buyBrand() {
//        if (!soldOut) {
//            soldOut = true;
//            System.out.println("구매가 가능합니다.");
//        } else {
//            System.out.println("판매가 완료되었습니다.(입고 대기중)");
//        }
//    }
//
//    //브랜드 확인 메서드
//    void buySoldBrand() {
//        if (!soldOut) {
//            //soldOut이 true인 상태 - 구매 가능상태
//            soldOut = false;
//            System.out.println("이미 판매가 완료된 상품입니다.(입고 대기중)");
//        } else {
//            System.out.println("구매 가능합니다.");
//        }
//    }
//
//    // 브랜드 정보 출력 메서드
//    void brandInfo() {
//        System.out.println("브랜드명: " + brand + ", 제품명: " + name +
//                ", 구매가능여부: " + (soldOut ? "재고 X" : "재고 O"));
//    }
//
//    //캡슐화를 위한 getter 메서드 추가
//    public  String getBrand() { return brand; }
//    public  String getName() { return name; }
//    public boolean SoldOut() { return soldOut; }
//
//
//}
//
//class NBrand extends Brand {
//    private double brandSize;
//
//    NBrand(String brand, String name, double brandSize) {
//        super(brand, name);
//        this.brandSize = brandSize;
//    }
//
//    @Override
//    void brandInfo() {
//        System.out.println("브랜드 명: " + brand );
//    }
//}
//
//public class Note {
//    public static void main(String[] args) {
//
//    }
//}

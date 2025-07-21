package org.example.chapter00;
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
public class Note {
    public static void change(String[] data, String s) {
        /// cf) 메서드의 인자값과 매개변수
        ///      : 인자값은 값의 복사 방식으로 매개변수에 전달
        ///      - 인자값과 매개변수의 주소값이 다름

        /// +) 배열의 참조는 메서드끼리 공유
        /// +) 문자열의 참조는 실질적인 값의 복사형식으로 전달
        data[0] = s; // data [ s ]
        /// data 배열의 첫 번째 인덱스 번호에 B값이 할당
        s = "Z";
        /// 지역변수 - 해당 메서드를 벗어나면 값이 유지되지 않음
    }
    public static void main(String[] args) {
        String data[] = {"A"}; // data[s] => data[A]
        /// 배열 선언과 동시에 초기화 -> data[0] = "A"
        String s = "B"; // Z => B

        /// data 배열과 s 문자열이 인자로 전달
        change(data, s); // [A] => [B]
        /// data[0] == B, s == B
        System.out.println(data[0] + s); // [B] + [B] ==> BB

        /// 배열 전달 - 참조가 전달되어 내부 변경에 반영
        /// 문자열 전달 - 값이 복사되어 외부 변수에 영향이 없음
    }
}

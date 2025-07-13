package org.example.chapter00.practice01.entity;


// Item에게 상속(extends)받은 자식클래스 Electronics
public class Electronics extends Item {

    // Item에 없는 가전제품(Electronics)에만 필요한 속성이기에 별도로 정의(캡슐화 진행 시작 private)
    private String brand; // 브랜드
    private int warranty; // 보증기간 (개월)

    // Electronics(객체 생성 시 전달받는 값 (초기값))
    public Electronics(String id, String name, int price, int quantity, String brand, int warranty) {
        super(id, name, price, quantity); // 부모 생성자 호출(super)
        // 부모 클래스에 없기 때문에 직접 초기화 진행, 초기화 함으로 의미가 있는 상태로 동작을 위해 필수 과정
        this.brand = brand;
        this.warranty = warranty;
        // 객체의 것으로 명확하기 구분을 위해 this 사용
    }

    // 외부에서 값을 읽을 수 있도록 제공한 메서드(getter, 캡슐화 진행)
    public String getBrand() { return brand; }
    public int getWarranty() { return warranty; }

    // 추상메서드로 자식 클래스인 가구(Furniture)에 오버라이딩을 함으로
    //          자식클래스에서 구현과 자유롭게 위임을 함
    @Override
    public String getCategory() {
        // 가전제품(Electronics)의 객체는 "Electronics"라는 카테코리를 정했음
        return "Electronics";
    }

    // 부모 클래스 toString 결과에 가구(Furniture) 정보를 추가 및 수정 (오버라이딩)
    // 부모 클래스에 있는 정보가 아닌 자녀 클래스의 정보를 출력
    @Override
    public String toString() {
        return super.toString() + " // Brand: " + brand + ", Warranty: " + warranty;
    }
}
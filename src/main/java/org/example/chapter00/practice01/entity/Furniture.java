package org.example.chapter00.practice01.entity;


// Item에게 상속(extends)받은 자식클래스 Furniture
public class Furniture extends Item {

    // Item에 없는 가구(Furniture)에만 필요한 속성이기 때문에 별도로 정의(캡슐화 시작 private)
    private String material; // 재질
    private String size; // 크기

    // 생성자 생성
    // Furniture(객체 생성 시 전달받는 값 (초기값))
    public Furniture(String id, String name, int price, int quantity, String material, String size) {
        super(id, name, price, quantity); // 부모 클래스의 생성자 호출(super)
        // 가구(Furniture)의 고유 속성이므로 직접 초기화 진행
        this.material = material;
        this.size = size;

    }
    // 외부에서 값을 읽을 수 있도록 제공한 메서드(getter, 캡슐화 진행)
    public String getMaterial() { return material; }
    public String getSize() { return size; }


    // 추상메서드로 자식 클래스인 가구(Furniture)에 오버라이딩을 함으로
    //          자식클래스에서 구현과 자유롭게 위임을 함
    @Override
    public String getCategory() {
        // 가구(Furniture)의 객체는 "Furniture"라는 카테코리를 정했음
        return "Furniture";

    }

    // 부모 클래스 toString 결과에 가구(Furniture) 정보를 추가 및 수정 (오버라이딩)
    // 부모 클래스에 있는 정보가 아닌 자녀 클래스의 정보를 출력
    @Override
    public String toString() {
        return super.toString() + " // Material: " + material + ", Size: " + size;
    }
}
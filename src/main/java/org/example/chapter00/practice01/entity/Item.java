package org.example.chapter00.practice01.entity;

public abstract class Item {
    // 모든 패키지에 사용가능 해야 함으로 public 클래스 선언
    // abstract 추상클래스: 상속한 자식 클래스들이 구현을 완성 시켜야 함
    //          : 구조 분리, 재사용성, 유지모스 용이, 다형성 활용 가능성이 높아 사용을 권장
    //          : 구조 변경을 할 시 부모 클래스만 수정하면 자식클래스에 일관 적용이 된다.

    // 필드(멤버 변수)
    // private로 외부에서는 직접 접근 불가, getter/setter를 통해 접근 가능 보안성 상향(캡슐화)

//    비교:           인터페이스                    vs.                getter/setter
//    항목	          인터페이스	                                     getter/setter
//    목적	객체의 기능 명세 제공 (무엇을 할 수 있는지)	            객체의 데이터 접근/수정 제어
//    구성	메서드 시그니처만 정의, 구현은 안 함	                    메서드 자체의 구현 포함
//    사용 대상	클래스들이 공통된 동작을 하도록 강제	            특정 필드에 안전하게 접근하도록 제한
//    중심 개념	"어떻게 동작할지를 약속"	                    "무엇을 보여줄지, 어떻게 통제할지 결정"
//    활용 범위	다형성과 의존성 분리에 탁월	                       단일 클래스 내부 정보 보호에 탁월

    private String id;
    private String name;
    private int price;
    private int quantity;

    // 생성자: 객체 생성
    //      : 필요한 값을 받아 각 필드를 초기화 || Item(객체 생성 시 전달받는 값 (초기값))
    public Item(String id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // getter 메서드
    // : 각 필드의 값을 외부에서 읽을 수 있게 해주는 메서드
    public String getId() { return id; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getQuantity() { return quantity; }


    // setter 메서드
    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }
    // 추상 메서드 (abstract)
    // 자식 클래스에서 반드시 구현 해야함.
    public abstract String getCategory();

    // 오버라이딩
    // : 부모 클래스가아닌 자식 클래스를 사용하고 싶어 사용함.
    // : 디버깅 편의성: sout(item); 으로 쉽게 출력 가능
    // Item은 Object 클래스의 자식 클래스이기 때문에 오버라이딩 한 것임.
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: " + price + ", Quantity: " + quantity;
    }
}
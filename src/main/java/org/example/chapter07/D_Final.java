package org.example.chapter07;

// === final 키워드 === //
// : 변수. 메서드, 클래스에서 사용 가능
// 1) 변수(상수): 값을 변경 할 수 없는 상수 선언
// 2) 메서드: 자식 클래스에서 재정의(오버라이딩)할 수 없는 메서드 선언
//          >> 해당 메서드는 재정의 될 수 X
// 3) 클래스: 상속될 수 없는 클래스 선언

class MyFinalClass {
    // 1.final 변수
    // : 상수 지정, 선언과 동시에 '초기화', 재할당 불가능
    // - UPPER_SNAKE_CASE 사용 (전체 키워드를 대문자)
    final int FINAL_VARIABLE = 30;

    // 2. final 메서드
    // : 자식 클래스에서 오버라이딩(재정의)할 수 없는 메서드
    // [접근제어자] final 반환타입 메서드명() {}
    public final void myMethod() {
        System.out.println("재정의할 수 없는 메서드!");
    }
}

class ChildClass extends MyFinalClass {
    // 상속받은 final 클래스는 재정의 X
    // : 생략된 형태로만 사용 가능


//    @Override
//    public  void myMethod() {
//
//
//    }

    // 생성자
    ChildClass() {
        super.myMethod();
    }

}

// 3. final 클래스
// : final class 클래스명() {}
// : 더이상 상속될 수 없는 클래스 의미 (부모 클래스로 사용 X)

final class Example1 {}
// class Example2 extends Example1 {}

class StudentClass {
    private String name; // 보호 o + 변경 o

    private final int residentNumber = 100; // 보호 o + 변경 x
    // : 모드 인스턴스가 고유한 값을 가지는 인스턴스 필드 + private(클래스 내부에서만 접근가능)
    //      + 한 번 값이 할당되면(초기화) 변하지 않는 필드

    // final 초기화를 못했기 때문에 오류, final은 객체 마다 유지되는 값(변동x)

    // cf) final 필드의 데이터 주입
    //      : final 키워드는 선언과 동시에 초기화가 필요
    //      - 필드 주입 방식
    //      - 생성자 주입 방식
    private final String gender; // 보호 o + 변결 X

    StudentClass(String gender) {
        this.gender = gender;
    }

    // cf) 데이터의 불변성 유지 방법
    // - final 필드 사용 + setter 사용 X + 생성자로만 값을 결정하는 방식(생성자 주입 방식)

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

public class D_Final {
    public static void main(String[] args) {
        ChildClass childClass = new ChildClass();
        childClass.myMethod();
        System.out.println(childClass.FINAL_VARIABLE);

        // childClass.FINAL_VARIABLE = 20;

        // final 장단점
        // 장점) 불변성 (안전성 보장)
        // 단점) 유연성 감소 (상속X, 오버라이팅 X, 재할당 X: 그 자체로만 사용 가능)
    }
}

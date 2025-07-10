package org.example.chapter06;

// === 생성자(Constructor) === //
// : 객체(인스턴스)가 생성될 때 호출되는 '인스턴스 초기화 메서드'

// - 생성자의 조건
//      : 클래스명과 동일한 이름을 사용
//      : 리턴값이 없는 메서드 형식 (void 타입이 생략)

// '컴파일러가 제공하는 기본 생성자'
// : 클래스에 생성자가 없으면 ㅏ돌 생성되는 빈 생성자
//      >> 매개변수 X, 아무런 작업도 하지 않음 (구현부 내의 코드가 없음)

import org.w3c.dom.ls.LSOutput;

class Example1 {
    int value;

    // 기본 생성자 생략
    // Example1() {}
}

class Example2 {
    int value;

    // 사용자 정의 생성자
    // : 컴파일러가 자동으로 기본 생성자를 제거
    Example2(int value) {
        this.value = value;
    }

    // 빈 생성자를 직접 명시해야만 사용 가능
    Example2() {
    }
}

class Car {
    String color;
    String gearType; // auto(자동), manual(수동)
    int door;

    Car() {
    } // 기본 생성자 - 차를 생성한 뒤에 필드값 초기화

    // 사용자 정의 생성자
    Car(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }

    Car(String color) {
        //cf) this 키워드
        // 1) 객체 자신
        //      >> this.필드명;
        //      >> 자신의 필드에 접근 가능
        // 2) 객체 내의 생성자 호출
        //      >> this(); - this 내부의 인자 형태를 컴파일러가 자동 분석하여 해당하는 생성자로 연결
        //      >> 생성자 이름으로 클래스명 대신 this를 사용

        // door = 5;
        this(color, "auto", 4);
        // cf) 사용자 정의 생성자 내에서 타 생성자 호출 시
        //         , 반드시 첫 줄에서만 사용 가능
        // >> 호출된 생성자 가변수값을 초기화하기 때문에
        //      , 현재의 생성자가 수행하는 작업을 유지하려면 this() 생성자 뒤에 작성
        //      - 무의미함 방지
        door = 6;

//        this (color, "manual", 4);
        // >> 생성자 내부에서는 타 생성자를 한 번만 호출 가능
    }

}

// this 키워드
// 1) this
//      : 인스턴스 자신을 참조
//      - 모든 인스턴스 메서드와 새ㅐㅇ성자 내부에서 사용 가능

// 2) this()
//      : 같은 클래스 내의 다른 생성자 호출
//      - 중복 코드 제거와 유지보스성 향상에 기여

public class A_Constructor {
    public static void main(String[] args) {
        Example1 example1 = new Example1(); // 빈 생성자 호출 - 전달할 인자 X
        Example2 example2 = new Example2(50);

        // == Car 인스턴스 생성 == //
        Car car1 = new Car(); // 기본 생성자 호출
        car1.color = "black";
        car1.gearType = "auto";
        car1.door = 4;

        Car car2 = new Car("white", "manual", 2); // 사용자 정의 생성자 호출

        Car car3 = new Car("red");
        System.out.println(car3.color + car3.door + car3.gearType); // red6auto

        // cf) 인스턴스 생성
        //      : 생성자가 인스턴스 생성X
        //      >> new 연산자가 인스턴스 생성 O
    }
}

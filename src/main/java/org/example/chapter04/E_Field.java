package org.example.chapter04;

// == 객체 지향 프로그램의 '변수' == //

// == 필드 VS 지역 변수 == //
// 1. 필드
// : 객체의 지속적인 상태를 저장하는 '클래스 내부'의 변수
// - 메서드와 분리되어 클래스의 최상단에 위치
// - 명시적으로 초기화하지 않으면 기본값으로 초기화
// EX) 인스턴스 필드, 클래스 필드

// class A {
    // 해당 위치에 변수 >> 필드
// }

// 1) 인스턴스 필드(변수)
// : 클래스의 각 개체(인스턴스)에 속한 변수
// >> 클래스 내부에서 선언, '객체가 생상될 때' 메모리에 할당
// >> 각 인스턴스 마다 다른 값을 가질 수 있음.

// 2) 클래스(static, 정적) 필드(변수)
// : 클래스의 '모든 인스턴스에서 공유되는' 데이터 변수
// : 'static' 키워드를 사용하여 선언되는 변수
// >> 해당 클래스로 생성되는 인스턴스가 '모두 동일한 값'을 가짐
// >> 프로그램이 시작될 때 생성 ~ 프로그램이 종료 될 때 소멸
// cf) JVM의 'Method Area' 영역에 저장

// 2. 지역 변수
// : 특정 기능(메서드)가 실행되는 동안에만 존재하는 '일시적인 변수'
// - 메서드(생성자 포함) 또는 블록 내부({})에서 선언
// - 자동으로 초기화 X, 반드시 초기화 후 사용
//      >> 초기화 없이 사용할 경우 예외

// cf) 변수명 - 동일한 스코프(scope, 영역) 내에서 같은 변수명 사용 X

// cf) 클래스명 - "접근제한자"에 따라 같은 이름의 클래스 사용 X
// class CarClass {
//
// }

// >> 접근제한자의 생략 - 기본값 default 설정 (같은 패키지 안에서 사용 가능)
// class Car {
//
//}

class CarClass {
    int a;
    // int a; ==>같은열에 동일한 내용 불가

    // cf) 메서드명 - 동일한 스코프 내에서 같은 변수명 사용 O(가능)

    // 1. 필드(속성)
    // 1) 인스턴스 필드: 각 객체마다 다른 값은 가짐
    String brand;
    String color;
    String speed;

    // 2) 클래스(정적, static) 필드: 클래스의 모든 각체가 동일한 값을 가짐
    static int tireNumber;
    static int doorNumber;

    // 2. 지역 변수
    void accelerate(int increment) {
        // speed 필드: 지역 변수 내에서 사용

        // increment 지역변수
        // : 메서드 내부에서만 유효
        speed += increment; // speed = speed + increment
    }
}

public class E_Field {
    public static void main(String[] args) {
        // 1) 필드 사용 방법
        // 각체명.필드명

        // 2) 클래스 필드 사용 방법
        // 클래스명.필드명; || 객체명.필드명;
        // >> 각 객체명으로도 호출 가능하지만, 클래스명 호출 방법을 권장
        System.out.println(CarClass.doorNumber);
        System.out.println(CarClass.tireNumber);

        // 클래스 필드값 변경
        CarClass car1 = new CarClass();
        CarClass car2 = new CarClass();

        // cf) 예외, 오류 발생 X - 권장하지 않음
//        car1.doorNumber = 4;
//        System.out.println(car2.doorNumber);  // 4
//        System.out.println(CarClass.doorNumber); // 4

        // 인스턴스 필드 사용
        car1.brand = "kia";
        car1.color = "black";

        car1.accelerate(100);
        car1.accelerate(100);
        System.out.println(car1.speed);

        // System.out.prontln(CarClass.brand);

    }
}

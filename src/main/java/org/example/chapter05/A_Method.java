package org.example.chapter05;

// 자바 OOP
// '클래스' == 객체 생성 템플릿(설계도)
// - 필드, 메서드, 생성자

// cf) 필드: 클래스의 특성이 담긴 속성

// == 메서드 == //

/*
    반환타입 메서드명(매개 변수1, 매개 변수2, ...) {
        - 메서드의 기능, 동작 정의
    }

    1. 반환 타입(유형)
    : 메서드 동작 후 반환되는 데이터 유형을 지정
    - 반환 데이터가 없는 경우 void 지정

    2. 메서드명
    : lowerCamelCase 사용, 동사 사용 권장
    cf) 변수명: 명사 사용 권장 (배열명: 복수 명사 사용 권장)

    EX) eat(먹다) - 메서드, eating(먹기) - 변수(행동)

    3. 매개변수(parameter) 목록
    : 메서드에 전달되는 입력값들의 목록
    - 0개 이상 지정 (지정하지 않을 수도 있음)
    - 각 매개변수는 변수의 선언과 같이 자료형과 함께 선언
    cf) 일반 변수 선언에서 쓰이는 동일한 데이터 타입의 생략 불가

 */
class Calculator {
    int a, b;

    int add (int a, int b) {
        // return
        // : 메서드의 반환을 담당
        // - 반환타입과 일치하는 데이터를 동반
        // - void 타입이면 생략 가능 (아예 쓰지 않거나 return;)
        return a + b;
    }

    void voidMethod() {
        return;
    }
}

public class A_Method {
    public static void main(String[] args) {
        int a, b; // 매개변수 선언 시에는 사용 불가

        // 메서드 사용
        // 객체명.메서드();
        Calculator calc = new Calculator(); // 객체 생성

        System.out.println(calc.add(3, 5)); // 8

        //메서드의 반환 값이 있는 경우
        // : 변수에 할당받아 사용
        int result = calc.add(123, 456);
        System.out.println(result); // 579
    }
}

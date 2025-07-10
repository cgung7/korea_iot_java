package org.example.chapter05;

/*
    === 함수(Function) VS 메서드(Method) ===
     : 자바에서는 '함수'의 개념 X
     - 모든 함수 체계는 '클래스 내부의 메서드'로 사용

     1. 함수
     : 특정 작업을 수행하는 코드 블록
     - 독립적, 클래스 소속 X
     - 직접 호출: 함수명();
     >> Python, JavaScript 등

     2. 메서드
     : 객체의 동작을 정의한 코드 블록
     - 클래스 내부에 포함, 객체의 행위와 연결
     객체 생성 후, .연산자를 통해 호출: 객체명.메서드명();
     >>Java, C# 등

 */

// === 메서드(Method) === //
// : 특정 작업을 하나로 묶은 것
// - 어떤 값들을 입력하면, 해당 값들로 작업을 수행하여 결과를 반환

// 1) 메서드의 구조: 선언부, 구현부
//      반환타입 메서드명() {}
//      - 선언부: 반환타입 메서드명 (매개변수 나열)
//      - 구현부: { 메서드 호출 시 수행될 코드 }

// cf) 변수 '선언'
//      메서드 '정의' - 선언부와 구현부를 작성한다

// +) 매개변수(parameter)  선언
// : 메서드가 작업을 수행하는데 필요한 값을 제공받음
// >> 필요한 개수만큼 선언 데이터 타입 생략 불가 사용 시 데이터 생략 불가

// +) 구현부
// : 반환 타입이 void가 아닐 결우 반드시 'return 반환타입데이터;'
// >> 반환값은 명시된 타입과 일치하거나 자동 형 변환 가능

class Example {
    int x, y; // (인스턴트) 필드

    // 반환 타입 0, 매개변수 0
    int add(int x, int y) {
        // 파라미터 매개변수 - 지역변수
        int result = x + y;
        return  result;
    }

    // 반환타입0, 매개변수X
    double multiply() {
        int result = x * y;
        return result;
    }

    // 반환값 X, 매개변수X
    void print99dan() {
        for(int i = 1; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(j * i + " ");
            }
            System.out.println();
        }
    }
}

public class B_Method {
    public static void main(String[] args) {
        Example example = new Example();
        example.print99dan();

        // == 매개변수(parameter) VS 인자(argument) == //
        // 1. 매개변수
        // - 메서드 정의 시 소괄호 안에 선언되는 (지역)변수
        // - 호출 시 값을 전달받아 구현부 내에서 사용

        // 2. 인자(인수)
        // - 메서드를 호출할 때 소괄호 안에 전달되는 '값'
        // - 실제 데이터를 전달 역할
        // >> 메서드 호출부에서 전달하여 매개변수에 저장

        // example.add(1);
        // example.add(1,2,3);
        // >> 인자값과 매개변수의 수는 같아야 한다
        // >> 타입의 순서는 같거나 자동 형 변환이 가능해야 함
        // example.add("1", "2");
        example.add('1', '2'); // char(2) < int(4)

        example.add(10, 20);

    }
}

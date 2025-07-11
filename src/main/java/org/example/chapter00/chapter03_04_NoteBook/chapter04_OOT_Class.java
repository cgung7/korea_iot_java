package org.example.chapter00.chapter03_04_NoteBook;

// === OOP (클래스 & 객체) === //

//  클래스(Class)
// : 객체를 만들기 위한 설계도(템플릿)
// - 객체의 상태(속성)과 행동(메서드)을 정의

// 1) 클래스의 특징
// - 실제 데이터를 저장하지 않음
// - 메모리에도 저장 X
// - 단지 객체 생성을 위한 '개념적인 틀'

// 2) 클래스의 구조
// (1) 필드(Field): 데이터를 표현하는 속성
// (2) 메서드(Method): 데이터의 동작
// (3) 생성자(Constructor): 데이터를 생성하는 역할

// 3) 클래스 생성자
// : 반드시 하나의 class 내부에는 한 개 이상의 생성자가 존재
// - new 연산자를 사용하여 호출 될 메서드
// - 필드값 초기화에 주로 사용
//      >> 생략 시 속성에 기본값 할당: int (0), boolean(false), char(''), 참조타입(null)

// +) 사용자 정의 상성자 메서드 생략 시
//      >> 클래스명과 동일하면서 '매개변수'와 '동작'이 없는 메서드가 생략

// class 키워드 를 사용
// class 클래스명 { 해당 클래스의 기능과 행동을 정의 } ==> ; X
class ClassName {
    // cf) 클래스명: UpperCamelCase 사용
    //      >> Car, StudentInfo, BoolLibrary 등
}

// 2. 객체(Object) 정의
// : 클래스에 정의된 속성과 메서드를 가지는 실체(instance)
// : 클래스를 기반으로 생성
// - 클래스의 '인스턴스'라고 불림, 실제 메로리에 할당됨
// >> 각 객체는 독립적인 상태와 행동을 가짐
// >> 서로 다른 객체와의 상호작용 가능

// cf) 객체 == 인스턴스
// '인스턴스화'
//  : 클래스라는 텟플릿을 기반으로 객체를 만드는 '과정'
// > 이때, 만들어진 객체를 '인스턴스(Instance)'라고 부름



public class chapter04_OOT_Class {
    public static void main(String[] args) {
        // == 클래스 정의 방법 == //
        /*
            [접근제한자] class 클래스명 {
            ([" "]생략 가능)
                // 클래스가 가지는 속성과 행동 정의
                - 속성(기능): 변수
                - 행동(메서드, method): 함수
            }
         */

        // cf) 접근제한자(접근제어자)
        // : 생략 가능
        // - 클래스의 가시성을 정의(접근에 대한 권한을 부여)
        // - 클래스, 변수, 메서드의 접근 가능 범위를 결정     =) 캡슐화
        // - 종류) public, private, protected, (default)
        class Car {
            // 속성(필드) - 변수 선언 방식
            int maxSpeed;
            String color;
            boolean isElectric;
        }

        class Book {
            String title;
            String author;
            int pageNumber;
        }
        class Person {
            String name;
            int age;
            boolean osStudent;
            String[] hobbys;
        }

        // cf) this 키워드
        // : 클래스 그자체의 객체를 가리킴, 객체 자신을 참조하는 데 사용
        // - 클래스의 필드와 생성자에서 변수명이 같을 경우 구분을 위해 사용

    }
}

// 클래스는 메모리에 올라가나요? No
// 객체는 무엇의 실체? 클래스의 인스턴스


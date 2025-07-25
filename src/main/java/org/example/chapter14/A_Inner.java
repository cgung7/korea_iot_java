package org.example.chapter14;

// === chapter 14 === //
// 내부 클래스(Inner Class) >> 익명 클래스(Anonymous Class) >> 람다식(Lambda)
// +) String API

/*
    === 내부(중첩) 클래스(Inner Class, Nested Class) ===
    : 다른 클래스 내부에 선언된 또 클래스를 의미
    - 즉, 클래스 안의 클래스
    - 외부 클래스의 멤버(변수, 메서드)에 쉽게 접근할 수 있다는 장점이 존재

    === 내부 클래스 사용 목적 ===
    1. 코드 가독성 향상 - 코드의 구조 파악 용이 (코드의 논리적 그룹화)
    2. 캡슐화 강화 - 외부에 공개할 필요가 없는 클래스는 내부로 감춤
    3. 외부 클래스 멤버 접근 - 내부 클래스는 외부 클래스의 필드와 메서드에 직접 접근 가능


    === 내부 클래스 종류 ===
    1. (비정적, instance) 내부 클래스(Non-static Inner Class)
    : "외부 클래스의 인스턴스"에 속함
    >> 외부 클래스 인스턴스를 먼저 생성해야 함 (외부 클래스의 인스턴스 가 있어야만 생성가능)
    >> 외부 클래스의 인스턴스 멤버(필드, 메서드)에 접근 가능

    2. 정적(static) 내부 클래스(Static Nested Class)
    : "외부클래스의 정적 멤버"에 속함
    >> 외부 클래스 인스턴스 없이 생성 가능
    >> 외부 클래스의 정적 멤버(static 멤버)에만 접근 가능 (인스턴스 X)

    3. 메서드 내부 클래스 (지역 클래스)(Local Inner Class)
    : 메서드 내에서 정의된 내부 클래스"
    >> 해당 메서드 내에서만 사용 가능, 메서드가 실행될 때만 유효
    >> 메서드의 지역 변수에만 접근 가능
    cf) 로컬 변수(외부 클래스의 멤버 변수)가 final인 경우에만 접근가능

    4. 익명(내부) 클래스
    : 이름이 없는 내부 클래스
    - 주로 인스터페이스나 추상 클래스의 구현에 사용
    >> 즉시 개체 생성 + 일회성 사용



 */

import com.sun.security.jgss.GSSUtil;

class  OuterClass {
    private String outerField = "외부 클래스 (인스턴스) 필드";
    static String staticField = "외부 클래스의 정적 필드";

    // 1. (비정적) 내부 클래스 - 인스턴스 멤버(필드, 메서드)처럼 사용
    class InnerClass{
        void display() {
            // 외부 클래스의 인스턴스 멤버에 접근 가능
            System.out.println("외부 클래스 필드에 접근: " + outerField);

            // 외부 클래스의 정적 멤버 사용 시: 클래스명. 생략 가능
            System.out.println("외부 클래스 정적 필드에 접근: " + staticField);
        }

    }

    // 2. 정적 내부 클래스 - 인스턴스화 없이 사용 가능
    static class StaticClass {
        void display() {
            // 외부 클래스의 인스턴스 멤버 접근 X
            // System.out.println("외부 클래스 필드에 접근: " + outerField);
            // 외부 클래스의 정적 멤버 접근
            System.out.println("외부 클래스 정적 필드에 접근: " + staticField);
        }
    }

    // 3. 메서드 내부 클래스 (지역 클래스)
    void outerMethod() {
        // cf) 지역변수는 암묵적으로 final로 간주 (생략 가능)
        //      : 재할당이 이루어지면 final이 사라짐 (final로 취금  X)
        String localVar = "메서드 로컬 변수";
        // localVar = "메서드 로컬 변수 값 변경";

        final String localFinalVar = "메서드 로컬 변수 (final)";

        class MethodClass {
            void display() {
                System.out.println("로컬 변수에 접근 (Final X): " + localVar);
                System.out.println("로컷 변수에 접근 (Final O): " + localFinalVar);
            }
        }

        System.out.println("외부 클래스의 메스드호출");

        // 로컬 클래스의 인스턴스와
        // : 메서드 내보에서만 쓰이기 때문에 니스턴스화도 내부에서 일아남
        MethodClass methodClas = new MethodClass();
        methodClas.display();
    }

}

    // 추상 클래스 (하나 이상의 추상 메서드 포함)
    abstract class AbstractClass {
    // cf) 추상 클래스는 구현 클래스 가질 수 있음
    //      >> 추상 메서드에 abstract 생략 불가
    abstract void display();
}

    // 인터페이스
    interface InterfaceClass {
    // cf) 인터페이스는 일반 구현 메서드를 가질 수 없음
    //      >> 추상 메서드에 abstract 생략 가능

    // 필드: public static final
    // 메서드: public abstract 생략

    // +) static 메서드, default 메서드는 구현 가능 (예외)
    void something();
}


public class A_Inner {
    public static void main(String[] args) {
        System.out.println("=== 비정적 내부 클래스 ===");
        // 1) 외부 클래스 인스턴스화
        OuterClass outerClass1 = new OuterClass();

        // 2) 외부 클래스의 인스턴스처럼 사용: 외부클래스객체명.클래스호출
        //      >> 외부클래스타입.내부클래스타입 변수명 = 외부클래스인스턴스.new 내부클래스()
        OuterClass.InnerClass innerClass = outerClass1.new InnerClass();

        innerClass.display();

        System.out.println("=== 정적 내부 클래스 ===");
        // 1) 외부 클래스 인스턴스와 필요 X
        //      >> 외부클래스타입, 내부클래스타입 변수명 = new 외부클래스명.내부클래스();
        OuterClass.StaticClass staticClass = new OuterClass.StaticClass();

        staticClass.display();

        System.out.println("=== 메서드 내부 클래스 (지역 클래스)) ===");
        OuterClass outerClass2 = new OuterClass();
        outerClass2.outerMethod();

        System.out.println("=== 익명 (내부) 클래스 ===");
        // 클래스타입 변수명 = new 클래스명() {
        //      메서드 구현(추상 클래스 / 인터페이스의 추상 클래스)
        //}

        // new 클래스생성자호출();
        AbstractClass abstractClass1 = new AbstractClass() {
            @Override
            void display() {
                System.out.println("익명 내부 클래스 - 추상 클래스1");
            }
        }; // 세미콜론 필수

        abstractClass1.display();

        AbstractClass abstractClass2 = new AbstractClass() {
            @Override
            void display() {
                System.out.println("익명 내부 클래스 - 추상 클래스2");
            }
        };

        abstractClass2.display();

        System.out.println(abstractClass1 == abstractClass2); // false

        // >> 클래스 정의가 외부에서 재사용 될 필요가 없거나, 단 한 번의 사용 목적에 유용

        InterfaceClass interfaceClass = new InterfaceClass() {
            @Override
            public void something() {
                System.out.println("안녕하세요! 인터페이스로 구현한 익명 클래스입니다.");
            }
        };

        interfaceClass.something();



    }
}

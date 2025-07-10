package org.example.chapter08;

// === 추상화(Abstract) - 미완성 === //

// 1. 추상 클래스 정의
// : 미완성 클래스(설계도), 일부구현이 누락된 불완전한 클래스
// >> 자체로 인스턴스를 생성할 수 X
// >> 다른 클래스가 상속받아 완성해야만 사용 가능

// 2. 추상 클래스 특징
// 1) 자체로 인스턴스 생성 X
// 2) 반드시 하나 이상의 추상 메서드를 포함 // 다중 메서드 사용 가능

// 3. 추상 클래스 구현 방법
// : 클래스 선언 앞에 'abstract' 키워드 사용
// abstract class AbstractClass명 {}

// 4. 사용 목적
// : 확장성 제공을 위해 사용
//      - 자식 클래스가 공통된 기능을 공유 + 고유 기능을 구현하도록 강제하는 것

// cf) 다중 상속이 불가능 - 하나의 extends만 가능 //외동

// 5. 추상 메서드
// : 메서드의 선언부만 존재 O, 구현부가 없는 메서드 == {} X
// - 자식 클래스에서 해당 메서드를 반드시 구현하도록 강제하는 역할
// - abstract 키워드 사용 + 구현부 {} 대신 세미콜론;을 사용하여 선언 마침

// cf) 메서드 구성: 선언부(시그니처) + 구현부{}
// [접근제어자] 반환타입 메서드명(매개변수 나열...) { 구현부 - 메서드의 기능 동작 }

// cf) 메서드 오버라이딩 VS 추상 메서드
// - 추상 메서드: 반드시 자식 클래스에서 오버라이딩(구현부를 명시)
// - 일반 메서드: 필요에 따라 오버라이딩 가능

import javax.management.AttributeValueExp;

// 추상 클래스
abstract class Human {
    // 추상 메서드
    abstract void work(); // 구현부{} 없이 ;으로 종료
}

class Police extends Human {

    @Override
    void work() { // 추상 메서드 구현
        System.out.println("경찰은 치안유지 업무를 담당합니다.");

    }
}

class Student extends Human {
    @Override
    void work() {
        System.out.println("학생은 공부를 합니다.");
    }
}

// cf) 다중 상속 금지
abstract class Lion {
    abstract void mane();

}

abstract class Tiger {
    abstract void stripe();
}

//class Liger extends Lion extends Tiger { - 다중 상속 불가
//
//}

// 4.추상 클래스 예시
abstract class Animal {
    abstract void maksSound();

    void eat() {
        System.out.println("동물은 먹이를 먹습니다.");
    }
}

class Dog extends Animal {
    @Override
    void maksSound() {
        System.out.println("멍멍!");
    }

    // 일반 메스드는 선택적 재저의
    @Override
    void eat() {
        System.out.println("강아지는 개껌을 먹습니다.");
    }
    void bark() {

    }
}

class Cat extends Animal {
    @Override
    void maksSound() {
        System.out.println("야옹!");
    }
}

public class A_Abstract {
    public static void main(String[] args) {
//        Human human = new Human();  // 인스턴스화 할수 없다
        // >> 추상 클래스는 직접적인 인스턴스화가 불가능
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.maksSound();
        dog.eat();
        dog.bark();

        cat.maksSound();
        cat.eat();

        // cf) 추성 클래스 또한 클래스 타입으로 활용가능
        //      >>  단, 자식만이 가진 멤버(필드&메서드 )
        Animal animalDog = new Dog();
        animalDog.maksSound();
        animalDog.eat();
//        animalDog.bark();


    }
}

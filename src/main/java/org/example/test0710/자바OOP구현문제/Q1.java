package org.example.test0710.자바OOP구현문제;

    /*
    ### Q1. 상속과 오버라이딩

다음 요구사항을 만족하는 클래스를 구현하시오.

> Animal이라는 부모 클래스를 만든다.Animal 클래스에는 String name과 void makeSound() 메서드가 있다.

Dog, Cat 클래스는 Animal을 상속하(extends)고 makeSound() 메서드를 각각 “멍멍”, “야옹”을 출력하도록 오버라이딩한다.

Main 클래스에서 Animal 배열에 Dog와 Cat 인스턴스를 넣고 반복문(for)으로 모든 동물의 이름과 소리를 출력하라.
     */

import java.util.ArrayList;

class Animal {
    String name;

    void makeSound() {
        System.out.println(name + " 가 울음소리를 냅니다.");
    }

}

class Dog extends Animal{


    @Override
    void makeSound() {
        System.out.println("멍멍!");
    }
}

class Cat extends Animal{

    @Override
    void makeSound() {
        System.out.println("야옹!");
    }
}


public class Q1 {
    public static void main(String[] args) {
        ArrayList<Animal> arrayList = new ArrayList<>();
        Dog dog = new Dog();
        Cat cat = new Cat();
        arrayList.add(new Cat());
        arrayList.add(new Dog());
        arrayList.add(new Cat());
        arrayList.add(new Dog());



        cat.makeSound();
        dog.makeSound();


    }
}



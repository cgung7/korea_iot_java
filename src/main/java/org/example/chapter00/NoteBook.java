package org.example.chapter00;

import org.example.chapter09_practice.exception.UserNotFoundException;
import org.w3c.dom.ls.LSOutput;

class Animal {
    void sound() {
        System.out.println("동물은 웁니다.");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("고양이는 야옹~!");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("개는 왕왕!");
    }
}

public class NoteBook {
    public static void main(String[] args) {
        Animal c = new Animal();
        Animal a = new Cat();
        Animal b = new Dog();
        a.sound();
        b.sound();
        c.sound();




    }
}

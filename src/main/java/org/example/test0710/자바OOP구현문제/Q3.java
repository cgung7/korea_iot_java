package org.example.test0710.자바OOP구현문제;

/*
### Q3. 추상 클래스와 구현

> Shape라는 추상 클래스를 만든다.double getArea()라는 추상 메서드를 가진다.

Circle, Rectangle 클래스는 Shape를 상속받고 각자의 면적을 구하는 getArea를 구현한다.

Main 클래스에서 다형성을 활용해 각각의 도형 면적을 출력하라.

 */

abstract class Shape {
    abstract double getArea();
}

class Circle extends Shape {

    @Override
    double getArea() { return 0; }
}

class  Rectangle extends Shape {

    @Override
    double getArea() { return 4; }
}


public class Q3 {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();

        System.out.println("사각형은 각이 " + rectangle.getArea() + "개 입니다.");
        System.out.println("원형은 각이 " + circle.getArea() + "개 입니다.");
        if (circle.getArea() >= 1 ) {
            System.out.println("false");
        } else {
            System.out.println("원형은 각이 없어 둥급니다.");
        }

        if (rectangle.getArea() > 4) {
            System.out.println("사각형의 면은 " + rectangle.getArea() + "개입니다.");
        } else {
            System.out.println("false");
        }
    }
}

package org.example.chapter07.animalApp;

// == 동물 관리 시스템 == //

import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) {
        // == 서비스 계층(실행) 생성 == //
        // : service 객체의 handleAnimal 메서드는 Animal 타입의 객체를 인자로 받음
        AnimalService service = new AnimalService();

        // 동물을 관리하는 List 생성
        // : 객체 타입을 저장할 수 있는 ArrayList
        ArrayList<Animal> animals = new ArrayList<>();

        // 동적 배열에 객체 추가
        // : Animal 타입에 Cat/Dog 객체를 추가
        animals.add(new Cat()); // 업캐스팅 과정 (자동 타입 변환)
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Dog());
        animals.add(new Cat());

        // 배열의 모든 동물을 service에 전달하여 출력
        for (Animal animal: animals) { // (Animal animal: animal) == (리스트안에 있는 객체타입 중: 대상에 맞는 반복문 작성)
            if (animal instanceof Cat) { // 이작업은 진짜 자녀 Cat인지 확인, 캐스팅 전 안전도구 'instanceof'
                System.out.println("고양이가 있다!");
                Cat cat = (Cat) animal; // 다운캐스팅 ==> 자식(Cat)을 가져와야함으로 다운케스팅 괄호를 사용한다/
                // 'instanceof' 상단 확인 필
                cat.eat(); // 자식 클래스가 가진 고유한 메서드에 대한 접근
            }
            service.handleAnimal(animal);
        }

        // 객체 생성 및 처리
        Animal cat = new Cat();
        Animal dog = new Dog();

        service.handleAnimal(cat);
        service.handleAnimal(dog);

        // cat.eat();

        if (cat instanceof Cat) { // 다운캐스팅 전 사전 점검
            Cat onlyCat = (Cat) cat; // 다운캐스팅
            onlyCat.eat(); // 츄르
        }

        if (dog instanceof Cat) { // false (조건문 안의 구문이 실행 X
            Cat dogCat = (Cat) dog;
            dogCat.eat();
            System.out.println("강아지는 고양이의 인스턴스가 X (출력 X)");
        }
    }
}

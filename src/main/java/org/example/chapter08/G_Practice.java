package org.example.chapter08;


// === 인터페이스 === //
// : Fruit 과일 인터페이스 정의
// - color: 추상 메서드
// - describe: 디폴트 메서드
// - printType: 정적 메서드

interface Fruit {
    // 추상 메서드: public abstract 생략
    String color();

    // 디폴트 메서드: 재정의(오버라이딩) 가능
    default  void describe() {
        System.out.println("과일의 색상은 " + color() + "입니다.");
    }

    // 정적 메서드: 재정의(오버라이딩) 불가능
    static void printType() {
        System.out.println("과일(Fruit) 타입입니다.");
    }

}

class Apple implements Fruit {
    public String color() { return "red"; }
}

class Orange implements Fruit {
    public String color() { return "orange"; }

}

class Banana implements Fruit {
    public String color() { return "yellow";}

    @Override
    public void describe() {
        System.out.println("과일의 색성은 " + color() + "이며, 모양은 깁니다.");
    }
}

//인터페이스의 상속
// extends 확장하다
// : 클래스 간의, 인터페이스 간의 확장

// cf) implements 구현하다: A(클래스) implements B(인터페이스) 만 가능하다
interface TropicalFruit extends Fruit {
    // [ 생략 ]
    // - color: 추상 메서드
    // - describe: 디폴트 메서드
    // - printType: 정적 메서드

    default void tropicalFeature() {
        System.out.println("열대 과일은 후숙하면 더 맛있습니다.");
    }

}

class Mango implements TropicalFruit {
    @Override
    public String color() {
        return "yellow";
    }

    @Override
    public void describe() {
        System.out.println("과일의 색상은 " + color() + "이며, 모양은 타원형입니다.");
    }
}

public class G_Practice {
    public static void main(String[] args) {

        // 다형성 적용
        Fruit apply = new Apple();
        Fruit orange = new Orange();
        Fruit banana =  new Banana();
        TropicalFruit mango = new Mango();

        // 업캐스팅
        // : Mongo를 Fruit 타입으로 형변환
        // > TropicalFruit가 Fruit를 상속받은 인터페이스
        Fruit[] fruits = { apply, orange, banana, mango };

        for (Fruit fruit: fruits) {
            fruit.describe();
//            fruit.tropicalFeature();
            if (fruit instanceof TropicalFruit) {
                TropicalFruit tropicalFruit = (TropicalFruit) fruit;
                tropicalFruit.tropicalFeature();
            }

        }

        // A instanceof B
        // 'A' 객체가 B 클래스(종류)와 같은지 확인
        class 동물 {}
        class 고양이 extends 동물 {}
        class 강아지 extends 동물 {}

        동물 애니멀 = new 동물();
        동물 나비 = new 고양이();
        동물 초코 = new 강아지();

        if (애니멀 instanceof 고양이) {
            System.out.println("실행되지 않음, 부모 객체는 자식 객체에 담을 수 없음");
        }

        if (나비 instanceof 동물) {
            System.out.println("실행됨 나비는 동물의 일부");
        }

        if (나비 instanceof 고양이) {
            System.out.println("실행됨 나비는 원래 고양이, 고양이만이 가진 특정 기능을 수행하기를 원함");
            고양이 야옹 = (고양이) 나비; // if 조건문 외부에서도 가능 정상코드 (다만 확실하게 검증하고 변환을 위해 내부 작성 권장
        }




    }
}

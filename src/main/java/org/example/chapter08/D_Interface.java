package org.example.chapter08;

// 인터페이스
interface Flyable {
    // 날 수 있는 것에 대한 동작 정의

    int AVERAGE_SPEED = 100; // public static final 생략

    void fly(); // 추상 메서드 - public abstract (각 구현체에서 나는 행위를 재정의)

    // 디폴트 메서드 - 재정의 가능
    default  void land() {
        System.out.println("착륙합니다.");
    }

    // 정적 메서드 - 재정의 불가능 + 인터페이스 호출만 가능
    static  int getWingCount() {
        return 2;
    }
}

class 참새 implements Flyable {
    @Override
    public void land() {
        System.out.println("사뿐");
    }

    @Override
    public void fly() {
        // 인터페이스의 필드 사용가능
        System.out.println("참새의 속력은 " + AVERAGE_SPEED + "km의 평균 속도보다 느립니다.");
    }
}

class 독수리 implements Flyable {
    @Override
    public void land() {
        System.out.println("슈우우우웅");
    }

    @Override
    public void fly() {
        System.out.println("독수리의 속력은 " + AVERAGE_SPEED + "km의 평균 속도보다 빠릅니다.");
    }
}

public class D_Interface {
    public static void main(String[] args) {
        참새 bird1 = new 참새();

        bird1.fly();
        bird1.land();

        독수리 bird2 = new 독수리();

        bird2.fly();
        bird2.land();

        System.out.println(Flyable.getWingCount());

        Flyable bird3 = new 참새();
        Flyable bird4 = new 독수리();
        bird3.fly();
        bird4.fly();
        bird3.land();
        bird4.land();

    }
}

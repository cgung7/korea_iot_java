package org.example.chapter08;

// 📌 문제: 아래 조건을 만족하는 프로그램을 작성하세요.
/*
[문제 설명]
- 추상 클래스 `MobileApp`과 인터페이스 `Fruit`의 특징과 차이를 이해했는지 확인하는 문제입니다.
- 다음 조건에 맞는 클래스를 작성하고 main 메서드에서 동작을 확인하세요.

[문제 조건]


*/

//1. 추상 클래스 `TransportApp`을 정의하세요.
//        - 추상 메서드: `move()` → "이동 수단에 따라 이동 방식이 다릅니다." 를 출력하도록 구현 필요
//   - 일반 메서드: `info()` → "이동 관련 애플리케이션입니다." 를 출력
abstract class TransportApp {
    abstract void move();

    void info() {
        System.out.println("이동 관련 애플리케이션입니다.");
    }
}
//4. `EcoFriendly` 인터페이스를 정의하세요.
//        - 디폴트 메서드: `ecoMessage()` → "이동 수단은 친환경적입니다." 출력
interface EcoFriendly {
    default void ecoMessage() {
        System.out.println("이동 수단은 친환경적입니다.");
    }
}


//2. `TaxiApp` 클래스는 `TransportApp`을 상속하고, `move()`를 오버라이딩하여 "택시로 이동합니다." 출력
class TaxiApp extends TransportApp {
    @Override
    void move() {
        System.out.println("택시로 이동합니다.");
    }
}
//3. `BikeApp` 클래스는 `TransportApp`을 상속하고, `move()`를 오버라이딩하여 "자전거로 이동합니다." 출력
class BikeApp extends TransportApp implements EcoFriendly {
    @Override
    void move() {
        System.out.println("자전거로 이동합니다.");
    }

//5. `BikeApp`은 `EcoFriendly`도 구현하여 친환경 메시지를 출력할 수 있도록 구현
    @Override
    public void ecoMessage() {
        System.out.println("이동 수단은 친환경적입니다.");
    }
}
//6. main 메서드에서 `TransportApp` 배열을 만들어 `TaxiApp`과 `BikeApp`을 담고,
//   - 각 객체의 `move()`와 `info()`를 호출
//   - `EcoFriendly`를 구현한 객체만 `ecoMessage()`를 호출 (instanceof + 다운캐스팅)
public class Z_Review {
    public static void main(String[] args) {
//        [예상 출력 결과]
//        택시로 이동합니다.
//        이동 관련 애플리케이션입니다.
//        자전거로 이동합니다.
//        이동 관련 애플리케이션입니다.

        TransportApp[] apps = { new TaxiApp(), new BikeApp() };

           for (TransportApp app: apps) { app.move(); app.info();

           if (app instanceof EcoFriendly) { // 다운 캐스팅 사전 작업
                   EcoFriendly eco = (EcoFriendly) app; // 다운캐스팅
                //이동 수단은 친환경적입니다.
                   eco.ecoMessage();


            }
        }
    }
}


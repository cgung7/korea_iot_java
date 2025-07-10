package org.example.chapter08;

import org.w3c.dom.ls.LSOutput;

// 추상 클래스
// : 모바일 애플리케이션
abstract class MobileApp {
    // 추상메서드는 반드시 하나 이상: 실행에 대한 동작 정의
    // - 각 앱마다 '고유한 실행' 정의 (상속받은 클래스에 구현)
    abstract void execute();

    //일반(구현) 메서드
    void appInfo() {
        System.out.println("This is a mobile app");
    }
}

// == SNS 애플리케이션 == //
class SocialApp extends MobileApp {
   String name; // 인스턴스 필드 (각 객체가 가질 이름 EX. 인스타드램, 카카오톡 등)

    SocialApp(String name) {
        this.name = name;
    }

    @Override
    void execute() { // 실행하다
        System.out.println(name + " app executes");
    }

    @Override
    void appInfo() {
        System.out.println(name + " app is most popular social app");
    }

    // social app 고유 메서드
    void shareContent(String content) {
        System.out.println(name + " shares: " + content);
    }
}

// == Game 애플리케이션 == //
class GameApp extends MobileApp {
    @Override
    void execute() {
        System.out.println("Game app executes");

    }
}

public class F_Practice {
    public static void main(String[] args) {
        // == 다형성 적용 == //
        // : 업캐스팅
        MobileApp gameApp = new GameApp(); // GameApp 클래스에 String name 설정 X
        MobileApp socialApp = new SocialApp("Instagram"); // SocialApp 클래스에 String name 설정

        // 다형성 적용에 의해 공통된 메서드 호출 기능
        gameApp.execute();
        gameApp.appInfo(); // 재정의 X, 부모님 행위를 출력

        socialApp.execute();
        socialApp.appInfo();

//        socialApp.shareContent("images");
        // : 업캐스팅 시 하위 클래스의 고유 메서드에 접근 불가

        // == 형변환 == //
        if (socialApp instanceof  GameApp) {
            System.out.println("socialApp이 GameApp 타입의 객체");
            GameApp onlyGame = (GameApp) socialApp;
        } else if (socialApp instanceof SocialApp){
            System.out.println("socialApp이 SocialApp 타입의 객체");
            SocialApp onlySocial = (SocialApp) socialApp;

            onlySocial.shareContent("images");
        }

        // == 객체 배열 & 다형성 적용 == //
        MobileApp[] apps = {
                // 생성과 동시에 업캐스팅 - 묵시적 형 변환
                new GameApp(),
                new SocialApp("Facebook"),
                new SocialApp("kakaoTalk")
        }; // new

        for (MobileApp app: apps) {
            app.execute();
            app.appInfo();

            if (app instanceof SocialApp) {
                // 다운캐스팅
                SocialApp specificSocial = (SocialApp) app;
                specificSocial.shareContent("Files");
            }
        }
    }
}

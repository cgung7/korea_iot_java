package org.example.chapter12;

/*
    === MVC 패턴 ===
    : Model(모델), View(뷰), Controller(컨트롤러)
    - 사용자가 인터페이스를 설계하는 소프트웨어 디자인 패턴 중 하나
    - 세 가지 구성 요소로 나누어 개발을 진행 (역할 분담)

    cf) 디자인 패턴: 소프트웨어 디자인 과정에서 자주 발생하는 문제들에 대한 일반적인 해결책

    1. Model(모델)
            : 애프리케이션의 데이터와 비즈니스 로직을 담당
            - DB, 파일 시스템, 외부 서비스와의 통신을 통해 데이터를 저장하고 검색
            - 상태 변경에 대해 View와 Controller에게 알릴 수 있는 메커니즘을 제공
            >> View와 Controller의 세부 구현사항으로 부터 독립적

    2. View(뷰)
            : 사용자에게 데이터를 표시하는 방법을 정의
            - Model의 정보를 표시, 사용자 액션을 Controller에게 전달
            - Model이 가진 정보를 사용자가 이해할 수 있는 형태로 변환

    3. Controller(컨트롤러)
            : 사용자의 입력을 처리하고, Model과 View 사이의 상호작용을 관리
            - 사용자의 입력에 반응하여 Model을 업데이트 하고, 필요한 경우 View 를 새롭게 출력

    == MVC 패턴 장점 ==
    - 역할 분담
            : 각 구성 요소가 독립적인 기능을 책임 > 코드 관리 & 확장 용이

    - 유지보수 용이
            : 애플리케이션의 비즈니스 로직과 사용자 인터페이스(User Interface)가 분리되어 유지보수가 쉬윰

    == MVC 패턴 단점 ==
    - 복잡성 증가
            : 간단한 애프피케이션 구현하는 MVC 패턴 구조가 복잡성을 증가시김
    - 학습곡성 높음
            : 이해하고 사용하기 일정한 학습 목표

    == MVC 패턴의 작동 원리 ==
    View >> Controller >> Model, Controller, View

    cf) Spring: 자바 기반 웹 프레임워크
            >> Spring Boot(Spring MVC)

 */

// - 학교 급식 시스템 - //
// Model(모델): 급식표(데이터) -급식메뉴가 적힌 종이
// View(뷰): 칠판(화면) - 학생들이 확인하는 곳
// Controller(컨트롤러): 영양사 선생님 - 급식표 내용을 업데이트하고, 칠판에 알려주는 역할

// MVC 동작 흐름(원리)
// 학생(View) >> View(화면 클릭) >> Controller(영양사) >> Model(급식표) 조회
//          >> Controller가 View에 전달 >> View가 화면 출력

// 1. Model
class LunchMenu {
    private String menu;


    // getter / setter
    public String getMenu() { return menu; }
    public void setMenu(String menu) { this.menu = menu; }
}

// 2. View: 데이터를 보여주는 역할
class LunchView {
    public void displayMenu(String menu) {
        if (menu == null || menu.isBlank()) {
            System.out.println("오늘은 급식이 없습니다.");
        } else {
            System.out.println("오늘 급식 메뉴는: " + menu);
        }
    }
}

// 3. Controller: Model과 View
class LunchController {
    private LunchMenu model;
    private LunchView view;

    public LunchController(LunchMenu model, LunchView view) {
        this.model = model;
        this. view = view;
    }

    public void setLunchMenu(String menu) {
        model.setMenu(menu);
    }

    public void updateView() {
        String menu = model.getMenu();
        view.displayMenu(menu);
    }

    public void studentRequestMenu() {
        System.out.println("[학생 요청] 오늘 급식 뭐에요?");

    }
}




public class MVC {
    public static void main(String[] args) {
        // == 학교 급식 시스템 == //
        LunchMenu menu = new LunchMenu();
        LunchView view = new LunchView();

        LunchController controller =  new LunchController(menu, view);

        controller.setLunchMenu("김밥, 떡볶이, 콜라");
        controller.updateView();

        controller.setLunchMenu("김밥, 매운 떡볶이, 콜라");
        controller.updateView();


        controller.studentRequestMenu();
        controller.updateView();
    }
}

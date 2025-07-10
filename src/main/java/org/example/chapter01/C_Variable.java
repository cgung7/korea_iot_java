package org.example.chapter01;

public class C_Variable {
    // main 메서드 : main + 자동완성(ctrl + space)
    public static void main(String[] args) {
        // 변수(Variable)//
        // : 데이터를 저장하는 공간
        // - 데이터를 메모리에 저장하고 사용할 때의 공간

        // 1. 변수 선언 : 메모리 공간 생성
        // >> 데이터타입 변수명;
        String name; // 이름(문자)을 저장할 변수(공간)
        int price; // 가격(숫자)을 저장할 변수

        int num; // 정수
        char chr; // 문자
        boolean bool; // 논리

        // 2. 변수 초기화(할당) : 공간에 데이터 넣기
        // >> 변수명 = 데이터값;

        // cf) 초기화 - 처음 데이터를 넣는 과정
        //      (재)할당 - 데이터를 바꾸는 과정
        num = 10;
        chr = '가'; // 문자(char) : 작은 따옴표, 문자열(string) : 큰 따옴표
        bool = true;

        // cf) A = B
        // : 우항 B에서 좌항 A로 값을 '대입'한다!!
        // : 같다(==) - = 두번

        // 3. 변수 선언과 동시에 초기화
        // >> 데이터타입 변수명 = 데이터값;
        int number = 10;
        char character = '나';
        boolean boolValue = false;

        // 변수 명명 규칙 //
        // : 문자, 숫자, 기호를 사용 가능
        // 1) 대소문자를 구분, 길이 제한 X
        int age;
        int Age; // 서로 다른 변수(공간)

        // 2) 숫자로 시작할 수 없다
        // int 0age;
        int Age10;
        int a1g2e3;

        // 3) 기호는 _(언더스코어), $(달러)만 사용 가능
        //      : 기호로 시작 가능
        int _age;
        int $100age;
        // int age%; // 언더스코어 달러만 가능

        // 4) 자바의 예약어, 키워드는 변수명으로 사용할 수 없음
        // int if; < 예약어
        // int switch; < 예약어

        // +) 권장 사항
        // 변수명은 lowerCamelCase 사용 권장
        // : 소문자로만 작성 + 연결하는 단어의 시작은 대문자로 작성
        int strawberrychococake;
        int strawberryChocoCake;

        // cf) UpperCamelCase
        // : 대소문자로 시작 + 연결하는 단어의 시작은 대문자로 작성
        int StrawberryChocoCake;

        // cf) lower_snake_case;
        // : 소문자로만 작성 + 연걸하는 단어는 _(언더스코어)로 구분
        int strawberry_choco_cake;

        // 변수의 재할당 //
        int height = 170;

        // 변수의 재할당 : 변수명 = 변경할 값;
        height = 168;

        // 상수(Constant)
        // : 프로그램 실행 동안 그 값이 변경되지 않는 변수
        // >> 선언과 동시에 반드시! 초기화가 이루어져야 한다!

        // 1. 상수 선언 방법
        // final 키워드를 사용하여 선언
        // final 데이터타입 변수명 = 데이터값;

        // 2. 상수 명명 규칙
        // : UPPER_SNAKE_CASE 사용
        // : 모든 문자 대문자 + 연결은 _(언더스코어) 사용
        final int RESIDENT_NUMBER = 1234567;
        // RESIDENT_NUMBER = 9999999; - 상수는 재할당 불가능

        // 변수(상수)명을 활용한 데이터값 호출
        int numberValue = 10;

        // 변수명 호출 시 변수(공간) 안의 데이터값이 출력
        System.out.println(numberValue);
    }
}

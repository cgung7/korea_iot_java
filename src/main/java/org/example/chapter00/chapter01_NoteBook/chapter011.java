package org.example.chapter00.chapter01_NoteBook;

import java.math.BigDecimal;

public class chapter011 {
    public static void main(String[] args) {


    // === 변수와 상수 === //

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
        // 1. 기본 타입 (자료형 - 8개)
        // byte(1), short(2), long(8), float(4)
        // *자주 사용* int(4), double(8), char(2), boolean(1)

        // cf) 자료형 크기 단위
        // 1byte 체계 == 8bit
        // : 1bit는 메모리 한 칸

        // 1-1) 정수형 byte(1) < short(2) < int(4) < long(8)
        // byte : -128 ~ 127
        // short : = 32,768 ~ 32,767
        // int : 약 -2.1억 ~ 약 2.1억
        // long : 약 -2의 63제곱 ~ 약 2의 63제곱

//         byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
//        (float, double 정밀도가 높다)

        byte byteValue = 127;
        short shortValue = 32767;
        int intValue = 287239874;
        long longValue = 123123123123L; // long 타입은 숫자 뒤에 알파벳 L, l을 써서 표기(*대문자 권장-필수)

        // 1-2) 문자형 : char (Character)
        // : 2byte, 단일 문자 저장만 가능
        // : 홑따옴표(작은따옴표)로만 표기
        char grade = 'A';
        // char lastNave = "이"; = 쌍따옴표 사용금지
        char gender = '남';
        // char gender = '남자'; - 단일 문자 저장만 가능

        // 숫자(int)를 문자(char)로 변환
        int numberChar = 66;
        char letter66 = (char)numberChar; // 명시적, 강제 형 변환

        // 1-3) 실수형 : float(4) < double(8)(정확도가 더 높다, 자주사용)
        // : 부동 소수점이 있는 수
        float dollar1 = 32.123F; // 데이터값 뒤에 알파벳 f, F 사용(대문자 권장)
        double dollar2 = 32.123;

        // cf) 실수형의 정밀도(유효 소수 자릿수)
        // 1) float : 약 7자리 저옫까지 정확하게 표현
        float f1 = 123.456789F;
        System.out.println(f1); // 123.45679 - 소수점 자리가 반올림 처리

        // 2) double : 약 15 ~ 16자리 정도까지 정확하게 표현
        double d1 = 123.4567890123456789;
        System.out.println(d1); // 123.45678901234568

        // cf) 금융 계산, 정밀한 수치 연산에서는 BingDecimal을 사용 권장
        // : 문자열 형식으로 변환해야 정밀도 보장
        BigDecimal bigDecimal = new BigDecimal("1234567890.1234567890123456890");
        System.out.println(bigDecimal);

        // 1-4) 논리형 : boolean
        // : 데이터 값으로 true, false만 가짐
        // : 1byte 타입, 데이터 지정 시 소문자 값 사용을 권장
        // >> 변수명 지정 시 의문문 사용을 권장

        boolean isMarried = true;
        boolean isActive = true;
        boolean hasSnake = false;

        boolean isLogin = true;
        boolean isLightOn = false;

        // ==========================================================

        long aa = 32L; // long타입은 데이터 뒤에 알파벳 L, l 필수!(대문자 권장 필)

        // 2) 참조 자료형
        // : 기본 자료형을 기초로 만들어진 자료형
        // : 실제 데이터 값 X, 데이터가 저장된 주소값을 가지는 자료형

        // 2-1) 문자열(String)
        // : 문자열(문자 여러 개)을 저장하는 데 사용
        // : 반드시 쌍따옴표(큰따옴표)를 사용하여 문자열 작성

        String welcomeMassage = "만나서 반갑습니다 :)";
        System.out.println(welcomeMassage);

        // === 데이터 타입 정리 === //
        /*
            정수 : byte < short < int(Integer) < long
            실수 : float < double
            문자 : char(Character)
            논리 : boolean

            >> Wrapper 클래스 : 기본 자료형을 객체로 감싸기 위해 제공되는 클래스
                    기본 자료형을 참조 자료형처럼 사용

            cf) 참조 자료형 : 문자열(string), 배열, 객체 등
         */

        // << 실습 >> //
        // : 학생 이름, 학생 나이, 학생 키, 학생 성별('M', 'F' - 단일 문자), 학생 여부
        //      변수 선언과 본인의 데이터로 초기화

        String studentName = "이승아";
        int studentAge = 29;
        char studentGender = 'f';
        boolean isStudent = false;

        // String studentName = "이도경";
        // 하나의 스코브(영역) 내에서는 동일한 변수명 사용 불가
        // : 스코프는 {}로 구분
    }
    // 스코프가 다르면 동일한 변수명 사용가능
    String studentNave = "이도경";
}

package org.example.chapter16;

/*
    === Wrapper 클래스 ===
    : 기본 데이터 타입을 객체로 다루기 위해 사용

    cf) 기본 데이터 타입
     byte, short, int, long, char, float, double, boolean (+ void 메서드 변환)
     >> 각 데이터 타입에 해당하는 Wrapper 클래스가 존재

    cf) java.lang 패키지에 정의
        : 컬렉션 프레임워크에서는 내부에 객체만을 저장
        - 기본 타입을 Wrapper 클래스로 변환하여 저장
        >> Integer, Character 등 (외에는 시작 알파벳 대문자 변환)

    === 박싱(Boxing) & 언박싱(UnBoxing) ===
    : 기본 타입과 해당 타입의 Wrapper 클래스 간의 자동 변환
    - 자바 컴파일러가 자동 처리

    1) 박싱
    : 기본 >> Wrapper 클래스 객체로 변환
    2) 언박싱
    : Wrapper 클래스의 객체 >> 기본 타입으로 변환

    +) 장단점
    - 장점: 기본 타입과 객체 타입 간의 호환이 용이
    - 단점: 객체 생성 과정에서 메모리 사용량 증가 (박싱, 언박싱 과정에서 성능 저하)
            null 값이 할당될 수 있는 Wrapper 객체를 언박싱 할 경우 NPE(NullPointerException) 발생 위험


 */

public class A_Wrapper {
    public static void main(String[] args) {
        // 1) 박싱
        int i = 5;
        Integer iObject = i;
        System.out.println(iObject);

        // 2) 언박싱
        // Wrapper 객체 생성: 객체타입.valueOf(값);
        Integer integerValue = Integer.valueOf(15);
        int iValue = integerValue;
        System.out.println(iValue);

        // === Wrapper 클래스의 내부 메서드 === //
        // cf) toString() 메서드 등

        Integer myInteger = Integer.valueOf(20);

        // 1) intValue(): Integer 객체를 기본 int 타입으로 변환 Integer -> int
        int myInt = myInteger.intValue();
        System.out.println(myInt);

        Object obj = Integer.valueOf(100);
        // int x = obj; - 자동 언박싱 불가. Object 타입은 컴파일 에러
        int x = ((Integer)obj).intValue(); // 다운캐스팅 처리로

        Integer a = null;
        // int abc = a; NPE
        int abc = (a != null) ? a.intValue() : 0; // 안전하게 기본값을 처리
        System.out.println(abc); // 0

        // 2) parseInt(String s): 문자열을 기본 int 타입으로 파싱
        // String >> Integer >> int
        int parseIntValue = Integer.parseInt("123");
        System.out.println(parseIntValue); // 123

        // int parseOntValue2 = Integer.parseInt("abc");
        // System.out.println(parseOntValue2); // NumberFormatException

        // 3) a.compareTo(Integer anotherInt)
        // : 두 Integer 객체를 비교해서 같으면 O, 호출 객체(a)가 더 크면 양수, 더 작으면 음수
        Integer anotherInt = Integer.valueOf(200);
        int result = myInteger.compareTo(anotherInt); // myInteger: 20
        System.out.println(result); // -1
    }
}

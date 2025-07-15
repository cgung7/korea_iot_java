package org.example.chapter13;

/*
    === 제네릭(Generic, 일반적인) ===
    : 데이터 타입을 일반화(Generalize)하는 것
    : 클래스나 메서드를 선언할 때, 구체적인 타입을 명시하지 않고
        , 사용 시점에 지정할수 있도록 하는 기능

    - 같은 코드를 (사용 시) 여러 타입에 맞게 재사용 가능
    - 미리 타입을 정해놓지 않고, 실제 사용 시점에 타입을 결정

    1. 제네릭 장점
    - 타입 안정성: 컴파일 시 타입 체크가 가능, 타입 에러 방지
    - 코드 재사용성 증가: 하나의 코드로 다양한 타입 사용 가능
    - 가독성이 증가: 사용 시 타입 명시로 코드 의도 파악 가능

    2. 제네릭 사용 방법

    1) 제네릭 클래스

    class 클래스명<타입매개변수> {
     // 타입 매개변수를 사용하는 필드, 생성자, 메서드 작성
    }

    cf) 타입 매개변수(타입 변수)
            : 코드 작성 시 타입 변수로 클래스나 메서드 내부의 타입을 지정
                    , 해당 기능 사용 시 작성되는 실질적인 타입이 전달

            <T>: Type 약자 (가장 흔하게 사용)
            <K, V>: Key, Value의 구조 (Map 구조에서 주로 사용)
            <E>: Element (컬렉션에서 주로 사용)
 */

import java.util.ArrayList;
import java.util.List;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }

    // 2) 제네릭 메서드
    // : 메서드 자체에서 제네릭 타입을 선언하고 사용하는 메서드
    // - 제네릭 타입은 반환타입, 매개변수, 내부 지역 변수 선언 등 다양하게 사용 가능

    // [접근제한자] <제네릭타입> 반환타입 메서드명(매개변수...) {구현부}
    // cf) static 멤버에서는 클래스의 제네릭 타입 매개 변수 사용이 불가
    //      >> static 메서드는 제네릭 타입을 직접 선언(<T>: 메서드 선언 앞에 필수 명시)
    static <T> void print(T value) {
        System.out.println(value);
    }

}

public class A_Generic {
    public static void main(String[] args) {
        // == 제네릭 사용 방법 (실질적인 타입 전달) == //
        // 제네릭 메서드 사용
        // <제네릭타입> 메서드명();
        Pair.<String>print("안녕"); // 안녕

        // Pair.<Integer>print("안녕");
        // incompatible types(호환되지 않는 타입)
        // : java.lang.String cannot be converted to java.lang.Integer

        Pair.<Integer>print(100); // 100

        // cf) 자바의 제네릭은 타입 명시를 생략해도 자동으로 타입을 추론
        Pair.print("Hello"); // T에 String 추론
        Pair.print(200); // T에 Integer 추론

        // == 제네릭 클래스 사용 == //
        // 클래스명<제네릭 타입> 인스턴스명 = new 클래스명<>();

        // cf) 제네릭 타입의 명시는 필수가 아니다.
        //      : 제네릭 타입의 구조에 값이 들어올 경우 해당 값으로 자동 유추

        Pair<Integer, String> pair1 = new Pair<>(100, "안녕");
        Pair<Integer, String> pair2 = new Pair<Integer, String>(200, "Hello");
        // >> 좌항의 클래스타입은 필수

        // cf) 제네릭 타입의 경우 기본 타입 직접 사용 불가
        //      >> Wrapper 클래스 사용
        // - int >> Integer
        // - double >> Double
        // - char >> Character

        System.out.println(pair1.getKey()); // 100
        System.out.println(pair1.getValue()); // 안녕

        Pair<String, Integer>pair3 = new Pair<>("Hi",999);

        // Pair<int, char>pair4 = new Pair<int, char>();
        // >> 타입 인수는 기본 타입일 수 없습니다.

        // cf) 제네릭 타입은 컴파일 이후 실제 타입 정보가 사라지고 Object로 변환
        //      - 런타입 시에는 Object로 동작
        //      >> 타입 소거(Type Erasure)
        List<String> list = new ArrayList<>();
        list.add("Hello");
        // 컴파일 시 리스트 내부 요소가 String 인지 검사
        // >> 런타임 시에는 List<String>dl list로 취급됨 (타입 정보는 사라짐)

        // 타입 소거의 제약사항
        // list instanceof List<String> (사용 불가)
        // - 배열을 제네릭으로 만들 수 없다. (new T[]) 불가

    }
}

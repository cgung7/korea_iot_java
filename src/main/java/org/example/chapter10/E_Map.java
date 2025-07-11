package org.example.chapter10;

// == Map 인터페이스 == //
// : 키(key)와 값(value)의 쌍으로 요소를 저장하는 데이터 구조
// - 키는 고유한 데이터를 가짐 (중복 키 허용 X)
// - 동일한 키에 서로 다른 값 전달 시 기존 값이 새로운 값으로 덮어 씌워짐
// EX) name: "이승아", name: "이도경" (불가능 - name: "이도경"만 존재 -덮여씌워짐)

// cf) 서로 다른 키에 동일한 값은 가능
// EX) name: "개구리", nickname: "개구리"

// +) 키의 유일성, 값의 중복성 보장
//      >> 순서 보장 X (예외 O)
// - 키를 기반으로 빠른 검색 가능

// == Map 인터페이스 종류 (구현체) == //
// 1. HashMap
//      : 가장 많이 사용, 키와 값에 null 허용
//      - 빠른 검색, 삽입 성능 제공
//      - 순서 유지 X

// 2. LinkedHashMap
//      : HashMap + 삽입 순서 유지
//      - 삽입 순서가 중요하고 빠른 검색이 필요할 때 사용

import java.util.*;

// 3. TreeMap
//      : 키에 따라 자동 정렬 기능 보장
//      - 키에 null 허용 X
public class E_Map {
    public static void main(String[] args) {
        // == Map 인터페이스 메서드 == //
        // Map<키 타입, 값 타입> 인스턴스명 = new Map종류<>();
        Map<String, Integer> studentAges = new HashMap<>();

        // put(키, 값): 키와 값을 Map에 추가
        studentAges.put("홍기수", 20);
        studentAges.put("김지수", 24);
        studentAges.put("김동후", 30);

        System.out.println(studentAges);
        // {홍기수=20, 김지수=24, 김동후=30}
        // 중괄호 내에 키=값의 쌍이 콤파로 구분되어 나열
        // >> 삽입 순서 보장 X

        System.out.println(studentAges.get("홍기수")); // 지정돤 키의 값을 반환 =>20

        studentAges.remove("김동후"); // 지정된 키의 값을 삭제 후 반환
        System.out.println(studentAges);

        System.out.println(studentAges.containsKey("이승아")); // false
        System.out.println(studentAges.containsValue(30));

        System.out.println(studentAges.containsKey("김지수")); // 검색 값이 있기 때문에 true
        System.out.println(studentAges.containsValue(20));

        System.out.println(studentAges.size()); // 2

        // keySet(): Map의 키들을 Set 타입으로 반환
        System.out.println(studentAges.keySet()); // [홍기수, 김지수]

        // values(): Map의 값들을 컬렉션 타입으로 반환
        Collection<Integer> listAges = studentAges.values();
        System.out.println(listAges); // [20, 24]

        // cf) Collection 타입은 하위 인터페이스로 변환 가능
        List<Integer> changeList = new ArrayList<>(listAges);
        System.out.println(changeList); // [20, 24]

        // entrySet(): Map 의 키와 값을 Set으로 변환
        System.out.println(studentAges.entrySet()); // [홍기수=20, 김지수=24]


    }
}

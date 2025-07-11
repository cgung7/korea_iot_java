package org.example.chapter10;

/*
 *  === Set 인터페이스 ===
 *  : 중복 X, 순서 X > List와 상반된 인터페이스
 *  - 중복된 요소를 포함하지 않은 객체의 집합
 *  - 객체가 저장 순서를 가지지 않음(삽입된 순서 유지X)
 *  - null 요소 포함 가능
 *
 *  cf) List: 중복 O, 순서 O, null 요소 포함 가능
 *
 *  == 종류 ==
 * 1. HashSet
 *      : 가장 많이 사용되는 Set 구현체
 *      - 빠른 데이터 접근, 삽입 지원
 *      - 정렬 또는 순서 보장 X
 *
 * 2. LintedHashSet
 *      : HashSet + 순서 O (HashSet의 기능 확장 형태)
 *      - 중복 X, 순서 O
 *
 * 3. TreeSet
 *      : 데이터가 자동 정렬, 중복 제거 + 정렬된 순서 유지가 필요한 경우
 *      - 중복 X, 순서 O
 */

import java.util.HashSet;
import java.util.Set;

public class D_Set {
    public static void main(String[] args) {
        // == Sst 컬랙션의 주요 메서드 == //
        // add(), remove(), contains(), size(), isEmpty()

        Set<String> student = new HashSet<>();

        student.add("정지훈"); //리스트 추가(학생)
        student.add("정은혜");
        student.add("최광섭");
        student.add("손태경");

        System.out.println(student); // 순서는 정해지지 X

        student.add("정은혜");
        System.out.println(student); // 중복은 자동 삭제

        boolean result = student.remove("최광섭"); // 제거 후 완료 여부 반환
        System.out.println(result); // true
        System.out.println(student); // 제거 후 리스트 확인

        boolean falseResult = student.remove("이승아");
        System.out.println(falseResult); // false -- 리스트에 없기 때문에 결과값 실행 불가

        System.out.println(student.size()); // 총 인원 몇명?

        System.out.println(student.contains("손태경")); // 특정 검색 true / false
        System.out.println(student.contains("정지훈"));
        System.out.println(student.contains("조승범")); // 리스트 지정 X // false

        System.out.println(student.isEmpty()); // 리스트 비어있는지 확인

        student.clear();
        System.out.println(student.isEmpty());
    }
}

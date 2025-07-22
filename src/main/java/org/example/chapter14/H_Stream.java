package org.example.chapter14;

/*

    === 스트림(Stream, 흐름) API ===
    : 자바 8부터 도입된 기능
    - 컬렉션 또는 배열에 저장된 데이터를 선언형(직관, 간결) 방식으로 처리할 수 있게 지원하는 도구
    - 데이터 필터링, 매핑(변환), 집계 등 다양한 작업 수행
    - 람다식과 결합하여 가독성 높은 코드 작성 가능


    1. 스크림의 3단계 구조 (데이터 파이프라인)
    : 스트림은 데이터를 소스로 부터 연속적으로 처리하는 '파이프 라인' 구축

    cf) 데이터 파이프 라인
            : 데이터를 사용하는 단계, 절차, 흐름

    1) 소스 (Source)
    : 스트림의 시작점 (생성 단계)
    - 컬렉션, 배열 또는 파일을 소스로 사용
    EX) list.stream(), Arrays.stream()

    2. 중간 연산
    : 데이터를 가공하는 단계 (필터링, 매핑(변환), 통계 등
    - 스트림으로 결과가 반환되기 때문에 메서드 체이닝이 가능
    +) 지연 처리: 최종 연산이 실행되기 전까지 동작하지 않음
    EX) .filter(x -> x % 2 == 0) // 필터링 (5, 4, 3, 2, 1 ) >> (4, 2)
        .map(x -> x * x) // 변환 (4, 2) >> (16, 4)
        .sorted() // 정렬 (16, 4) >> (4, 16)

    3. 최종 연산
    : 스트림을 소모하고 결과를 생성
    - 모든 데이터를 처리한 후 결과를 반환하거나 출력하는 연산
    - 이후 스트림 재사용 불가
    EX) collect, forEach, count 등

    2. Stream API 특징
    1) 불변성: 원본 데이터를 변경하지 않음, 새로운 값 반환 (== final)
    2) 지연 처리: 중간 연산은 실제로 실행되지 않음, 최종 연산 시 처리됨
    3) 일회성: 스트림은 한 번만 사용 가능 (재사용 시 예외 발생)
    4) 선언형: 간결한 문법 사용 가능 (람다식)

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class H_Stream {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("정지훈");
        names.add("정은혜 :)");
        names.add("최광섭");
        names.add("손태경 :)");
        names.add("박진영");
        names.add("박진영");

        System.out.println(names);

        // 1. 데이터 소스 (Stream 생상)
        // 데이터.stream()
        Stream<String> streamNames = names.stream();

        // 2. 중간 연산
        // : 스트림데이터.키워드(람다식)
        //      >> 스트림 소스에 원하는 기능을 사용
        //      >> 전체 스트림을 순회하여 각 키워드의 기능을 수행

        // cf) 스트림 중간 연산 내부의 람다식
        //      >> 스트림 내부의 요소값을 하나씩 매개변수에 담음
        //      >> 구현부에서 인자로 해당 매개변수와 일치하는 값을 전달하는 경우에는 메서드 참조 가능

        // - filter: 조건에 맞는 요소만 추출
        // - map: 요소를 다른 값으로 변환(매핑)
        // - sorted: 요소 정렬
        // - distinct: 중복 제거
        // - limit(n): 처음부터 n개만 추출
        // - skip(n): 처음부터 n개를 건너뜀

        // streamNames.filter(name -> name.length() >= 3)
        // streamNames.filter(name -> name + "님");

        // 3. 최종 연산
        // : 스트림 소모 + 결과 생성
        // - forEach: 각 요소에 대해 동작 수행 (반환 X)
        // - collect:컬렉션으로 반환
        // - reduce: 모든 요소를 하나의 값으로 줄임
        // - count: 요소의 개수를 반환

        // == 예제 == //
        // 1) "정"으로 시작하는 사람의 이름에 "님"을 붙여서 출력
        //      cf) 문자열.startWith("문자열"): 해당 문자열로 시작여부를 반환 (boolean)
        //      cf) 문자열.contains("문자열"): 해당 문자열 포함 여부를 반환 (boolean)
        System.out.println("\"정\"으로 시작하는 사람의 이름에 \"님\"을 붙여서 출력");
        streamNames
                .filter(name -> name.startsWith("정"))
                .map(name -> name + "님")
                // 람다식
//                .forEach(name -> System.out.println(name));
                // 메서드 변환
                .forEach(System.out::println);

        System.out.println("이름 길이가 3글자인 사람만 출력");
        names.stream()
                .filter(name -> name.length() == 3)
                .forEach(System.out::println);

        System.out.println("중복 제거 후 오름차순으로 정렬하여 출력");
        names.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);
        // 4)
        System.out.println("총 인원 수 출력");
        long count = names.stream().count();
        System.out.println("총 인원 수: " + count + "명");

        // 5)
        System.out.println("이름 중 2번째 이후 사람 2명만 출력");
        names.stream()
                .skip(2)
                .limit(2)
                .forEach(System.out::println); // soutc: sout 메서드 참조 자동 완성

        // 6)
        System.out.println("이름 길이의 합 구하기");
        int totalLength = names.stream()
                .map(name -> name.length())
                // .reduce(초기값, 합산식);
                // .reduce(0, (a, b) -> a + b)); - a는 최신값(누적값), b는 순회값
                .reduce(0,Integer::sum);

        System.out.println("이름 길이 합산: " + totalLength);

        // 7)
        System.out.println("모든 이름을 하나의 문자열로 합치기 (comma 구분)");
        String result = names.stream()
                .collect(Collectors.joining(", ")); // delimiter: 구분자
        System.out.println("합친 이름들: " + result);

        // 8)
        System.out.println("이름 길이 기준 내림차순 정렬");
//        names.stream()
//                .sorted((a, b) -> a.length() - b.length()) // 오름차순 정렬 (기본)
//                .forEach(System.out::println);

        names.stream()
                // 내림 차순 (숫자가 큰 수 부터 정렬)
                // a, b는 리스트 안의 두 문자열
                // : b.length() - a.length()는 문자열 길이 차이를 이용하여 정렬 순서 결정
                // >> b가 다 크면 양수
                // >> 더 큰값을 앞으로 정렬 (양수면 b가 먼저, 음수면 a가 먼저, 0이면 그대로)
                .sorted((a, b) -> b.length() - a.length())
                .forEach(System.out::println);

        System.out.println("이름을 길이로 그룹화");
        Map<Integer, List<String>> grouped = names.stream()

                .collect(Collectors.groupingBy(String::length));

        grouped.forEach((length, group) -> {
            System.out.println(length + "글자: " + group);
        });







    }
}

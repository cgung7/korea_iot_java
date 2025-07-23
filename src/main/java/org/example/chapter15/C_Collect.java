package org.example.chapter15;

/*
    === 스트림 API의 최종 연산 ===
    1. collect 메서드
    : 스트림의 요소를 변환, 집계하여 최종 결과를 생성하는데 사용
    - 스트림의 종결 작업 중 하나
    - 특정 컨테이너(List,Set, Map)으로 변환 || 값을 합산, 집계 사용

    2. Collectors 클래스
    : 다양한 Collectors를 제공하여 collect() 메서드와 결합해 하나의 결과를 반환
    - 다양한 정적 메서드 제공

    1) toList, toSet, toMap: 해당 컬렉션으로 값 변환
    2) joining(): 문자열 요소를 연결
    3) counting(): 스트림의 요소 수를 계산
    4) grouping(): 요소를 그룹화
    5) partitioningBy(): 스트림 요소를 조건에 따라 두 그룹으로 나눔

 */

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C_Collect {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Python", "Javascript");

        // Collector.toList()
        List<String> upperLanguages = languages.stream()
                .map(String::toUpperCase) // 목록 모두 대문자로 변경
                .collect(Collectors.toList());

        // Collectors.joining(delimiter - 구분자, prefix - 접두사, suffix - 접미사)
        String result = upperLanguages.stream()
                .collect(Collectors.joining(", ","[ "," ]")); // upperLanguages에 joining을 대입
        System.out.println(result); // [ JAVA, PYTHON, JAVASCRIPT ]

        // Collectors.groupingBy()
        // : 특정 기준에 따라 그룹화
        Map<Character, List<String>> groupedByFirstChar = upperLanguages.stream()
                .collect(Collectors.groupingBy(language -> language.charAt(0)));

        System.out.println(groupedByFirstChar); // {P=[PYTHON], J=[JAVA, JAVASCRIPT]}

        // Collectors.partitioningBy()
        // : 조건에 따라 두 그룹으로 나눔 (해당 조건이 참 / 거짓인 경우로 나뉨) // filter()보다 정밀함
        Map<Boolean, List<Integer>> partitioned = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.partitioningBy(num -> (num & 2) == 0));

        System.out.println(partitioned); // {false=[2, 3], true=[1, 4, 5]}

    }
}

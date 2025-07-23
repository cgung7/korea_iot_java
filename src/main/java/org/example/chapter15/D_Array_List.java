package org.example.chapter15;

/*
    === 배열 VS 리스트 ===
    +) 공통점: 순서 O (인덱스 기반, 0부터 시작), 인덱스 번호로 접근 가능

    1. Array(배열)
        : 정적 자료구조
        : 크기가 고정 - 생성 시 지정한 크기 변경 불가
        : 연속된 메모리 공간에 저장
        : 데이터가 동일한 타입이여야 함 (명시적)

        +) 원소 추가, 삭제 - 직접 구현


    2. List(리스트)
        : 동적 자료구조
        : 크기 가변
        : 메모리 공간이 불연속적
        : 다양한 구현체 존재
            - ArrayList, LinkedList 등

    +) List<> 컬렉션 프레임워크는 불변 리스트, 가변 리스트 모두 할당 가능


 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class D_Array_List {
    public static void main(String[] args) {
        // List 생성 방법
        // 1) new ArrayList<>(); ***
        //      - 가변 O (길이 변경, 수정 가능)
        //      - 가장 일반적인 생성자 사용 리스트 생성 방식
        List<String> list = new ArrayList<>();

        // 2) Arrays.asList(); ***
        //      - 가변 X - 길이 고정,  수정은 가능
        //      - 가짜 ArrayList: Arrays 클래스 내부에서 구현된 별개의 ArrayList (컬렉션 프레임워크 X)
        //      - 배열을 리스트로 변환
        List<String> asListVar = Arrays.asList("a", "b");
        //        asListVar.add("c");
        asListVar.set(0, "c");

        // 3) List.of(); ***
        //      - 불변 (길이 고정, 수정 불가)
        //      - 읽기 전용 리스트 생성
        //      - null 값을 포함 불가 X
        List<String> listOfVar = List.of("a", "b");
//        listOfVar.add("c");
//        listOfVar.set(0, "c");


        // 4) Stream.of().collect(Collector.toList());
        //      - 가변 O (길이 변경, 수정 가능), 1번과 동일
        List<String> collectVar = Stream.of("a","b")
                .collect(Collectors.toList());
//           .toList();

        // 5) List.copyOf();
        //      - 불변 (길이 고정, 수정 불가)
        //      - 기존 리스트의 불변 복사본 생성
        List<String> copyVar = List.copyOf(list);
    }
}

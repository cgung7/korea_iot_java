package org.example.chapter00.chapter02_NoteBook;

/*
    if 문
    조건식이 true일 때 실행할 코드를 지정 (조건 분기)

    복잡한 조건식(범위,논리 연산 등)을 사용할 수 있음
    조건식이 다양하거나 범위 비교 사용 - 복잡한 조건
    boolean 타입 조건 사용

    switch 문
    하나의 변수 값에 따라 여러 분기 처리 (값에 따른 분기)

    비교 대상이 정수, 문자열, enum 등일 때 사용
    if 보다 가독성이 좋을 수 있음(단 많은 값 비교 시)
    조건은 정확한 값 일치만 가능 (범위 비교 불가)

    for 문
    일정 횟수 반복할 때 사용 (반복 수행)

    반복 회수를 명확히 알고 있을 때 적합
    배열, 리스트 등 순회할 때 자주 사용 - 반복 횟수 제어 가능
    향상된 for문(for-each)도 있음

     while 문
    반복횟수가 정해져 있지 않을 때 사용

    조건을 검색하고 해당 조건이 true인 경우 반복적 실행
    if 문의 반복 형태


 */



public class chater023_if_switch_for {
    public static void main(String[] args) {


    // 1. if 문 예제
    int score = 85;

    if (score >= 90) {
        System.out.println("A학점입니다.");
    } else if (score >= 80) {
        System.out.println("B학점입니다.");
    } else {
        System.out.println("C학점 이하입니다.");
    }

    // 2. switch 문 예제
    String day = "MON";

    switch (day) {
        case "MON":
            System.out.println("월요일입니다.");
            break;
        case "TUE":
            System.out.println("화요일입니다.");
            break;
        default:
            System.out.println("다른 요일입니다.");
            break;
    }

    // 3. for 문 예제
    for (int i = 1; i <= 5; i++) {
        System.out.println("반복 횟수: " + i);
    }

    // 4. 향상된 for문 예제
    int[] numbers = {10, 20, 30, 40};

    for (int num : numbers) {
        System.out.println("배열 값: " + num);
    }
    }
}





package org.example.chapter00.chapter02_NoteBook;

// === 제어문 === //
// : 프로그램의 실행 흐름을 제어(Control)하는 문법

// 1) 조건문(Condition)
// : 특정 조건을 만족할 때만 코드 블록을 실행
// - if, else, else of : 조건에 따라 실행할 코드를 결정
// - switch, case, default : 여러 개의 경우(case)에 대해 실행할 코드를 결정
// +) continue, break : 실행 흐름을 제어

// 2) 반복문
// : 특정조건이 만족될 때까지 코드 블록을 반복 실행
// - for, while, do while
// +) continue, break

public class chapter02_if {
    public static void main(String[] args) {



    // 1. if문 (만약 ~라면) / else문 (그 밖에)

        /*
            if문 기본 형태(+ else)

            if (조건식) {
                조건에 참인 경우 싱행할 코드
            }
            -------------------------------
            if (조건식) {

            } else {
                조건이 거짓인 경우 실행할 코드
            }
            -------------------------------
            else if (조건식) {
                앞선 조건식이 거짓이며,
                해당 조건식이 참인 경우에 실행할 코드
            }

            >> if 문과 else 문 사이에 작성 (else가 필연적 X)
            >> 수의 제한이 X (if, else 문 사이에 여러 개 나열 가능)
         */
    // 예제 1) 나이분류

        int age = 14;

        if (age > 19) {
        // 조건식이 참일 경우 실행(age는 19를 최과하는 모든 수가 될수 있음)
        System.out.println("성인입니다.");
    } else {
        // 조건식이 거짓인 경우 싱행(age는 19 이하의 모든 수)
        System.out.println("미성년자입니다.");
    }
}
}

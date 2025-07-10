package org.example.chapter02;

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
import java.util.Scanner;

public class A_If {
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

        int age = 14;

        // 예제 1) 나이분류
        if (age > 19) {
            // 조건식이 참일 경우 실행(age는 19를 최과하는 모든 수가 될수 있음)
            System.out.println("성인입니다.");
        } else {
            // 조건식이 거짓인 경우 싱행(age는 19 이하의 모든 수)
            System.out.println("미성년자입니다.");
        }

        // 예제 2) 나이 분류 (else if 추가)
        if (age > 19) {
            System.out.println("성인");
        } else if (age > 13) {
            // 첫 번째 조건인 age > 19 가 아닌 값 중에서
            // 두 번째 조건인 age > 13 이 부합하는 값
            // : 13 < age <= 19
            System.out.println("청소년");
        } else {
            // 첫 번째, 두번째 조건이 모두 거짓인 경우
            // : age <= 13
            System.out.println("어린이");
        }

        // 예제 3) 나이 분류 (중괄호 생략)
        // : 조건문에서 실행될 코드 블럭 ({})에 코드가 하나의 구문인 경우 {} 생략 가능
        if (age > 19) System.out.println("성인");
        else if (age > 13) System.out.println("청소년");
        else System.out.println("어린이");

        // 코드 컨벤션 //
        // 1. 중괄호 내부에서는 한 칸 들여쓰기
        // 2. 기호와 키워드 사이에는 한 칸 띄어쓰기
        // 3. 콜론의 경우 'A: B' 와 같이 앞은 붙이고, 뒤는 한 칸 띄어쓰기

        // +) 코드 정리 단축기: ctrl + alt + l

        // == if 조건문 예제 == //
        // : 좌표의 사분면 찾기
        // 1. 스캐너를 사용하여 x, y 변수에 데이터를 저장
        // 2. (x, y) 좌표가 제 1, 2, 3, 4 사분면 중 어느 위치에 있는지 검사
        // >> 조건문

        // 3. 각 분기에 위치할 경우 functionScope 변수에 몇 사분면인지 (재)할당
        // EX) functionScope = "제1사분면";

        // 4. 조건문 이행 완료 시
        // "결과: " + functionScope 출력


        // == 풀이 == //
        // 1. 각 조건식에서 저장할 문자열값(사분면의 위치)을 담을 변수 선언
        String functionScope = null; // String과 같은 참조 자료형은 기본값(비워져 있음)을 null로 표시

        // 2. 스캐너 생성
        Scanner sc = new Scanner(System.in);
        System.out.println("x: ");
        int x = sc.nextInt();

        System.out.println("y: ");
        int y = sc.nextInt();

        // 3. 조건문 작성
        if (x > 0 && y > 0) {
            // x, y가 모두 양수: 제 1사분면
            functionScope = "제1사분면";
        } else if (x < 0 && y > 0) {
            functionScope = "제2사분면";
        } else if (x < 0 && y < 0) {
            functionScope = "제3사분면";
        } else {
            functionScope = "제4사분면";
        }

        // 4. functionScope 값 출력
        System.out.println("결과: " + functionScope);

        // 5. 스캐너 종료
        sc.close();
    }
}
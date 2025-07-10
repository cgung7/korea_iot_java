package org.example.chapter02;

import java.util.Scanner;

public class D_while {
    public static void main(String[] args) {
        // === While 문 === //
        // : 반복 횟수가 정해져있지 않을 때 사용

        // - 조건을 검사하고 해당 조건이 true인 경우 쿠드 블록을(반복적) 실행
        //  : if문의 반복 형태

        /*
            while (조건식) {
                조건이 참인 경우 실행
                }

                >> for문의 초기화식과 증감식이 조건문과 분리된 형태
                    : for (초기화식; 조건식; 증감식) {}
         */

        // cf) for문으로 1부터 1까지 출력하는 문장을 작성 (초기화는 1)
        System.out.println("for문 출력");

        for (int num = 1; num <= 5; num++) { // (초기화; 조건; 증감)
            System.out.print(num);
        }

        // while 문으로 1부터 5까지 출력

        // 초기화식
        int num = 1;
        System.out.println();
        System.out.println("while문 출력");
        while (num <= 5) { // 조건식
            System.out.println(num);
            num++; // 증감식

        }

        // == 예제 (break, continue) == //
        // 0부터 20까지의 정수 중에서 홀수만 출력

        // 1) break
        // : 반복문 내에서 break; 키워드를 만나면 반복문 탈출 (종료)

        // 2) continue
        // : 반복문 내에서 continue; 키워드를 만나면 아래의 코드를 무시하고 다시 '조건 검사'로 돌아감

        System.out.println();
        // 초기화
        int number = 0;

        while (true) { // if문 & while문의 조건식은 결과값이 논리형(boolean)
            // : while문의 조건식을 true 값으로 고정하는 경우
            //      , 종료시점(break)을 개발자가 직접 명시하지 않으면 무한 루프(무한 루프 종료 ctrl + f2)
            // >> 프로그램의 과부화 방지를 위해 지양

            if (number % 2 == 0) {
                // 짝수
                number++; // 다음 수(홀수)를 위한 작업
                continue; // 조건식으로 다시 돌아감

            }

            System.out.println(number);
            number++; // 다음 수(짝수)를 위한 작업

            if (number == 20) break;


        }

        // cf) do-while문
        // : while문 차이점 - 코드가 반드시 한 번은 실행
        // : while문 공통점 - 초기화식 & 증감식이 분리

        System.out.println("do-while문 출력");
        /*
            do {

            } while (조건);
         */
        int doNum = 1;

        do {
            System.out.println(doNum);
            doNum++;
        } while (doNum <= 5);

        int a = 6;
        while (a < 5) {
            System.out.println(a);
        }

        do {
            System.out.println(doNum);
        } while (doNum <= 5);

        // == while VS do-while == //
        // 1) while문
        // : 조건 검사 시점 - 실행 전 검사
        // : 최소 실행 횟수 - X

        // 2) do-while문
        // : 조건 검사 시점 - 실행 후 검사
        // : 최소 실행 횟수 - 1번

        // == 예제 == //
        // : 사용자의 입력을 받아 1 ~ 10 사이의 숫자가 입력될 때까지 반복
        // :  do-while문으로 작성

        Scanner sc = new Scanner(System.in);

        int inputNumber;

        do {
            System.out.println("1부터 10 사이의 숫자를 입력하세요 :)");
            inputNumber = sc.nextInt();
        } while (inputNumber < 1 || inputNumber > 10); // 1 ~ 10 사이인 경우 반복문 종료

        System.out.println("올바른 숫자: " + inputNumber);

        //cf) while문은 반복 전에 조건을 검사하기 때문에, 초기 입력 코드를 반복문 밖에 따로 작성

        System.out.println("1 ~ 10 사이의 숫자를 입력하세요");
        inputNumber = sc.nextInt(); // 조건 검사 전 입력을 받기 위한 코드 중복 발생

        while (inputNumber < 1 || inputNumber > 10) {
            System.out.println("다시 입력하세요. (1 ~ 10)");
            inputNumber = sc.nextInt();
        }
    }
        }

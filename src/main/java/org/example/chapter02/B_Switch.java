package org.example.chapter02;

import java.util.Scanner;

public class B_Switch {
    public static void main(String[] args) {
        // === switch 조건문 === //
        // : 특정 변수의 값에 따라 실행할 코드 블록의 범위를 결정
        // : 비교할 변수와 case값을 비교하여 같은 값일 경우 해당 블록부터 끝까지 실행
        //      +) break 키워드에서 switch 문이 종료

        /*
            switch (조건변수) {
                case 조건값1:
                    실행문장;
                case 조건값2:
                    실행문장;
                case 조건값3:
                    실행문장;
                ...
                default:
                    case 조건식이 끝난 뒤 작성
                    >> 어느 case에도 일치하지 않을 경우 실행
            }

            >> full-through 상태
                : case 영역 내에서 break 키워드 없이 끝까지 실행되는 경우

         */

        Scanner sc = new Scanner(System.in);

        System.out.println("Chapter를 선택하세요 :)");
        int chapter = sc.nextInt();

        switch (chapter) {
            case 1:
                System.out.println("자바 기본문법");
                break; // 해당 case의 실행이 끝나면 switch 문을 빠져나옴
            // System.out.println("안녕"); - 해당 내용 출력 X
            case 2:
                System.out.println("자바 제어문 - 조건문/반복문");
                break;
            case 3:
                System.out.println("자바배열");
                break;
            default:
                System.out.println("유효한 chapter가 아닙니다.");
        }

        sc.nextLine(); // 개행문자(Enter)처리

        System.out.println("과일의 이름을 입력해주세요");
        String fruit = sc.nextLine();

        switch (fruit) {
            case "banana":
                System.out.println("노랑색");
                break;
            case "apple":
                System.out.println("빨간색");
                break;
            case "grape":
                System.out.println("보라색");
                break;
            default:
                System.out.println("유효한 과일이 아닙니다.");

        }

        sc.close();


        // === if문 VS switch문 === //
        // 1. if문
        // - 사용 대상: 범위 조건, 불리언
        // - 조건 개수: 복잡한 조건, 논리식 가능
        // - 사용 예시: 점수, 나이, 성별 등 범위 체크
        // >> 조건이 다양하거나 논리식이 필요한 경우
        int score = 85;
        if (score >=90) {
            System.out.println("우수한 성적입니다.");
        } else if (score >= 70) {
            System.out.println("평균적인 성적입니다.");
        } else {
            System.out.println("조금 더 노력해봅시다.");
        }

        // 2. switch문
        // - 사용 대상 : 정해진 값 비교
        // - 조건 개수: 하나의 변수만 다수 값과 비교
        // - 사용 예시: 메뉴 선택, 문자열 선택 등
        // >> 정확히 일치하는 값 비교할 경우

        String grade = "B";
        switch (grade) {
            case "A":
            case "B":
                System.out.println("우수한 성적입니다.");
                break; // A와 B 등급이 같은 경과를 출력. case문을 연달아 사용 가능
            case "C":
            case "D":
                System.out.println("평균적인 성적입니다.");
            default:
                System.out.println("조금 더 노력해봅시다.");
        }
    }
}

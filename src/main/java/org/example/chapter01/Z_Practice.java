package org.example.chapter01;

import java.util.Scanner;

public class Z_Practice {
    public static void main(String[] args) {
 /*
        === 복합 복습 문제: 성적 처리 프로그램 ===
        🔹요구사항
            사용자로부터 이름과 세 과목 점수를 입력받고
            , 총점, 평균, 합격 여부를 출력하는 프로그램을 작성하세요.

        🔸입력 예시 (Scanner 사용)
           이름: 김하늘
           국어 점수: 87
           영어 점수: 92
           수학 점수: 78

        🔸처리 조건
            총점 = 국어 + 영어 + 수학
            평균 = 총점 / 3.0
            합격여부 = 세 과목 모두 60점 이상이면 "합격", 아니면 "불합격"

        🔸 출력 예시
            [이름: 김하늘]
            총점: 257점
            평균: 85.7점
            판정: 합격
        */
        Scanner sc = new Scanner(System.in);

        System.out.print("이름 :");
        String name = sc.nextLine();

        System.out.println("국어점수: ");
        int korean = sc.nextInt();

        System.out.println("영어점수: ");
        int english = sc.nextInt();

        System.out.println("수학점수: ");
        int math = sc.nextInt();

        int total = korean + english + math;
        double average = total / 3.0;

        String result = (korean >= 60 && english >= 60 && math >= 60) ? "합격😊" : "불합격😢";

        System.out.println("[이름: " + name + "]");
        System.out.println("[총점: " + total + "점]");
        System.out.println("[평균: " + average + "점]");
        System.out.println("[합격 여부: " + result + "]");

    }
}
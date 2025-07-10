package org.example.chapter02;

import java.util.Scanner;

public class E_Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();

        // 점수에 따른 학점 판별
        if (score < 0 || score > 100) System.out.println("유효하지 않은 점수입니다.");
        else if (score >= 90) System.out.println("학점 A");
        else if (score >= 80) System.out.println("학점 B");
        else if (score >= 70) System.out.println("학점 C");
        else if (score >= 60) System.out.println("학점 D");
        else System.out.println("F");

        // 2) 별 찍기
        for (int i = 1; i <= 5; i++) {
            // i: 1 행 수(1행부터 5행까지 반복)
            for (int j = 1; j <= i; j++) {
                // 1행은 별을 1번 반복
                // 2행은 별을 2번 반복
                // ...
                // 5행은 별을 5번 반복
                System.out.print("*");
            }
            System.out.println(); // 줄을 바꿈 처리를 담당
        }

        /*
        2. (2)
            *
           **
          ***
         ****
        *****

        행은 1부터 5까지 반복 : i < rows; (조건)

        +) 공백은 4부터 0까지 -1씩 감소: rows - i(조건)
        +) 별은   1부터 5까지 +1씩 증가: 행을 초과하지 않도록 반복
         */

        int rows = 5; // 출력할 줄 수

        for (int i = 1; i <= rows; i++) {
            // 각 행의 반복
            // i: 1부터 5까지 반복
            for (int j = 1; j <= rows - i; j++) {
                // 공백 반복
                // j: 4부터 0까지의 수
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                //별의 반복
                // k: 1부터 5까지의 수
                if (k < 3) {
                    System.out.print("+");
                } else System.out.print("*");
            }
            System.out.println();
        }

        // 1행: i(1) / j(1~4) / k(1)
        // 2행: i(2) / j(1~3) / k(1~2)
        // .....
        // 5행: i(5) / j(0) / k(1~5)



        }
}

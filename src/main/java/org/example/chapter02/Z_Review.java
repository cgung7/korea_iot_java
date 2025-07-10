package org.example.chapter02;

public class Z_Review {
    public static void main(String[] args) {

        int rows = 5; // 출력할 줄 수

        for (int i = 1; i <= rows; i++) {
            // 각 행의 반복
            // i: 1부터 5까지 반복
            for (int j = 5; j >= rows - i; j--) {
                // 공백 반복
                // j: 4부터 0까지의 수
                System.out.print(" ");
            }
            for (int k = 5; k >= i; k--) {
                //별의 반복
                // k: 1부터 5까지의 수
                if (k < 3) {
                    System.out.print("+");
                } else System.out.print("*");
            }
            System.out.println();
        }

        int rows1 = 5; // 출력할 줄 수

        for (int i = 1; i <= rows1; i++) {
            // 각 행의 반복
            // i: 1부터 5까지 반복

            for (int k = 5; k >= i; k--) {
                //별의 반복
                // k: 1부터 5까지의 수
                System.out.print("*");

            }
            System.out.println();
        }

        int rows2 = 6; // 출력한 줄수

        for (int i =1; i <=rows2; i++) {

            for (int j = 6; j >= i; j--) {

                if (j % 2 == 0) {
                    System.out.print("*");
                } else {
                    System.out.print("=");
                }
            }
            System.out.println();
        }


    }
}
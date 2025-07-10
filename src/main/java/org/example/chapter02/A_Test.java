package org.example.chapter02;

import java.util.Scanner;

public class A_Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("x 값: ");
        int x = sc.nextInt();

        System.out.println("y 값: ");
        int y = sc.nextInt();

        if (x > 0 && y > 0) System.out.println("1사분면");
        else if (x < 0 && y > 0) System.out.println("2사분면");
        else if (x < 0 && y < 0) System.out.println("3사분면");
        else System.out.println("4사분면");

    }
}

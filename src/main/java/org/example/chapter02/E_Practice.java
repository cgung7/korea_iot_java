package org.example.chapter02;

import java.util.Scanner;

public class E_Practice {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.println("등급 확인");

        System.out.print("점수: ");
        int point = sc.nextInt();
        if (point >= 90) {
            System.out.println("A");

        } else if (point >= 80) {
            System.out.println("B");
        } else if (point >= 70) {
            System.out.println("C");
        } else if (point >= 60) {
            System.out.println("D");
        } else System.out.println("F");

        System.out.println();

        System.out.println("별 그리기");


            }
        }


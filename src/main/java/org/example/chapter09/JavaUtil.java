package org.example.chapter09;


// java.util 패키지
// : 자바에서 가장 많이 쓰이는 기능을 모아놓은 패키지
// - 컬렉선 프레임워크, 유틸리티(배열, 컬렉션 등), 날짜 및 시간 처리, 랜덤 값 생성, 입력기 등

import java.util.Random;
import java.util.Scanner;

public class JavaUtil {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.close();

                Random rendom = new Random();
        int num = rendom.nextInt();
        System.out.println(num);

        int num2 = rendom.nextInt(100);
        System.out.println(num2);

        int num3 = rendom.nextInt(101,200);
        System.out.println(num3);
    }
}

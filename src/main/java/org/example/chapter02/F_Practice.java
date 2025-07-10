package org.example.chapter02;

import java.util.Scanner;

public class F_Practice {
    public static void main(String[] args) {
        // 회원 관리 프로그램

        Scanner sc = new Scanner(System.in);

        boolean isRun = true;

        while (isRun) { // 무한 루프
            System.out.println("[ 메인 메뉴 ]");
            System.out.println("1. 회원 등록"); // 줄 복사 : ctrl + d
            System.out.println("2. 회원 조회");
            System.out.println("3. 회원 삭제");
            System.out.println("4. 회원 프로그램 종료");

            System.out.print("메뉴 선택: ");
            String selectedMenu = sc.nextLine();

            switch (selectedMenu) {
                case "1":
                    System.out.println("회원 등록이 아닙니다.");
                    break;
                case "2":
                    System.out.println("회원 조회 가능합니다.");

                    boolean isRun2 = true;

                    while (isRun2) {
                        System.out.println("[ 회원 조회");
                        System.out.println("[1. 회원 번호로 조회");
                        System.out.println("[2. 회원 이름으로 조회");
                        System.out.println("b. 뒤로가기"); // back: 뒤로가기;

                        selectedMenu = sc.nextLine();

                        switch (selectedMenu) {
                            case "1":
                                System.out.println(">> 번호로 회원을 조회합니다.");
                            case "2":
                                System.out.println(">> 이름으로 회원을 조회합니다.");
                            case "b":
                                System.out.println(">> 메인 메누로 돌아갑니다.");
                                isRun2 = false;
                                break;
                        }
                    }

                    break;
                case "3":
                    System.out.println("회원 살제 가능합니다.");
                    break;
                case "q": // quit: 그만두다, 중단하다
                    System.out.println("프로그램을 종료합니다.");
                    isRun = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력하세요 :)");
            }

        } // 첫 번째 while문 종료 시점
        sc.close();
        System.out.println("=== 시스템 종료 ===");
    }
}

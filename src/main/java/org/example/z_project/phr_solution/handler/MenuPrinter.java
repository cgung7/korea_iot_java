package org.example.z_project.phr_solution.handler;

public class MenuPrinter {
    public static void displayMenu() {
        System.out.println("\n[ \"메뉴\" 선택 ]");
        // cf) 이스케이프 문자 \
        // : 문자 제어 코드, 문자열 내에서 특수한 기능을 수행하는 문자
        // - 백슬래시(\)를 사용하여 표현
        // EX) \n(줄바꿈), \\(\기호 그 자체), \"( 기호 그 자체)

        System.out.println("1. 환자 등록");
        System.out.println("2. 환자 정보 전체 조회");
        System.out.println("3. 환자 정보 단건 조회");
        System.out.println("4. 환자 정보 수정");
        System.out.println("5. 환자 정보 삭제");

        System.out.println("6. 건강 기록 추가");
        System.out.println("7. 건강 기록 조회");
        System.out.println("8. 건강 기록 필터링");
        System.out.println("9. 건강 기록 삭제");

        System.out.println("10. 프로그램 종료");
        System.out.print("메뉴를 선택하세요 >> ");

    }
}

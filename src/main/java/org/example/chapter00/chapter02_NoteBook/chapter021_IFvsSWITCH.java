package org.example.chapter00.chapter02_NoteBook;

public class chapter021_IFvsSWITCH {
    public static void main(String[] args) {

        // === if문 VS switch문 === //
        // 1. if문
        // - 사용 대상: 범위 조건, 불리언
        // - 조건 개수: 복잡한 조건, 논리식 가능
        // - 사용 예시: 점수, 나이, 성별 등 범위 체크
        // >> 조건이 다양하거나 논리식이 필요한 경우
        int score = 85;
        if (score >= 90) {
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
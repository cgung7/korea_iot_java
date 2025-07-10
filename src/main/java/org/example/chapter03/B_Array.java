package org.example.chapter03;

public class B_Array {
    public static void main(String[] args) {
        // === 배열의 순회 === //
        int [] scores = { 85, 100, 90, 75, 90 };
        System.out.println("=== 안덱스 번호로 출력 ===");
        System.out.println(scores[0]);
        System.out.println(scores[2]);
        System.out.println(scores[4]);

        // 1) for문을 사용하여 순서대로 출력
        // : for의 초기화 변수를 인덱스 번호처럼 사용
        System.out.println("== for문 사용 ==");

        int scoresLength = scores.length;

        for (int i = 0; i < scoresLength; i++) {
            System.out.println(scores[i]);
        }

        // 2) 향상된 for문 (for each문)
        // : 배열의 순회(탐색)하는 방법
        // - for 문의 간결한 형태
        /*
            for (데이터 타입 변수명: 해당 데이터타입의 배열) {
                배열의 각 요소를 활용하는 코드
            }
         */

        System.out.println("== 향상된 for문(for-each문) ==");
        for (int score: scores) {
            // score 변수: for문의 반복에서 배열의 요소를 순차적으로 담는 변수
            System.out.println(score);
        }

        // == 배열 예제 == //
        // : 학생 점수의 평균을 계산
        // - 점수를 모두 더해서 점수의 개수만큼 나누기

        int total = 0; // 각 점수를 더해서 저장할 변수

        // 1) 일반 for문으로 합계
        int length = scores.length;

        // for (int i = 0; i < length; i++) {
        //     total += scores[i]; // total = total + scores[i];
        // }

        // 2) 향상된 for문(for-each)문을 사용하여 합계
        for (int score: scores) {
            total += score;
        }

        double average = total / length;
        System.out.println("평균점수: " + average);
    }
}

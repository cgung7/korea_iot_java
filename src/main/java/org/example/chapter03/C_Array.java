package org.example.chapter03;

public class C_Array {
    public static void main(String[] args) {
        // 다차원 배열
        // : 배열의 배열(배열 내의 요소가 배열)
        // : 2, 3, 4.... 차 배열
        // >> 데이터를 테이블 형태로 구성항 때 유용
        // >> 게임 보드, 데이터 분석, 그래픽 등에 사용

        // == 다차원 배열의 선언 및 초기화 == //
        // 2차원 배열 선언: 데이터타입[][] 배열명;
        // 2차원 배열 생성: new 데이터타입[행의개수][열의개수];
        int[][] matrix = new int[3][2];

        matrix[0][0] = 1; // 1행 1열
        matrix[0][1] = 2; // 1행 2열
        // matrix[0][2] = 3; // 1행 3열 - Array Index Out Bounds Exception

        // 선언과 동시에 초기화
        int[][] matrix2 = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        //다차원 배열 출력
        // : 각 행을 순회 + 해당 행 내부의 요소를 순회
        for (int[] row: matrix2) {
            for (int value: row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

    }
}

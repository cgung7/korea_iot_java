package org.example.chapter00.chapter02_NoteBook;

public class chapter02_switch {
    public static void main(String[] args) {

        // === switch 조건문 === //
        // : 특정 변수의 값에 따라 실행할 코드 블록의 범위를 결정
        // : 비교할 변수와 case값을 비교하여 같은 값일 경우 해당 블록부터 끝까지 실행
        //      +) break 키워드에서 switch 문이 종료

        /*
            switch (조건변수) {
                case 조건값1:
                    실행문장;
                case 조건값2:
                    실행문장;
                case 조건값3:
                    실행문장;
                ...
                default:
                    case 조건식이 끝난 뒤 작성
                    >> 어느 case에도 일치하지 않을 경우 실행
            }

            >> full-through 상태
                : case 영역 내에서 break 키워드 없이 끝까지 실행되는 경우

         */

        // 예제
        int chapter = 1;

        switch (chapter) {
            case 1:
                System.out.println("자바 기본문법");
                break; // 해당 case의 실행이 끝나면 switch 문을 빠져나옴
            // System.out.println("안녕"); - 해당 내용 출력 X
            case 2:
                System.out.println("자바 제어문 - 조건문/반복문");
                break;
            case 3:
                System.out.println("자바배열");
                break;
            default:
                System.out.println("유효한 chapter가 아닙니다.");
        }
    }
}

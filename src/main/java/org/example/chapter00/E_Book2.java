package org.example.chapter00;
class Student {
    String name;
    int score;

    private void StudentScore(String name, int score){
        this.name = name;
        this.score = score;
    }

    public void name() {
    }
    public void score() {

    }
}


public class E_Book2 {
    public static void main(String[] args) {
        Student student = new Student();
        student.name();
        student.score();

        // 자바 OOP
        // '클래스' == 객체 생성 뎀플릿(설계도)
        // - 필드, 메서드, 생성자

        // cf) 필드: 클래스의 특성이 담긴 속성이다.

        // == 메서드 == //
        /*

            반환타입의 메서명(매개 변수1, 매개 변수 2, ...) {
                - 메서드의 기능 동작 정의
                }

                1. 반환 타입의 유형
                : 매서드 동작 후 반환되는 데이터 유형을 지정
                - 반환 데이터가 없는경우 void 지정

                2. 메서드명
                : lowerCamelCase 사용, 동사 사용 권장
                cf) 변수명: 명사 사용 권장 (배열명: 복수 명사 사용 권장)

                3. 매개변수(parament) 목록
                : 메서드의 전달되는 입력값들의 목록
                - 0개 이상 지정 (지정하지 않을 수도 있음)
                - 각 매개변수는 변수의 선언과 같이 자료형과 함께 선언
                cf) 일반 변수 선언에서 쓰이는 동일한 데이터 타입의 생략 불가

               // return
               // : 메서드의 반환을 담당
               // - 반환타입과 일치하는 데이터를 동반
               // - void 타입이면 생략 가능 (쓰지않거나 return;으로 사용)
               // ex) void voidMethod() {
                        return;
                        }
         */



    }

}

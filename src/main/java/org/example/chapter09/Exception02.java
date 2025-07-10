package org.example.chapter09;

// == 자바 예외 처리 == //
// 1, try - catch 등록
// 2. throw, throw 키워드
// 3. 사용자 정의 예외

/*
    trr - catch 블록

    == 기본 형태 ==

    try {
        // 예외가 발생할 수 있는 코드
        // ...
        } catch('발생할 예외의 타입' '예외를 저장할 변수') {
            해당 예외 발생 시 실행할 코드
            } catch('발생할 예외의 타입' ' 예외를 저장할 변수') {
            해당 예외 발생 시 실행할 코드
            }

           cf) catch 블록
                : 특정 예외 타입이 발생했을 때 실행될 코드를 정의
 */

public class Exception02 {
    public static void main(String[] args) {
        // [ 컴파일 예외 ]
//        char c1 = 'abc';
//        System.out.println(a1);

//        int division = 10 / 0;
        // Exception in thread "main" java.lang.ArithmeticException: / by zero
        //	at org.example.chapter09.Exception02.main(Exception02.java:32)

        try {
            // 예외 발생 가능성 코드 작성
            int division = 10 / 0;
        } catch (ArithmeticException e) {
//            // 예외 변수명은 주로 e,  exception 등이 주로 사용
            System.out.println("0으로 정수를 나눌 수 없습니다.");
            System.out.println(e.getMessage());  // / by zero

            // cf) 예외 변수
            //  : try 블록 내의 예외에 대한 정보를 포함
            //  - 동일한 예외 타입 또는 해당 타입을 포함하는 타입일 경우
            //      , 발생된 예외를 자동으로 전달 받음
        }
        System.out.println("정상적인 실행");

        System.out.println("== 다중 catch 블록 실행");

        try {
            System.out.println(" 정상 실행 ");

            // 1)
            // int division = 10 / 0;
            System.out.println("위에서 예외가 발생할 경우 실행 X");

            // 2)
            int[] numbers = new int[5]; // new int[배열의크기]
            // numbers[10] = 50;

            // 3)
            String text = null;
            System.out.println(text.length()); // 문자열.length(): 문자열 길이를 반환


            System.out.println("위에서 예외가 발생할 경우 실행 X");
        } catch (ArithmeticException e) {
            System.out.println("수학 공식 예외: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 인덱스 초가 예외 " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("null 값 계산 예외: " + e.getMessage());
            // null 값 계산 예외: Cannot invoke "String.length()" because "text" is null
        } catch (Exception e) {
            // cf) Exception 클래스
            // : 자바 전체 예외의 최상위 클래스
            // - 예기치 못한 예외 발생 방지를 위해 세부적인 예외 작성의 마지막에 첨부
            System.out.println("초가 예외 발생: " + e.getMessage());
        } finally {
            // cf) 예외 발생 여부와 상관없이 항상 실행되는 코드블록
            System.out.println("finally 블록 - 항상 실행");
        }
    }
}

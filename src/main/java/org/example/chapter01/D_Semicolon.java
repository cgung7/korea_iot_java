package org.example.chapter01;

public class D_Semicolon {
    public static void main(String[] args) {
        // 세미 콜론(;) //

        // : 코드 명령어 단위를 한 줄에 한 문장씩 작성을 원칙으로 한다.
        // - 세미콜론은 문장의 끝마침을 의미
        // - 문장 종료 시 반드시 세미콜론 첨부

        int semi; int colon; // 사용금지(권장하지 않음) 추천 X

        //cf) 콤마(,)
        // : 같은 데이터타입의 변수 선언 시 콤마로 구분하여 동시 생성 가능
        int a;
        int b;
        int c;

        int aa, bb, cc; // aa bb cc 변수들은 각각 정수형태의 데이터를 담은 변수
        aa = 10;
        bb = 20;
        cc = 30; // 초기화는 개별적으로 해야한다.
    }
}

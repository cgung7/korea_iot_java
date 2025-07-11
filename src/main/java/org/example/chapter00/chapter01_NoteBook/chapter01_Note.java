package org.example.chapter00.chapter01_NoteBook;

// 자바 실행단계 //
// 1. 자바 소스 파일 (.java)
// : 고급언어(사람이 이해항 수 있는 언어)를 작성할 확장자 파일

// 2. javac (컴파일러)
// : 고급 언어를 저급 언어로 변환하는 기계(번역기)

// 3. 바이트 코드 파일 (.class)
// : 바이트 코드가 저장되는 위치
// : javac 컴파일러가 변환한 저급 언어가 저장

// 4. java 실행
// : JVM이 기계어(0, 1)로 번역 후 실행

public class chapter01_Note {
    public static void main(String[] args) {
        // main 메서드 선언
        // : 자바 프로그램 실행 시 "진입점"
        // : 자바 실행 시 JVM이 main 메서드를 찾아 실행

        // - 실행 단축기(shitf + f10)
        // 인텔리제이 단축기
        // 1. 자동완성 : ctrl + space
        // 2. 줄 복사 : ctrl + d
        // 3. 줄 삭제 : ctrl + y
        // 4. 전체 선택 : ctrl + a
        // 5. 줄 이동 : shift + alt + 방향키
        // 6. 들여쓰기/내여쓰기 : tab / shift + tab
        // 7. 코드 포맷 정리 : ctrl + alt + l
        // 8. 자동 임포트+정리 : ctrl + alt + o

        // 9. 실행 : shift + f10
        // 10. 프로젝트 구조 보기(왼쪽 창) : alt + 1



        // 세미 콜론(;) //

        // : 코드 명령어 단위를 한 줄에 한 문장씩 작성을 원칙으로 한다.
        // - 세미콜론은 문장의 끝마침을 의미
        // - 문장 종료 시 반드시 세미콜론 첨부

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

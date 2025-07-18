package org.example.chapter01;


// 자바 실행단계 //
// 1. 자바 소스 파일 (.java)
// : 고급언어(사람이 이해할 수 있는 언어)를 작성할 확장자 파일

// 2. javac (컴파일러)
// : 고급 언어를 저급 언어로 변환하는 기계(번역기)

// 3. 바이트 코드 파일 (.class)
// : 바이트 코드가 저장되는 위치
// : javac 컴파일러가 변환한 저급 언어가 저장

// 4. java 실행
// : JVM이 기계어(0, 1)로 번역 후 실행

public class A_Hello {
    // main 메서드 선언
    // : 자바 프로그램 실행 시 "진입점"
    // : 자바 실행 시 JVM이 main 메서드를 찾아 실행

    // - 실행 단축기(shitf + f10)
    public static void main(String[] args) {
        System.out.println("Hello Java!");
    }
}

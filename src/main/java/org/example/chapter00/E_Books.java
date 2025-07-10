package org.example.chapter00;

public class E_Books {
}
/*
    기본구조
| 단어          | 설명                      |
| ----------- | ----------------------- |
| `class`     | 객체의 설계도. 필드와 메서드를 가짐   | ==> chapter 04 참조
| `public`    | 누구나 접근 가능한 접근 제한자       |
| `private`   | 클래스 내부에서만 접근 가능         |
| `protected` | 같은 패키지 또는 상속 관계에서 접근 가능 |
| `static`    | 객체 생성 없이 사용 가능한 클래스 소속  |
| `void`      | 반환값이 없는 메서드를 의미         |
| `main`      | Java 프로그램의 시작점 메서드      | 항상 새로운 클래스 생성 후 기입 필
| `new`       | 객체(인스턴스) 생성 키워드         |


| 자료형       | 크기     | 기본값      | 설명                      | 예시         |
| --------- | ------ | -------- | --------------------          | ---------- |
| `int`     | 4 byte | 0        | 정수형, 가장 일반적으로 사용       | 10, -5     |
| `double`  | 8 byte | 0.0      | 실수형, 소수점 표현              | 3.14, -2.0 |
| `float`   | 4 byte | 0.0f     | 실수형, `f`를 붙여야 함          | 3.14f      |
| `long`    | 8 byte | 0L       | 더 큰 범위의 정수형              | 100000000L |
| `short`   | 2 byte | 0        | 작은 범위의 정수형               | 12000      |
| `byte`    | 1 byte | 0        | 아주 작은 범위 정수 (파일, 통신)   | 127, -128  |
| `char`    | 2 byte | '\u0000' | 문자형 (유니코드 기반)            | 'A', '한'   |
| `boolean` | 1 bit  | false    | 참(true)/거짓(false) 값         | true       |


*** 중요 ***

String은 대문자로 시작하고 클래스지만 거의 기본형처럼 쓰입니다.

char는 'A'처럼 작은 따옴표(' '), String은 "문자열"처럼 큰 따옴표(" ") 사용

float은 double보다 정밀도가 낮고, f를 꼭 붙여야 합니다.

boolean은 참/거짓만 표현 가능 (true, false) >> (0, 1 아님!)



| 단어                           | 설명               |
| --------------------------     | ---------------- |
| `if`, `else`, 'else if'        | 조건문              | chapter02 참조
| `switch`                       | 여러 조건 분기 처리      | >>> if와 혼란 주의
| `for`, `while`, `do while`     | 반복문              | chapter02 C_for, D_while 참조
| `break`                        | 반복문 강제 종료        |
| `continue`                     | 반복문의 다음 반복으로 건너뜀 |
| `return`                       | 메서드 종료 및 결과 반환   |


| 단어                   | 설명                  |
| -------------------- | ------------------- |
| `Scanner`            | 사용자 입력을 받기 위한 클래스   | Scanner sc = new Scnner(Sytem.in); chapter01- G_IO 참조
| `System.out.println` | 콘솔에 출력하는 명령         |  ==> sout
| `import`             | 외부 클래스나 패키지 불러오기    | import java.util.Scanner;
| `package`            | 클래스들을 그룹으로 묶는 이름 공간 |
| `try`, `catch`       | 예외 처리를 위한 구조        |


구분	              class	                       Array	                      Scanner

역할           데이터/행동 정의	        같은 타입 값 여러 개 저장	           사용자 입력 처리

정의 위치	     main() 밖	                 어디서든 가능	                주로 main() 안

메모리	         힙 (객체 기반)	            힙 (배열은 참조형)	                힙 (객체 기반)

특징         	설계도, 객체 기반	         고정 크기, 순차적 접근               입력 전용 기능 클래스

예시	            class Book {}	            int[] arr = ...	               Scanner sc = ...

 */
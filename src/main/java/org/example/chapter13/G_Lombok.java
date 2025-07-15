package org.example.chapter13;

// === 롬복(Lombok) 라이브러리  === //
// : 자바에서 반복적으로 작성해야하는 보일러플레이트(boilerplate) 코드를 줄여주는 라이브러리
// - 어노테이션(코드 주석)을 사용하여 코드를 간결하게 만들어주는 열할

// cf) 대표적인 보일러 플레이트 코드
// 보일러 플레이트 코드
// : 프로그래밍에서 반복되는 직업이나 패턴에 대한 일종의 표준화 된 코드
// - Getter / Setter
// - toString()
// - 생성자
// - 빌더 패턴

// == 라이브러리(Library) VS 프레임워크(Framework) == //
// 1) 라이브러리
// : 개발자가 만들어 낸 클래스들의 나열 (기능 모음)
// - 원하고자 하는 기능을 라이브러리 내에서 추출하여 사용
// >> 개발자가 라이브러리를 제어 (개발자가 호출)
// EX) Lombok, Gson, React

// 2) 플레임워크(틀 + 일하다)
// : 개발자가 따라야하는 가이드를 제공 (아키텍처 제공)
// >> 프레임워크가 개발자를 제어(프레임워크가 호출)
// EX) Spring, Django

// -- 롬복(Lombok) 환경 설정 == //
// cf) Java + Gradle 빌드도구 사용 프로젝트

// 1) build.gradle 파일에 롬복 추가

// +) Maven Repository
// : Java 프로젝트에 필요한 라이브러리(외부 코드)들을 쉽게 다운로드하고 관리할 수 있도록 도와주는 저장소
//      , Gradle에서도 사용

// 2) gradle 리로드(refresh)

// 3) 설정(빌드, 실행, 배포 > 컴파일러 > 어노테이션 처리 활성화)

// == 롬복(Lombok) 라이브러리 어노테이션 종류 == //
// 1. Getter/Setter
// : 필드에 대한 getter와 setter 메서드를 자동 생성

// 2. toString
// : 클래스의 toString() 메서드를 자동 구현
// - 객체 출력 시 지정된 형식으로 출력
// - 클래스명(필드명1 = 필드값1, 필드명2 = 필드값2, ... )

// 3. 생성자 어노테이션
// cf) 매개변수 parameter(params), 인자(인수) argument(args)

// 1) @NoArgsConstructor: 인자가 없는 생성자
// 2) @AllArgsConstructor: 모든 필드값을 인자로 가지는 생성자
// 3) @RequiredArgsConstructor: final 또는 @NonNull 어노테이션이 붙은 필드를 인자로 가지는 생성자

// 4) @Date 어노테이션
// : @Getter, @Setter, @ToString, @RequiredConstructor, @EqualsAndHashCode 어노테이션을 한 번에 적용하는 어노테이션

// cf) @EqualsAndHashCode
// : 두 객체의 내용이 같은지(동등성) 비교 & 두 객체가 같은 객체인지(동일성) 비교 연산자
// > boolean 값 반환

// 5) @Builder 어노테이션
// : 복잡한 객체 생성 시 사용하는 빌더 패턴을 자동으로 구현
// - 필드값을 모두 메서드 체이닝으로 가져옴 (필수값 또한 메서드 체이닝으로 구성)
// - 메서드 체이닝 이름은 필드명
// - 필수값을 체이닝에서 누락 시 오류

import lombok.*;

@Getter
@Setter
@ToString
// @NoArgsConstructor
@AllArgsConstructor // title, author, publisher
@RequiredArgsConstructor // title , author
@Builder
class LombokClass {
    private final String title;

    @NonNull
    // null 값이 들어갈 수 없음(필드에 필수값 지정)
    // : 값의 변화는 가능 (final 불변성과의 차이)
    private String author;

    private String publisher;

    // LombokClass(String title, String author) {} // 오버로딩 불가 (@RequiredArgsConstructor)
    // LombokClass(String title, String author , String publisher) {} // 오버로딩 불가 (@AllArgsConstructor)

    // @Getter / @Setter 메서드는 각 필드를 모두 생성
    // public String getTitle() { return title; }
    // public void setAuthor(String author) { this.author = author; }


}


public class G_Lombok {
    public static void main(String[] args) {
        LombokClass lombokClass1 = new LombokClass("자바는 재밌어","이승아","코리아");
        LombokClass lombokClass2 = new LombokClass("자바를 잡아","이도경");

        LombokClass lombokClass3 = new LombokClass.LombokClassBuilder()
                // @Builder에서 필수 체크 값 X
                // : Lombok이 내부에서 빌더 전용 생성자를 생성 초기화를 우회 (예외)
                .title("자바자바자바")
                // @Builder: @NonNull이 있는 필드에 대해 값을 할당 하지 않으면  NullPointerException 발생
                .author("조승범")
                .build();

        System.out.println(lombokClass1);
        System.out.println(lombokClass2);
        System.out.println(lombokClass3);

    }
}

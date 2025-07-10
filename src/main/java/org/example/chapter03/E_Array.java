package org.example.chapter03;

// === 자바 정적 배열 === //

// 장점)
// : 기본 데이터 타입 서용 가능 - int, char, boolean 등
// : 요소 접근 속도가 빠름 (인덱스 기반)

// 단점)
// : 한 번 생성돠면 크기 변경 X
// : 크기 변경이 필요한 경우, 변경된 크기의 배열을 생성하여 요소값을 복사

// (줄 바꿈 - alt + shift + 방향키)


import java.util.ArrayList;
import java.util.Arrays;

public class E_Array {
    public static void main(String[] args) {
        // 자바 정적 배열
        int[] numbers = new int[5];
        System.out.println(Arrays.toString(numbers));

        // == 자바 동적 배열 (ArrayList) == //
        // : Java의 동적배열 구현체 (내부적으로 배열을 사용하지만, 자동으로 크기 조절됨)
        // - 크기 제한 없이 동적으로 요소 추가 / 삭제 가능
        // - Java Collection Framework의 일부; 'java.util.ArrayList'에서 제공
        // 장점)
        //      크기 제한 X, 다양한 편의 매서드가 존재(add, remove, set 등)
        // 단점)
        //      기본 타입 사용 불가
        //      내부적으로 배열이므로, 중간 삽입 / 삭제 시 성능 저하 가능성

        // cf) ArrayList의 경우 기본 데이터 타입 사용 X
        // : 참조 데이터 타입만 가능 (Wrapper 클래스 사용)

        // cf) Wrapper 클래스
        // : 자바의 기본타입을 객체 형태로 감싸서 사용할 수 있도록 만든 클래스
        // - 기본값 null (아무런 주소값이 없음)
        // - int(Integer), char(Character) 외에는 시작 알파벳을 대문자로 사용

        Integer a = null;
        // int b = null;

        // === ArrayList 생성 === //
        // : ArrayList<데이터타입> 변수명 = new ArrayList<>(초기용량);

        // cf) 정적 배열: 초기용량 미지정 시 오류
        //      >> 실제 요소겂이라도 전달 (자동으로 인식)

        ArrayList<Integer> arrayList = new ArrayList<>();
        // : 초기 용량 미지정 시 - 기본값 10

        System.out.println(arrayList); // [] - 빈 배열 ( 기본값 또한 데이터가 없으면 사라짐)

        // 1. ArrayList 데이터 추가: 배열의 마지막에 값을 추가
        // > 배열명.add(추가할 데이터);
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        System.out.println(arrayList); // [ 10, 20, 30 ]
        // >> 내부 데이터를 확인하기 쉽게 문지열로 정리된 형태를 제공 toString() 재정의

        // 2. ArrayList 데이터 변경
        // - 배열명.set(인덱스번호, 변경할 데이터);
        arrayList.set(1, 50);
        System.out.println(arrayList); // [10. 50. 30 ]

        // 3. ArrayList 데이터 삭제
        // - 배열명.remove(인덱스번호);
        arrayList.remove(2);
        System.out.println(arrayList); // [ 10, 50 ]

        // 4. ArrayList 크기 확인
        // - 배열명.size();
        System.out.println(arrayList.size()); // 2

        // cf) 정적배열.length;

        // +) ArrayList.add(인덱스번호, 데이터값);
        //      >> 원하는 위치에 데이터 삽입
        arrayList.add(1, 123); // 그냥 () 내부 숫자만 작성 *영어 수기작성 X - 자동완성)
        System.out.println(arrayList); // [ 10, 123, 50 ]

        // +) 특정 요소 접근
        //      >> 배열명.get(인덱스번호)
        System.out.println(arrayList.get(1)); // 123

        //          [ 정적 배열 ]       VS        [ 동적 배열 ]
        //  크기 :       고정                       자동 조절
        //  타입 :   기본 타입 가능                참조 타입만 가능
        //  속도 :       빠름                     상대적으로 느림
        //  유연성 :      낮음                         높음
        //  기능 :    저장 + 조회              저장, 수정, 삭제, 삽입 등

    }
}

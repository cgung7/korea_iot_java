// === 패키지 === //
// : 폴더 (파일 분리 저장소)
package org.example.chapter03;

// === 클래스 === //
// : 파일 (코드 저장소)
// : 한 개의 .java 자바 파일에는 하나의 클래스가 포함(파일명과 동일)
// - 모든 코드가 클래스 안에 동작
public class A_Array { // 클래스명 == 파일명 (파일명은 대문자로 시작 + UpperCamelCase 사용)
    // 코드 작성

    // == 메인 메서드 == //
    // : 프로그램 실행의 시작점
    public static void main(String[] args) {
        // === 배열 (Array) === //
        // : '같은 타입'의 '여러 변수'를 하나의 집합으로 묶어서 처리하는 구조
        // : 데이터를 '연속적으로' 저장
        // - 순서 0 (index 인덱스 번호 - 0부터 시작하여 1씩 증가되는 값)
        // - 중복 0 (동일한 값을 여러 요소에 저장 가능)

        // cf) 요소: 배열에서 각각의 데이터를 의미

        // 1) 변수를 사용하여 각 학생의 각 과목의 성적을 저장
        int korean1 = 80;
        int math1 = 95;
        int english1 = 85;

        // 2) 배열
        // : 사용하고자 하는 공간을 생성하여 사용
        // cf) Scanner 생상과 유사
        // - new 연산자 사용

        // === 배열의 선언 (좌항) === //
        // : 생성한 배열을 담을 그릇
        // >> 데이터타입[] 배열명; (권장 = 필수)
        // >> 데이터타입 배열명[];
        int[] scores1;
        // int scores[]1;

        // cf) 배열명: 복수 형태의 변수명 사용 권장 -s

        // === 배열의 생성 (우항) === //
        // >> new 데이터타입[배열의 길이];
        scores1 = new int[3]; // 요소의 개수가 3개인 배열을 생성

        System.out.println(scores1); // [I@2f92e0f4

        // cf) 참조 자료형 - 주소값이 저장
        // : 데이터 배열이 저장된 첫 번째 메모리 주소가 저장 ( 인덱스번호 0번의 주소)

        // === 배열 요소에 접근 === //
        // : 배열명[인덱스 번호]
        System.out.println(scores1[0]); // 0
        System.out.println(scores1[1]); // 0
        System.out.println(scores1[2]); // 0

        // cf) 배열 생성 시 모든 요소는 해당 데이터 타입의 기본값으로 초기화
        // >> 숫자(0), 문자열(" "), 논리형(false)


        // 배열의 요소에 접근하여 데이터 변경(삽입)
        scores1[0] = 80;
        scores1[1] = 90;
        scores1[2] = 85; // 전체 요소의 개수 - 1 == 마지막 인덱스 번호

        System.out.println(scores1[0]); // 80
        System.out.println(scores1[1]); // 90
        System.out.println(scores1[2]); // 85
        // System.out.println(scores1[3]); // Array Index Out Of Bounds Exception
        // : 배열의 크기값을 초과할 경우 접근 불가, 예외 발생

        // 1) 배열의 선언: int[] number;
        // 2) 배열의 생성: number = new int[ ];
        // 3) 배열의 초기화: 각각의 인덱스 번호를 사용하여 데이터 삽입

        // == 배열의 선언과 동시에 초기화 == //
        // : new 연산자 사용 + 직접적으로 요소를 대입하여 배열 생성 시 길이 지정 X
        // >> 요소의 개수를 파악하여 길이가 자동 지정

        // 1) 데이터타입[] 배열명 = new 데이터타입[] {요소1, 요소2, 요소......};
        int[] number1 = new int[] { 1, 2, 3, 4, 5 };
        System.out.println(number1[0]);

        // 2) 데이터타입[] 배열명 = {요소1, 요소2, 요소......};
        char[] greet = { 'h', 'e', 'l', 'l', 'o' }; // 동일한 데이터 중복 저장 가능
        System.out.print(greet[0]);
        System.out.print(greet[1]);
        System.out.print(greet[2]);
        System.out.print(greet[3]);
        System.out.print(greet[4]); // hello
        System.out.println();

        // == 배열의 크기(길이) == //
        // 배열명.length 속성으로 사용
        System.out.println(greet.length); // 5

        // cf) (변수명 || 데이터타입)에 마침표. 을 사용하는 기능
        //      >> 해당 데이터 타입 내에 내장된 자바 기능을 활용

        // == 배열의 특징 == //
        // > 한 번 생성되면 크기 변경 X
        // > 참조 타입: 주소값이 저장
        // > 모든 요소는 같은 자료형

        // cf) 참조 자료형의 출력
        // : 자바에서 '객체를' sout으로 출력하면 내부적으로 객체.toString() 기능을 호출
        // > 모든 참조 자료형의 집합체
        String a = "안녕!";
        System.out.println(a);
        System.out.println(a.toString()); // toString(): 문자열'로'
        // >> String은 내부족으로 toString() 호출 시 실제 데이터값 자체를 반환하도록 설정
        // >> 배열, 객체는 toString(): 주소값을 문자열로 출력해라

        int[] arr1 = { 1, 2 ,3 };
        char[] arr2 = { 'a', 'b' ,'c' };
        System.out.println(arr1); // [I@28a418fc
        System.out.println(arr2); // abc - char는 문자열처럼 자동 처리

        // [I@28a418fc
        // [: 배열
        // I: 배열의 원소 타입 (int 배열)
        // @: 구분자
        // 28a418fc: 해시코드의 16진수 표현
        //              >> 해시코드: 객체를 식별하는 데 사용되는 정수값

        // == 문자열 배열 생성 == //
        // : String(참조 자료형)을 요소값으로 사용
        // >> 초기값이 null

        String[] fruits = new String[3];
        System.out.println(fruits); // [Ljava.lang.String;@5305068a
        System.out.println(fruits[0]); // null

        fruits[0] = "사과";
        fruits[1] = "오렌지";
        System.out.println(fruits[0]); // 사과
        System.out.println(fruits[1]); // 오렌지

        // == 배열 요소 삭제 == //
        // : 삭제 기능을 담당하는 문법 X
        // > 삭제할 요소를 제외한 나머지 요소를 '새로운 배열'로 복사(옮기기)

        int[] original = { 1, 2, 3, 4, }; // 길이 4
        int removeIndex = 2; // 제거할 요소의 인덱스 번호

        int[] newArray = new int[original.length - 1]; // 길이 3

        int k = 0; // 새로운 배열의 인덱스 번호

        for (int index = 0; index < original.length; index++) {
            // 배열 요소의 개수(길이)만큼 반복
            // for 문 내에서 반복 중 removeIndex와 index 번호가 일치하는 겅우
            // : 해당 index 번호값은 새로은 배열에 할당하지 않고 다음 조건으로 이동
            if (index == removeIndex) {
                continue;
            }
            newArray[k++] = original[index];
            // k, index
            // newArray[0] = original[0]
            // newArray[1] = original[1]
            // newArray[2] = original[3]
        }
        System.out.println(newArray[0]); // 1
        System.out.println(newArray[1]); // 2
        System.out.println(newArray[2]); // 4
    }
}

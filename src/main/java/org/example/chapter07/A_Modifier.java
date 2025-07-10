package org.example.chapter07;

// cf) 자바 패키지 또는 클래스 파일 간의 코드 연결
// : import 문을 사용

// 1) 같은 패키지 내: import 클래스파일명;
// 2) 다른 패키지 내: import 패키지경로.패키지명.클래스파일명;
//import org.example.otherPackage.OtherClass;
//import org.example.otherPackage.PublicClass;

import org.example.otherPackage.*;
// : * 기호는 전체를 의미한다
// - 다만, 프로그램의 향상성을 위해 권장하지 않음

// == 접근제한자(제어자) == //
// : 클래서, 변수, 메서드의 접근 범위를 제어
// - 외부로부터 데이터를 보호, 객체 간의 의존성을 최소화하는 역할
// - 코드의 보안성을 향상, 캡슐화 구현

// 1. 접근 제어자 종류
// : public, (default), protected, private
// - 생략 시 default 값 지정

// cf) default class DefaultClass {} - default 키워드를 직접 명시 X

// cf) 클래스 자제에 접근 제어자 사용 X
//      : 중첩된 클래스가 이닌 경우 명시적인 접근제어자 사용 불가
//      >> 클래스 파일의 경우 작성 가능하다.



// protected clas ProtectedClass {} - 클래스 자체에 사용 불가 (중첩클래스만 가능)
class Modifier {}

// 2. 접근 제어자 범위
// public > protected > (default) > private

// 1) private
// : 같은 클래스 내에서만 접근 가능
class PrivateClass {
    private int myField;
    private void myMethod() {
        System.out.println(myField);;
    }
}

// 2) (default)
// : 같은 패키지 내라면 접근 가능 (폴더 단위)
// - 패키지 외부에서는 접근 불가
class DefaultClass {
    int myField;
    void myMethod() {
        System.out.println(myField);
    } // 필드와 메서드 앞에 (default)가 생략
}

// 3) protected
// : 동일한 패키지 내의 모든 클래스에서 접근 가능 (default와 동일)
// : 다른 패키지에 있는 경우, 해당 클래스를 상속받은 하위 클래스에서만 접근 가능
class ProtectedClass extends OtherClass {

    //String otherField;

    ProtectedClass() {
        // 상속

        System.out.println(otherField);
        otherMethod();
    }
}



public class A_Modifier {
    public static void main(String[] args) {
        // PrivateClass 외부에서 private 필드에 접근
        PrivateClass privateClass = new PrivateClass();
//        privateClass.myField; // 'myField'이(가) 'org.example.chapter07.PrivateClass'에서 private 액세스를 가집니다
//        privateClass.myMethod;
        // : 접근 제어자는 가시성을 나타냄
        // - private는 해당 클래스 내부에서만 접근 가능

        DefaultClass defaultClass = new DefaultClass();
        System.out.println(defaultClass.myField); // int 타입의 초기화값은 0이다
        defaultClass.myField = 10;
        defaultClass.myMethod(); // 10

        ProtectedClass protectedClass = new ProtectedClass();
        // protectedClass. myField; - A_Modifier 클래스에서 상속받지 않았기 때문에 접근 불가

        PublicClass publicClass = new PublicClass();
        System.out.println(publicClass.publicField);
        publicClass.publicMethod();

    }
}

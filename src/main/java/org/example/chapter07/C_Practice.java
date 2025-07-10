package org.example.chapter07;

import org.example.otherPackage.OtherClass;

// 접근 제어자 확장
// : protected 접근제어자로 선언된 메서드를 자식 클래스에서 오버라이팅(재정의)
// >> 접근제어자 수정이 가능한지 여부를 확인
// >> 접근제어자는 같거나 더 넓게만 가능
class PracticeParent {
    protected void greet() {
        System.out.println("Hello Parent");
    }
}

class PracticeChild extends PracticeParent {
    // 오버라이딩 단축기 : ctrl + o

//    @Override
//    protected void greet() {
//        super.greet();
//    }

    //재정의한 메서드는 무조가 가진 메서드의 범위를 축소시킬 수 없다/
    @Override
    public void greet() { // protected >> public 가능
        super.greet();
    } // 오버라이딩 안에 super ==> "오버라이딩을 하되, 부모의 기능을 그대로 사용하려고 super를 호출한 것"

//    @Override
//    private void greet() { >> 기존의 접근제어자보다 축소 될수 없음
//        super.greet();
//    } // 오버라이딩 안에 super ==> "오버라이딩을 하되, 부모의 기능을 그대로 사용하려고 super를 호출한 것"
}

//OtherClass 내부에 protected 필드와 메서드를 포함
public class C_Practice extends OtherClass {

    void exampleMethod() {
        // 자식 클래스 안에서 직접적인 접근만 가능
        // this.필드명; (this 생략가능)
        System.out.println(otherField);
        System.out.println(this.otherField);
        otherMethod();
    }

    public static void main(String[] args) {
        OtherClass otherClass = new OtherClass(); // 부모클래스의 인스턴스 생성
//        otherClass.otherField;
//        otherClass.otherMethod(); - protected 제한자

    }
}

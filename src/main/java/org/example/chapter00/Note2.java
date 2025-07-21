package org.example.chapter00;


/// 상속 + Overriding
/// static 메서드
public class Note2 {
    public static class Parent {
        public int x(int i) { return i + 2; } // x는 i의 변수명을 지정이 되어있고, 출력값은 i값에 2를 더해 반환해서 출력된다
        /// cf) static 메서드의 오버라이딩
        ///         : 정적 메서드는 오버라이딩 되지 않고, 참조 변수의 타입 기준으로 호출
        public static String id() { return "P"; } //id는 P값을 반환해서 출력
    }

    public static class Child extends Parent { // Child는 Parent 에 상속(부모/자녀)관계
        public int x(int i) { return i + 3; } //
        public String x(String s) { return  s + "R"; }
        public static String id() { return "C"; }
    }

    public static void main(String[] args) {
        /// ref 인스턴스 - 업캐스팅 (Parent 타입이지만 실제 인스턴스는 Child)
        Parent ref = new Child();

        /// ref.x(2) == 5; ref의 실질적인 타입은 Parent(업캐스팅) - 부모의 Parent.id() 호출 == P
        System.out.println(ref.x(2) + ref.id());

        /// 인스턴스 메서드는 동적 바인딩 - 실제 객체의 행위를 동작
        /// 정적 메서드는 정적 바인딩 - 참조 인스턴스의 타입이 가진 행위를 동작
    }

}

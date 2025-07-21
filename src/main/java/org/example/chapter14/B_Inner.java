package org.example.chapter14;

import lombok.AllArgsConstructor;
import lombok.Getter;

// == 학교 시스템 == //
@Getter
@AllArgsConstructor // 모든 필드를 생성자의 매개변수로 전달 받아 필드의 초기값으로 지정
class School {
    private String schoolName;

    // (비정적) 내부 클래스 - 학생
    @AllArgsConstructor
    class Student {
        private int studentId;
        private String studentName;

        public void displayInfo() {
            System.out.println("학교명: " + schoolName + ", 학생 이름: " + studentName);
        }

    }

    // 정적 내부 클래스 - 교장 선생님(싱글톤 패턴)
    static class Principal {
        private static Principal instance;

        private Principal() {}

        public static Principal getInstance() {
            if (instance == null) {
                instance = new Principal();
            }
            return instance;
        }

        public void displayInfo() {
            System.out.println("훈회 말씀: 공부 열심히! 밥 잘 먹고! 일찍 자고! 일찍 일어나기!");
        }
    }
}

public class B_Inner {
    public static void main(String[] args) {
        School school = new School("유성초등학교");

        // @롬복 어노테이션 생성자
        // : 필드값 순서대로 매개변수 값을 설정 - 타입 유의!!
        School.Student student1 = school.new Student(43,"이승아");
        student1.displayInfo();

        // Principal 클래스
        // getInstance() 내부의 new 연산자가 사용으로 new 키워드 생략 (일반 static 메서드 호출)
        School.Principal principal = School.Principal.getInstance();

        principal.displayInfo();
    }
}

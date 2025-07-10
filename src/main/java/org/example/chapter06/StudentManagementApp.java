package org.example.chapter06;

// 학생 관리 시스템

import java.util.ArrayList;

// 1. 학생 클래스 정의
// : 학생 정보 저장, 관련 메서드 제공

// class 선언 Student
class Student {
    // === 필드 === //
    int studentId; // 변수명 선언 studentId - 학생의 아이디
    String name; // 변수명 선언 name - 학생의 이름
    int age; // 변수명 선언 age - 학생의 나이
    String major; // 변수명 선언 - 학생의 과
    Double gpa; // 변수명 선언 - 학생의 점수

    // === 메서드 === //
    // class 선언 중 기능 추가
    void printStudentInfo() { // void는 입력과 출력만 가능하다 - 행동만 지시만 하는 입력값,
                              // () 빈 이유: 전달 받지 않고 실행하고자 하기 위해 공란(입력값이 없다)
        System.out.println("ID: " + studentId
        + ", Name: " + name
        + ", Age: " + age
        + ", Major: " + major
        + ", GPA: " + gpa
        );
        // 학생의 정보 출력(printStudentInfo)만 단순 출력기능 추가

    }
    // class 선언 중 기능 추가
    void updateGpa (double newGpa) {
        this.gpa = newGpa;
        // 학생의 학점을 실시간으로 갱신 할 때 사용 그러므로 ()안에 double newGpa가 추가됨으로 프로그램에 알려주는 역할
        // this.gpa << 현재의 학점에 갱신 = newGpa << 새 학점을 //항상 = 는 오른쪽에서 왼쪽으로 읽기
}
// === 생성자 === //
    Student() {
        // 필드값 초기화: 초기화 함으로서, 출력하고자 하는 내용을 명확히 넣어주기 위해서 작성하는 것 / test?
        this.studentId = 0;
        this.name = "Unknown";
        this.age = 20;
        this.major = "Undeclared";
        this.gpa = 0-.0;
    }

    Student(int studentId, String name, int age, String major, double gpa) {
        // 생성자 Student 생성(전달받고자 하는 내용 작성: 학생의 ID,  학생의 이름, 학생의 나이, 학생의 전공, 학생의 학점)
        this.studentId = studentId; // 현재의 학점을 대입
        this.name = name; // 현재의 이름을 대입
        this.age = age; // 현재의 나이를 대입
        this.major = major; // 현재의 전공을 대입
        this.gpa =gpa; // 현재의 학점에 대입
    }

    Student(int studentId, String name, int age) {
        // 다른 생성자 - 학과 major, 학점 gpa를 제외한 자료를 출력하고자 작성
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }

}
// 2. 학생 관리 시스템 클래스 정의
// : 메인 클래스(실행)
// : 학생 등록, 조회, 수정 가능 담당
public class StudentManagementApp {

    // cf) Java 클래스명은 파일명과 동일(대소문자 까지)
    //      : 하나의 파일에서 public 단위의 클래스는 한 개만 지정 가능
    //      >> public class 클래스명은 파일명과 일치

    // cf) static: 모든 객체에게 공유하고자 하는 클래스 변수**
    //      : 인스턴스화 없이 클래스 자체에서 직접 호출
    //      - main 메서드 내부에서 다른 메서드 호출 시 반드시 해당 메서드는 static 이어야한다. **
    // static 공유값이 필요하기 때문에 사용
    static  ArrayList<Student> students = new ArrayList<>();
    // ArrayList<>: 여러자료를 받기 위한 자료 구조<학생>
    // 사용이유: 학생 전체 목록을 어디서나 접근하고 관리할 수 있도록 하기 위해


    // 학생 등록 공유값이 필요한(static) 출력(void) (아이디, 이름, 나이, 학과, 학점)
    static void addStudent(int id, String name, int age, String major, double gpa) {
        Student student = new Student(id, name, age, major, gpa);
        // 새로운 객체(new Student)를 만들어서 거기에(기존 Student) 정보들을 "초기화"
        students.add(student); // .add(리스트의 요소 타입과 일치한 데이터만 삽입 가능
        System.out.println(name + " 학생이 등록되었습니다.");
    }

    // 학생 조회 (전체)
    static void printAllStudents() {
        System.out.println("== 전체 학생 목록 ==");
        // for (순회 하는 요소의 변수 선언: 배열리스트) {}
        for (Student student: students) {
            student.printStudentInfo();
        } //
    }

    // 학생 검색: 학생 ID를 통해 학생의 정보를 출력

    static void findStudentById(int studentId) {
        for (Student student: students) {
            if (student.studentId == studentId) {
                student.printStudentInfo();
                return; // 메서드 종료
            }
        }

        System.out.println(studentId + " 해당 ID의 학생을 찾을 수 없습니다.");
    }

    // 평균 학점 업데이트: 학생 ID를 사용하여 해당 학생의 평점을 업데이트

    static void updateStudentGpa(int studentId, double newGpa) {
        for (Student student: students) {
            if (student.studentId == studentId) {
                student.updateGpa(newGpa);
                System.out.println("평점이 업데이트 되었어요.");
                return;
            }
        }
        System.out.println(studentId + " 해당 ID의 학생을 찾을 수 없습니다.");
    }

    // main 메서드
    // : 프로그램 진입점을 제공
    // > public static void main(String[] args) 형식이어야만 실행 가능
    // > JVM은 main 메서드가 ㅇ벗을 경우 해당 파일을 실행 x
    public static void main(String[] args) {

        // 학생 추가
        addStudent(1, "김보민", 20, "IoT", 3.8);
        addStudent(2, "박진영", 21, "IoT", 3.9);
        addStudent(3, "오신혁", 22, "IoT", 3.7);
        addStudent(4, "김세훈", 23, "IoT", 3.8);

        // 학생 전체 조회
        printAllStudents();
        System.out.println();

        // 학생 조회(단건)
        System.out.println("== 학생 조회 결과 ==");
        findStudentById(1);
        findStudentById(3);
        System.out.println();

        // 학생 평점 업데이트
        updateStudentGpa(2,4.1);
        updateStudentGpa(4,4.5);
    }
}

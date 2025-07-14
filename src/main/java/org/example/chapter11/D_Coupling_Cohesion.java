package org.example.chapter11;

/*
    === 결합도(Coupling) VS 응집도(Cohesion) ===

    cf) 모듈(Module)
            : 소프트웨어를 각 기능별로 나눈 소스단위
            +) 모듈화: 하나의 큰 소프트웨어를 분리시키는 과정

    "좋은 소프트웨어 일수록 모듈의 독립성이 높다"
    >> 모듈의 독립성을 결합도(coupling)와 응집도(cohesion)의 기준 단계로 측정

    1. 결합도(낮은 결합도)
            : 두 개의 클래스나 모듈이 얼마나 강하게 연결되어 있는지 나타냄
            >> 모듈과 모듈 간의 의존도

        - 낮은 결합도: 두 모듈이 서로 독립적으로 동작
        - 높은 결합도: 두 모듈이 서로 얽혀져 동작

        >> 낮은 결합도
            : 프로그램 유지보수에 용이
            - 새로운 기능을 추가하거나 기존 코드 수정 시 오류 가능성을 낮춤

    2. 응집도(높은 응집도)
            : 하나의 클래스나 모듈 안에서 관련된 작업들끼리 얼마나 잘 모여 있는지를 나타냄
            >> 한 모듈 내의 구성요소들 언관성

        - 낮은 응집도: 하나의 클래스가 너무 많은 일을 하거나, 관련없는 일을 하는 것
        - 높은 응집도: 하나의 클래스가 관련된 일들만 하고, 해당 일이 잘 명시

        >> 높은 응집도
            : 프로그램에 대한 이해, 유지보수에 용이

    == 결합도와 응집도의 관계 ==
    : 낮은 결합도 + 높은 응집도
        >> 각 클래스나 모듈이 독립적으로 동작 + 본인의 역할에 충실
        >> 클래스 간의 의존성을 줄이고, 변경에 강한 구조를 작성
 */

// 1) 낮은 경합도
interface Teacher {
    void teach();
}

class KoreanTeacher implements Teacher {
    @Override
    public void teach() {
        System.out.println("국어 선생님은 국어를 가르칩니다.");
    }
}

class MathTeacher implements Teacher {
    @Override
    public void teach() {
        System.out.println("수학 선생님은 수학을 가르칩니다.");
    }
}

class ClassRoom {
    private Teacher teacher; // 인터페이스 타입으로 선언 - 의존 역전 원칙

    // 의존성 주입(Dependency Injection)
    // : 클래스가 직접 객체를 생성X, 외부에서 객체를 주입받도록 설계
    // - 객체 간의 강한 결합을 줄이고, 변경에 유연
    public ClassRoom(Teacher teacher) {
        this.teacher = teacher;
    }

    public void startClass() {
        teacher.teach();
    }
}

// 2) 높은 응집도
class StudentCohesion {
    // 학생은 공부의 기능만 담당
    private String name;

    public StudentCohesion(String name) {
        this.name = name;
    }

    public String getName() { return name; }
}

class Attendance {
    // 출석부는 출석 체크 기능만 담당
    public void checkAttendance(Teacher teacher, StudentCohesion studentCohesion) {
        System.out.println(studentCohesion.getName() + " 학생이 출석하였습니다.");
        teacher.teach();
    }
}


public class D_Coupling_Cohesion {
    public static void main(String[] args) {
        Teacher koreanTeacher = new KoreanTeacher();
        Teacher mathTeacher = new MathTeacher();

        ClassRoom koreanClass = new ClassRoom(koreanTeacher);
        ClassRoom mathClass = new ClassRoom(mathTeacher);

        StudentCohesion stdent = new StudentCohesion("이승아");
        Attendance attendance = new Attendance();
        attendance.checkAttendance(mathTeacher,stdent);
    }
}

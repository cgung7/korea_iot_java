package org.example.chapter14;

// == 성적 계산 프로그램 == //

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class Student {
    private String nama;
    private int score;
}

// 인터페이스 - 성적 계산기
interface Grading {
    String calculateGrade(Student student);
}

public class C_Anonymous {
    public static void main(String[] args) {
        Student student1 = new Student("조승범",90);
        Student student2 = new Student("이승아",95);
        Student student3 = new Student("윤대휘",80);
        Student student4 = new Student("박성욱",85);
        Student student5 = new Student("김소빈",70);

        Student[] students = { student1, student2, student3, student4, student5 };

        Grading grading = new Grading() {
            @Override
            public String calculateGrade(Student student) {

                int score = student.getScore();

                if (score>100 || score<0) {
                    System.out.println("잘못된 점수입니다.");
                    return null;
                } else if (score>= 90 ){
                    return "A";
                }else if (score>= 80 ){
                    return "B";
                } else if (score>= 70 ){
                    return "C";
                } else if (score>= 60 ){
                    return "D";
                } else {
                    return "F";
                }
            }
        };

        for (Student s: students) {
            String grade = grading.calculateGrade(s);

            if (grade != null) {
                System.out.println(s.getNama() + "의 성적: " + grade);
            }
        }

    }
}

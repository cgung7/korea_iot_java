package org.example.chapter00.practice01;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class MiddleSchool {
    private int studentGrade;
    private int studentNumber;
    private String mStudentName;
    private int score;

        public void displayInfo() {
            System.out.println(studentGrade + "학년 학번: " + studentNumber + " 이름: " + mStudentName + " 점수 : " + score + "점");
        }

        interface Grading {
            String calculateGrade(MiddleSchool middleSchool);

    }
}

public class Note4 {
    public static void main(String[] args) {
        MiddleSchool middleSchool1 = new MiddleSchool(3,31,"이승아",90);
        MiddleSchool middleSchool2 = new MiddleSchool(2,25,"조승범",85);
        MiddleSchool middleSchool3 = new MiddleSchool(1,31,"이승찬",50);
        MiddleSchool middleSchool4 = new MiddleSchool(3,30,"하니",65);

        MiddleSchool[] middleSchools = { middleSchool1, middleSchool2, middleSchool3, middleSchool4 };

        MiddleSchool.Grading grading = new MiddleSchool.Grading() {
            @Override
            public String calculateGrade(MiddleSchool middleSchool) {

                int score = middleSchool.getScore();

                if (score > 100 || score < 0 ) {
                    System.out.println("잘못된 점수입니다.");
                    return null;
                } else if (score >= 90) {
                    return "A";
                } else if (score >= 80) {
                    return "B";
                } else if (score >= 70) {
                    return "C";
                } else if (score >= 60) {
                    return "D";
                } else {
                    return "F";
                }

            }
        };

        middleSchool1.displayInfo();
        middleSchool2.displayInfo();
        middleSchool3.displayInfo();
        middleSchool4.displayInfo();


        for (MiddleSchool s: middleSchools) {
            String grade = grading.calculateGrade(s);

            if (grade != null) {
                System.out.println(s.getMStudentName() + "의 성적: " + grade);
            }
        }



    }
}

package org.example.chapter12.model;

import java.time.LocalDateTime;

public class Student {
    private int studentId;
    private String name;
    private int age;
    private String studentNumber;
    private LocalDateTime createdAt;

    public Student(int studentId, String name, int age, String studentNumber) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.studentNumber = studentNumber;
        this.createdAt = LocalDateTime.now();
    }

    //Getter
    public int getStudentId() { return studentId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getStudentNumber() { return studentNumber; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    //Setter: 수정가능할 정보를 setter(이름, 나이)
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "Student{ " +
                "ID: " + studentId +
                ", 이름: " + name +
                ", 나이: " + age +
                ", 학번: " + studentNumber +
                ", 생성일: " + createdAt + " }";
    }
}


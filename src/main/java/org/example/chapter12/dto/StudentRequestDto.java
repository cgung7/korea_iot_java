package org.example.chapter12.dto;

import java.time.LocalDateTime;

public class StudentRequestDto {
    private String name;
    private int age;
    private String studentNumber;

    public StudentRequestDto(String name, int age, String studentNumber) {
        this.name = name;
        this.age = age;
        this.studentNumber = studentNumber;
      }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getStudentNumber() { return studentNumber; }

}

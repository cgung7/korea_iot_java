package org.example.chapter12.controller;

import org.example.chapter12.dto.StudentRequestDto;
import org.example.chapter12.dto.StudentResponseDto;
import org.example.chapter12.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private final List<Student> studentList;
    private int nextId;

    public StudentController(List<Student> studentList) {
        this.studentList = studentList;
        this.nextId = studentList.size() + 1;
    }

    // 학생 추가(Create)
    public void addStudent(StudentRequestDto dto) {
        // 학생 추가시 입력한 StudentNumber의 학생이 존재하는 경우
        // : 기능 X + 메시지 출력
        StudentResponseDto studentResponseDto = getStudentById(dto.getStudentNumber());

        if (studentResponseDto != null) {
            // 입력받은 studentNumber의 학생이 존재 - 학생 추가 불가
            System.out.println("해당 학번의 학생이 이미 존재합니다");
            return;
        }


        Student student = new Student(nextId++, dto.getName(), dto.getAge(), dto.getStudentNumber());
        studentList.add(student);
        System.out.println(dto.getName()+ "학생이 추가되었습니다. 학번: " + dto.getStudentNumber());
    }

    // 학생 조회 (전체)
    public List<StudentResponseDto> getAllStudents() {
        List<StudentResponseDto> response = new ArrayList<>();

       // 데이터 가공 과정 (Student >> StudentResponseDto)
        for (Student student: studentList) {
            response.add(new StudentResponseDto(
                    student.getName(),
                    student.getAge(),
                    student.getStudentNumber(),
                    student.getCreatedAt()
            ));
        }
        return response;
    }

    // 학생 조회 (단건)
    public StudentResponseDto getStudentById(String studentNumber) {
        for (Student student: studentList) {
            if (student.getStudentNumber().equals(studentNumber)) {
                return new StudentResponseDto(
                        student.getName(),
                        student.getAge(),
                        student.getStudentNumber(),
                        student.getCreatedAt()
                ); // 조회한 학생이 존재하는 경우(데이터 반환)
            }
        }
        return null; // 조회한 학생이 없을 경우 (null 반환)
    }
    // 학생 수정
    public boolean updateStudent(StudentRequestDto dto) {
        for (Student student: studentList) {
            if (student.getStudentNumber() == dto.getStudentNumber()) {
                student.setName(dto.getName());
                student.setAge(dto.getAge());
                return true;
            }
        }
        return false;
    }
    // 학생 삭제
    public boolean removeStudent(String studentNumber) {
        for (Student student: studentList) {
            if (student.getStudentNumber().equals(studentNumber)) {
                studentList.remove(student);
                return true;
            }
        }

        return false;
    }


}

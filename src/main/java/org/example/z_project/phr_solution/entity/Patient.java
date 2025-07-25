package org.example.z_project.phr_solution.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

// 환자 정보 클래스
@Data
@AllArgsConstructor
public class Patient {
    private Long id; // 환자 고유 번호
    private String name; // 환자 명
    private int age; // 환자 나이
    private String gender; // 환자 성병
}

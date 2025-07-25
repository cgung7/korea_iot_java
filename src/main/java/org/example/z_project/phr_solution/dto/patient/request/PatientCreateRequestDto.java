package org.example.z_project.phr_solution.dto.patient.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
// 환자 정보 등록
public class PatientCreateRequestDto {
    private String name; // 환자 명
    private int age; // 환자 나이
    private String gender; // 환자 성병
}

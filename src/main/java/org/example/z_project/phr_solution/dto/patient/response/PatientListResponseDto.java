package org.example.z_project.phr_solution.dto.patient.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// 환자 리스트
public class PatientListResponseDto {
    private String name;
    private String gender;
}

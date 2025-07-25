package org.example.z_project.phr_solution.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

// 환자 의료 기록 정보 클래스
@Data
@AllArgsConstructor
public class HealthRecord {
    private Long id; // 건강 기록 고유 번호
    private Long patientId; // 해당 기록의 환자 고유 번호
    private String dateOfVisit; // 방문 날짜
    private String diagnosis; // 진단
    private String treatment; // 처방
}

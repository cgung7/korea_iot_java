package org.example.z_project.phr_solution.dto.health_record.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class RecordListResponseDto {
    private Long id;
    private Long patientId;
    private String dateOfVisit;
    private String diagnosis;
    private String treatment;
    // 엔티티에 없는 데이터
    private Date inquiryTime; // 건강 기록 조회 시간
}

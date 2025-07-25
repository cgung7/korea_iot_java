package org.example.z_project.phr_solution.service;

import org.example.z_project.phr_solution.dto.patient.request.PatientCreateRequestDto;
import org.example.z_project.phr_solution.dto.patient.request.PatientUpdateRequestDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientListResponseDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientDetailResponseDto;

import java.util.List;

// 환자 정보에 대한 서비스(목록 조회) - Interface
public interface PatientService {
    // CR(전체/단건)UD
    void registerPatient(PatientCreateRequestDto dto); // 환자 등록
    List<PatientListResponseDto> listAllPatients(); // 환자 리스트 전체 조회
    PatientDetailResponseDto getPatientById(Long id); // ID로 환자 가져오기
    void updatePatient(Long id, PatientUpdateRequestDto dto); // 환자 정보 수정
    void deletePatient(Long id);
}

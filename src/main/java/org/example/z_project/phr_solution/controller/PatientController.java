package org.example.z_project.phr_solution.controller;

import org.example.z_project.phr_solution.dto.patient.request.PatientCreateRequestDto;
import org.example.z_project.phr_solution.dto.patient.request.PatientUpdateRequestDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientDetailResponseDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientListResponseDto;
import org.example.z_project.phr_solution.service.PatientService;
import org.example.z_project.phr_solution.service.impl.PatientServiceImpl;

import java.util.List;

// 환자 정보 제어 관리
public class PatientController {
    private final PatientService patientService;

    public PatientController() {
        this.patientService = new PatientServiceImpl();
    }

    // 환자 등록
    public void registerPatient(PatientCreateRequestDto dto) {
        patientService.registerPatient(dto);
    }
    // 환자 전체 조회
    public List<PatientListResponseDto> getAllPatients() {
        List<PatientListResponseDto> result = patientService.listAllPatients();
        return result;
    }
    // 환자 단건 조회
    public PatientDetailResponseDto getPatientById(Long id) {
        PatientDetailResponseDto result = patientService.getPatientById(id);
        return result;
    }
    // 환자 정보 수정
    public void updatePatient(Long id, PatientUpdateRequestDto dto) {
        patientService.updatePatient(id, dto);
    }
    // 환자 삭제
    public void deletePatient(Long id) {
        patientService.deletePatient(id);
    }

}

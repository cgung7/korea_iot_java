package org.example.z_project.phr_solution.controller;

import org.example.z_project.phr_solution.dto.health_record.request.RecordCreateRequestDto;
import org.example.z_project.phr_solution.dto.health_record.response.RecordListResponseDto;
import org.example.z_project.phr_solution.service.HealthRecordService;
import org.example.z_project.phr_solution.service.impl.HealthRecordServiceImpl;

import java.rmi.server.RMIClassLoaderSpi;
import java.util.List;

public class HealthRecordController {
    private HealthRecordService healthRecordService;

    public HealthRecordController() {
        this.healthRecordService = new HealthRecordServiceImpl();
    }

    public void createRecord(RecordCreateRequestDto dto) {
        healthRecordService.createdRecord(dto);
    }

    public List<RecordListResponseDto> getAllRecord() {
        return healthRecordService.getAllRecords();
    }

    // 필터링 (검색)
    public List<RecordListResponseDto> filterRecordByDiagnosis(String diagnosis) {
        return healthRecordService.filterRecordByDiagnosis(diagnosis);
    }

    public void deleteRecord(long id) {
        healthRecordService.deleteRecord(id);
    }


}

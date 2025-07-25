package org.example.z_project.phr_solution.repository;

import org.example.z_project.phr_solution.entity.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientRepository {
    List<Patient> patients = new ArrayList<>();
    // 싱글톤 구현
    private static final PatientRepository instance = new PatientRepository();
    
    private PatientRepository() {}

    public static PatientRepository getInstance() {
        return instance;
    }

    public void save(Patient patient) {
        // 생성(Create), 수정(Update)가 같은 save 메서드를 사용
        Optional<Patient> existing = findById(patient.getId());
//        existing.isPresent(value -> this.delete(value));
        existing.ifPresent(this::delete); // 전달받은 환자의 id가 이미 존재하는 경우 삭제
        patients.add(patient); // 새로운 데이터 추가
        
    }

    public List<Patient> findAll() {
        return new ArrayList<>(patients);
    }

    public Optional<Patient> findId(Long id) {
        return null;
    }


    public void delete(Patient patient) {
        patients.remove(patient);
    }

    public Optional<Patient> findById(Long id) {
        return patients.stream()
                .filter(patient -> patient.getId().equals(id))
                .findFirst();
    }
}

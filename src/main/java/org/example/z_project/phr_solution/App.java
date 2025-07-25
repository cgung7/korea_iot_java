package org.example.z_project.phr_solution;

/*
    === PHR (개인 건강 기록, Personal Health Record) 솔루션 ===

    1. 프로젝트 개요
     - 개인 건강 기록(PHR) 솔루션을 위한 간단한 콘솔 기반 응용 프로그램
     - 환자의 기본 정보를 관리, 환자의 건강 기록 등록, 수정, 조회 기능
     - 특정 조건에 맞는 건강 기록을 필터링하고 집계 가능

    2. 주요 기능 & 비즈니스 로직
     - 환자 정보 관리(Patient): CR(단건/전체)UD
     - 건강 기록 관리(HealthRecord): CRUD + 필터링(조회)

    3. 비즈니스 로직 구조
     - controller: 사용자 입력 처리 + 알맞은 서비스 메서드 호출
     - service: 핵심 비즈니스 로직 수행
     - repository: 데이터 저장소(DB)와의 상호 작용 담당
     - dto: 계층 간 데이터 전송을 위한 객체
     - entity: 데이터 저장소(DB)의 테이블과 매핑(연결)되는 도메인 객체

    4. 실행 및 관리
     - App.java: 프로그램 실행 진입점, 사용자와의 상호작용을 관리하고 전체 흐름을 제어
            >> App.java가 사용자 입력 처리, 메뉴 출력, 흐름 제어 모두 담당 -> SRP 위반 (단일 책임 원칙)
            >> handler + App.java로 구분

 */

import org.example.z_project.phr_solution.controller.PatientController;
import org.example.z_project.phr_solution.dto.patient.request.PatientCreateRequestDto;
import org.example.z_project.phr_solution.dto.patient.request.PatientUpdateRequestDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientDetailResponseDto;
import org.example.z_project.phr_solution.dto.patient.response.PatientListResponseDto;
import org.example.z_project.phr_solution.handler.InputHandler;
import org.example.z_project.phr_solution.handler.MenuPrinter;

import java.util.List;

public class App {
    private static final PatientController patientController = new PatientController();

    private static boolean processChoice(int choice) {
        switch (choice) {
            // 횐자 관련 기능
            case 1: {
                PatientCreateRequestDto requestDto = InputHandler.createPatientRequest();

                if (requestDto == null) {
                    System.out.println("필수 입력값을 유효하게 입력해야합니다.");
                    break;
                }
                patientController.registerPatient(requestDto);
                break;
            }
            case 2: {
                List<PatientListResponseDto> patients = patientController.getAllPatients();
                if (patients.isEmpty()) {
                    // 빈 배열
                    System.out.println("환자 정보가 없습니다");
                } else {
                    patients.forEach(System.out::println);
                }
                break;
            }
            case 3: {
                long id = InputHandler.getIdInput();
                PatientDetailResponseDto patient = patientController.getPatientById(id);

                if (patient == null) {
                    System.out.println("해당하는 ID의 환자가 없습니다.");
                } else {
                    System.out.println(patient);
                }
                break;
            }
            case 4: {
                long id = InputHandler.getIdInput();
                PatientUpdateRequestDto requestDto = InputHandler.updatePatientRequestDto();

                if (requestDto == null) {
                    System.out.println("필수 입력값을 유효하게 입력해야합니다.");
                    break;
                }

                patientController.updatePatient(id, requestDto);
                break;
            }
            case 5: {
                long id = InputHandler.getIdInput();
                patientController.deletePatient(id);
                break;

            }

            // 건강 기록 관련 기능

            case 10: {
                System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다. :)");
                return false;
            }
            default: {
                System.out.println("잘못된 입력입니다. 유효한 메뉴를 선택해주세요.");
                break;
            }


        }

        return true;

    }

    public static void main(String[] args) {

            try {
                while (true) {
                    MenuPrinter.displayMenu();
                    int choice = InputHandler.getChoice();
                    if (!processChoice(choice)) break; // processChoice의 반환값이 false면 로직 종료


                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                // 예외 발생 상관없이 반스기 실행 보장
                InputHandler.closeScanner();
            }


    }
}

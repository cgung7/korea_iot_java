package org.example.z_project.phr_solution.handler;

import org.example.z_project.phr_solution.dto.patient.request.PatientCreateRequestDto;
import org.example.z_project.phr_solution.dto.patient.request.PatientUpdateRequestDto;

import java.util.Scanner;




// 특정 요청이나 이벤트를 처리(handle)하는 역할의 클래스를 모아두는 공간
public class InputHandler {
    private static final Scanner sc = new Scanner(System.in);

public static int getChoice() {
    while (!sc.hasNextInt()) {
        System.out.println("숫자를 입력해주세요.");
        sc.nextLine();
    }
    int choice = sc.nextInt();
    sc.nextLine();
    return choice;

}

public static String getInput(String prompt) {
    while (true) {
        System.out.println(prompt + ": ");
        String input = sc.nextLine().trim();// trim(): 문자열 양쪽 공백을 제거

        if (!input.isEmpty()) {
            return input;
        }

        System.out.println("입력값을 비워둘 수 없습니다. 다시 입력해주세요.");
    }

}

public static Long getIdInput() {
    while (true) {
    String input = getInput("ID를 입력하세요.");

    try {
        return Long.parseLong(input);
    } catch (NumberFormatException e) {
        System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요." );
    }
    }

}

// 요청
    // 1) 환자 정보 - 생성, 수정
    public static PatientCreateRequestDto createPatientRequest() {
    PatientCreateRequestDto dto = null; // 초기값 null

    try {
        // 빈 공간(null)상태로 변수 입력값 저장
        String name = getInput("환자 이름을 입력해주세요.");
        int age = Integer.parseInt(getInput("환자 나이를 입력해주세요."));
        String gender = getInput("환자의 성별을 입력해주세요.");

        // 저장한 데이터 값 dto에 리스트 저장
        dto = new PatientCreateRequestDto(name, age, gender);

    } catch (NumberFormatException e) {
        System.out.println("환자 나이는 숫자값을 입력해야합니다.: " + e.getMessage());
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return dto;

    }

    public static PatientUpdateRequestDto updatePatientRequestDto() {
        PatientUpdateRequestDto dto = null;

        try {
            String name = getInput("환자 이름을 입력해주세요.");
            int age = Integer.parseInt(getInput("환자 나이를 입력해주세요."));

            dto = new PatientUpdateRequestDto(name, age);
        } catch (NumberFormatException e) {
            System.out.println("환자 나이는 숫자값을 입력해야합니다.: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dto;

    }

    public static void closeScanner() {
    sc.close();
    }
}

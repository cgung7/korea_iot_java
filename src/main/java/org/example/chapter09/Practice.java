package org.example.chapter09;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        // == 생일까지 남을 일수를 계산하는 프로그램 == //
        // : 사용자로부터 생년월일을 입력받고, 다가오는 생일까지 남은 일수를 반환

        Scanner sc = new Scanner(System.in);

        // 1. 사용자로부터 생년월일을 입력 받기 (형식 YYYY-MM-DD)
        System.out.println("생년월일을 입력하세요. (YYYY-MM-DD)");
        String inputData = sc.nextLine();

        // 2. 사용자의 입력을 LocalDate 타입으로 변환 (yyyy-MM-DD): formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // LocalDate.parse(a, b)
        // : a를 b의 형태로 재구성
        // cf) parse: 분석하다
        LocalDate birthDate = LocalDate.parse(inputData, formatter);

        // 3. 현재 날짜 구하기
        LocalDate today = LocalDate.now();

        // 4. 올해의 생일 계산
        // .withYear(): 년도를 조작하는 메서드
        // . with~()
        LocalDate nextBirthDay = birthDate.withYear(today.getYear());

        // 5. 생일이 이미 지났다면 년도 값을 내년으로 설정
        if (nextBirthDay.isBefore(today) || nextBirthDay.isEqual(today)) {
            nextBirthDay = nextBirthDay.plusYears(1);
        }

        // 6. 남은 일수 계산
        // ChronoUnit.Days: java.time 패키지에서 날짜와 시간 간의 차이를 계산할 때 사용
        // .betweem(a, b): a와 b 사이의 날짜 | 시간 차이를 반환
        long daysUtilNextBirthday = ChronoUnit.DAYS.between(today,nextBirthDay);

        System.out.println("남은 생일까지 " + daysUtilNextBirthday + "일 남았습니다.");
    }
}

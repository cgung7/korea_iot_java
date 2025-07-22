package org.example.chapter14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class I_Stream {
    public static void main(String[] args) {

        // Arrays.asList
        // : 일반 배열을 ArrayList로 반환
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> newNumbers = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
                // 최종 연산 - 변경 가능한 리스트를 반환 (mutable list) / Java 8 이상 / 사용 권장

        newNumbers.add(10);

        // cf) .stream()으로 생성된 스트림은 일회성으로만 사용 가능
        // - 메서드 체이닝으로 여러 기능 적용은 가능

        Stream<Integer> stream = newNumbers.stream();

        List<Integer> a = stream
                .map(n -> n * n)
                .toList();

        // a.add(100);

//        stream.filter(n -> n % 2 == 0)
//                .toList();
        // .IllegalStateException 예외 발생(스트림 재사용 시 발생)

        System.out.println(numbers);
        System.out.println(newNumbers);
    }
}

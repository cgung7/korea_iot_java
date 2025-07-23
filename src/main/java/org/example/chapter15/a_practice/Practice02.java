package org.example.chapter15.a_practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 파일 데이터에 대한 데이터 분리 & 정렬
public class Practice02 {
    public static void main(String[] args) {
        List<String> fileNames = Arrays.asList(
                "a.pdf", "b.png", "c.mp4"
                , "g.ppt", "h.js", "i.jpg"
                , "d.ppt", "e.png", "f.jpg"
        );

        // 1. 특정 확장자 필터링
        // : 이미지 파일만 추출(.png, .jpg)
        // cf) startsWith, endsWith(""): 특정 문자열로 시작, 끝나는 데이터에 대해 true 반환
        List<String> filteredFiles = fileNames.stream()
                .filter(name -> name.endsWith(".png") || name.endsWith(".jpg"))
                .sorted() // [b.png, e.png, f.jpg, i.jpg]
                .collect(Collectors.toList());
        // 필터링을 우선 설정하고, 정렬이 더 효율적이다.

        System.out.println(filteredFiles); // [b.png, i.jpg, e.png, f.jpg]

        // 2. 파일 이름을 알파벳 순으로 정렬
        List<String> sortedFiles = fileNames.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedFiles);
        // [a.pdf, b.png, c.mp4, d.ppt, e.png, f.jpg, g.ppt, h.js, i.jpg]

    }
}

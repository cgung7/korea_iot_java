package org.example.chapter16.practice.entity;

public enum Category {
    FICTION, NONFICTION, SCIENCE, HISTORY, FANTASY;

    public static Category fromString(String value) {
        try {
            return Category.valueOf(value);
            // valueOf(인자)에 Category의 상수값과 일치하지 않는 데이터 전달 시
            // : IllegalArgumentException 발생
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid category" + value);
        }
    }
}

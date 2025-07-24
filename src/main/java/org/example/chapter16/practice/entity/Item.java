package org.example.chapter16.practice.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

// 추상 클래스
@AllArgsConstructor
@Getter

public abstract class Item {
    private String id; // 제품 고유 번호
    private String name; // 제품명

    public abstract void display();

}

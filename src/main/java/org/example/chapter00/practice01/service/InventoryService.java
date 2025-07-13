package org.example.chapter00.practice01.service;

import org.example.chapter00.practice01.entity.Item;

import java.util.List;


// 인터페이스 선언
public interface InventoryService {
    // 아이템을 추가
    void addItem(Item item);
    // 특정 카테고리에 속하는 아이템 목록(List)을 반환(카테고리의 이름을 category로 설정)
    List<Item> getItemsByCategory(String category);
    // 아이템의 가격을 변경하는 기능 (수정할 아이템의 id, 새로 설정할 가격)
    void updateItemPrice(String itemId, int newPrice);
    // 특정 아이템을 삭제하는 기능(삭제할 Id)
    void deleteItem(String itemId);
}
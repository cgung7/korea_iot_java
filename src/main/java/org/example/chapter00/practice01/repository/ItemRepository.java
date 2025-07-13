package org.example.chapter00.practice01.repository;

import org.example.chapter00.practice01.entity.Item;

import java.util.Set;

// DB를 대신하는 자바 내부의 저장소 - interface
// - ItemRepository: DB와 어떠한 행위를 할 것인지 약속 (interface)
// - InMemoryItemRepository: 데이터 처리에 대한 실질적인 행위 구현 (class)
public interface ItemRepository {
    // 아이템을 저장소에 추가
    void addItem(Item item);
    // 저장소에 모든 아이템을 반환(Item객체들의 집합, Set를 사용함으로 중복 방지)
    Set<Item> findAll();
    // 저장된 특정 Id에 해당하는 아이템을 찾아 반환(객체 없으면 null)
    Item findById(String itemId); // 단건 조회
    // 아이템을 삭제
    // 매개변수를 아이템의 Id로 설정(리턴값 X)
    void removeItem(String itemId);
}
package org.example.chapter00.practice01.repository;


import org.example.chapter00.practice01.entity.Item; // 다른 패키지에 정의된 Item에 현재 파일에서 사용가능하게 됨

// Set 와 Set의 종류 중 하나인 HashSet 사용하게 위한 import
import java.util.HashSet;
import java.util.Set;

// 아이템저장소(ItemRepository)인터페이스를 구현(implements)
public class InMemoryItemRepository implements ItemRepository {
    // 아이템 객체가 두 번 이상 저장되지 않기위해 하려는 의도로 Set 사용
    private Set<Item> items = new HashSet<Item>();


    // 오버라이딩
    // 여기 현재는 구현 불가
    @Override
    public void addItem(Item item) {
        // items.add(item); 정상 구현 출력 예시

    }

    // 저장된 모든 아이템을 반환
    @Override
    public Set<Item> findAll() {
        return Set.of(); // 읽기전용(empty,불변) Set 반환
    }


    // 주어진 ID와 일치하는 아이템을 찾아 반환하는 메서드

    @Override
    public Item findById(String itemId) {
        return null;

//       메서드 구현 예시)
//        for (Item item : items) {
//            if (item.getId().equals(itemId)) {
//                return item;
//            }
//        }
//        return null;
    }

    // Id에 해당하는 아이템을 저장소에 제거하는 기능
    @Override
    public void removeItem(String itemId) {

        // 구현 예시) items.removeIf(item -> item.getId().equals(itemId));
    }
}
package org.example.chapter00.practice01.service;

import org.example.chapter00.practice01.entity.Item;
import org.example.chapter00.practice01.repository.ItemRepository;
import org.example.chapter00.practice01.repository.InMemoryItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// 인벤토리서비스(InventoryService)인터페이스를 구현(implements) 하기 위해 설정
public class InventoryServiceImpl implements InventoryService{
    // 아이템저장소(ItemRepository)을 저장소를 가진다.
    // final로 한 번 초기화하면 변경 X
    private final ItemRepository repository;

    // 생성자 선언
    // 외부에서 저장소를 주입받음
    public InventoryServiceImpl(InMemoryItemRepository repository) {
        this.repository = repository;
    }

    // 오버라이딩
    @Override
    public void addItem(Item item) {
        repository.addItem(item);
    }



    @Override

    public List<Item> getItemsByCategory(String category) {
        // 저장소 모든 아이템을 가져온 후 카테고리 이름과 일치하는 것 만 골라 리스트업
        Set<Item> allItems = repository.findAll();
        // 결과값을 담기 위한 빈 리스트 생성
        List<Item> categoryItems = new ArrayList<Item>();

        // 아이템의 반복검사 진행으로 카테고리 이름과 같으면 리스트 추가 기능 설정
        for (Item item: allItems) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                                // equalsIgnoreCase()는 대소문자를 무시하고 비교
                categoryItems.add(item);
            }
        }
        return categoryItems; // 끝나면 리스트 반환
    }

    @Override
    // 특정 Id를 가진 아이템 찾고, 그아이템을 수정 작업
    public void updateItemPrice(String itemId, int newPrice) {
        // 수정할 Item이 저장소에 존재하는지 확인
        Item item = repository.findById(itemId);

        if (item != null) {
            item.setPrice(newPrice); // 객체 가격을 새로운 값으로 수정
        }
    }

    @Override
    // 특정 Id를 가진 아이템이 존재하면 삭제하는 작업.
    public void deleteItem(String itemId) {
        Item item = repository.findById(itemId);

        if (item != null) {
            repository.removeItem(itemId); // 삭제작업
        }
    }
}
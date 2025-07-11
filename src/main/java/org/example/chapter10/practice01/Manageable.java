package org.example.chapter10.practice01;

import java.util.List;

// Manage(관리하다) + able(할 수 있는)
public interface Manageable {

    // CRUD
    void add(Item item);
    void remove(String id);
    void updateStock(String id, int quantity);
    void listAll();

    // 검색 기능
    List<Item> search(String keyword);
    List<Item> searchByCategory(String category);
    List<Item> searchByPriceRange(int minPrice, int maxPrice);

}

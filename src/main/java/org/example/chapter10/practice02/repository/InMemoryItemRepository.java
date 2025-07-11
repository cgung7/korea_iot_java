package org.example.chapter10.practice02.repository;

import org.example.chapter10.practice02.entity.Item;

import java.util.HashSet;
import java.util.Set;

public class InMemoryItemRepository implements ItemRepository {
    private Set<Item> items = new HashSet<Item>();

    @Override
    public void addItem(Item item) {

    }

    @Override
    public Set<Item> findAll() {
        return Set.of();
    }

    @Override
    public Item findById(String itemId) {
        return null;
    }

    @Override
    public void removeItem(String itemId) {

    }
}


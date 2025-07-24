package org.example.chapter16.practice.service;

import org.example.chapter16.practice.entity.Category;
import org.example.chapter16.practice.entity.Item;

import java.util.List;

public interface BookService {
    List<Item> searchByCategory (Category category);
}

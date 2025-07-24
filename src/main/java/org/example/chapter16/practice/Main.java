package org.example.chapter16.practice;

import org.example.chapter16.practice.entity.Category;
import org.example.chapter16.practice.entity.Item;
import org.example.chapter16.practice.service.BookService;
import org.example.chapter16.practice.service.BookServiceImpl;

import java.util.List;
import java.util.Scanner;

/*
    === 도서 관리 시스템 ===
    : 도서 카테고리 ENUM 자료형 추가
    >> 조회 기능 (카데고리별 검색 - 필터링)

 */
public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("== 도서 관리 시스템 == ");
            System.out.println("1. 카테고리별 검색");

            System.out.print("메뉴를 선택해주세요 >> ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("카테고리를 입력해주세요.");
                        String searchCategory = sc.nextLine();

                        // 문자열 값을 enum 타입으로 변환
                        Category searchCategoryEnum = Category.fromString(searchCategory);

                        List<Item> categoryResults = bookService.searchByCategory(searchCategoryEnum);

                        if (categoryResults.isEmpty()) {
                            System.out.println("해당 카테고리의 책이 없습니다.");
                        } else  {
                            categoryResults.forEach(Item::display);
                        }

                }


            } catch (NumberFormatException e) {
                System.out.println("유효한 숫자값을 입력해주세요: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("유효한 형식의 인자를 전달해주세요: " + e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

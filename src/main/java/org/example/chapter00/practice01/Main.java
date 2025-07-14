package org.example.chapter00.practice01;

import org.example.chapter00.practice01.entity.Electronics;
import org.example.chapter00.practice01.entity.Furniture;
import org.example.chapter00.practice01.entity.Item;
import org.example.chapter00.practice01.repository.InMemoryItemRepository;
import org.example.chapter00.practice01.service.InventoryService;
import org.example.chapter00.practice01.service.InventoryServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * == Inventory Management System ==
 * : 다양한 상품을 관리하는 재고 관리 시스템
 *
 * 1) 프로젝트 구조
 * - Main 파일: 프로그램 실행의 진입점
 *
 * - entity 패키지(데이터 모델 정의)
 *   : 데이터(상품)를 표현하는 클래스 정의 - 객체의 속성과 동작을 정의
 *
 * - service 패키지(비즈니스 로직 처리)
 *   : 상품 추가, 조회, 수정, 삭제와 같은 비즈니스 로직을 처리 (직접적인 데이터 조작)
 *
 * - repository 패키지 (데이터 저장소 역할)
 *   : 데이터를 저장하고 검색하는 기능을 제공하는 클래스
 *
 * 2) 요구사항
 * - 기능
 *       : 상품(Item) 추가, 수정, 삭제, 카테고리 상품 검색, 가격 또는 이름 등으로 정렬
 *
 * - 사용 컬렉션 프레임워크
 *       Set: 상품 관리(중복 상품 관리)
 *       Map: 카테고리별 상품 분류(Key: 카테고리명, Value: 상품 목록)
 *
 * - 추상 클래스 (Item: 모든 상품의 공통 필드 포함)
 * - 인터페이스 (Discountable: 할인 로직 제공)
 * */
public class Main {
    public static void main(String[] args) {

        // 변수 선언
        // 인터페이스 인터페이스 타입의 변수 = 새 객체(인스턴스) 생성
        // new InventoryServiceImpl(new InMemoryItemRepository());
        // InventoryServiceImpl 만들 때 new InMemoryItemRepository() 저장소 객체를 같이 넘겨 주기 위해 설정
        // 전달받은 InMemoryItemRepository 저장소를 내부에서 사용할 수 있게 돼요.

        // 1. new InMemoryItemRepository()로 아이템을 저장하는 저장소 객체 생성
        // 2. 그 저장소 객체를 InventoryServiceImpl 객체 생성자에 전달해서
        //    저장소를 사용하는 서비스 객체를 만든다.
        // 3. 그 서비스 객체를 InventoryService 타입의 변수 inventoryService에 저장
        InventoryService inventoryService = new InventoryServiceImpl(new InMemoryItemRepository());
        Scanner sc = new Scanner(System.in); // 스캐너 실행 준비

        while (true) {
            System.out.println("");
            System.out.println("=== Inventory Management System ===");
            System.out.println("1. 제품 추가");
            System.out.println("2. 제품 수정 (가격)");
            System.out.println("3. 제품 삭제");
            System.out.println("4. 제품 검색 (카테고리)");
            System.out.println("5. 제품 전체 조회");
            System.out.println("0. 프로그램 종료");
            System.out.println("메뉴를 선택해주세요 >> ");

            // 요류검사 try catch finally
            try {
                // Integer.ParseInt: 문자열을 정수로 변환해주는 메서드
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        addItem(inventoryService, sc); // choice가 1이면 addItem()메서드 호출
                        break;
                    case 2:
                        updateItemPrice(inventoryService, sc);
                        break;
                    case 3:
                        deleteItem(inventoryService, sc);
                        break;
                    case 4:
                        viewItemsByCategory(inventoryService, sc);
                        break;
                    case 5:
                        viewAllItems(inventoryService, sc);
                        break;
                    case 0:
                        System.out.println("=== 종료합니다 ===");
                        sc.close();
                        return;
                    default: // choice가 0 ~ 5가 아닐 경우 이부분이 실행
                        System.out.println("유효하지 않은 선택입니다. 다시 시도해주세요 :)");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 같은 클래스안에서만 사용(private)하고 객체를 만들지 않고 바로 사용(static)
    // 메서드 이름(메서드를 호출할 때 두 개의 값을 지정*(InventoryService, service))
    private static void addItem(InventoryService service, Scanner sc) {
        System.out.println("Enter Item Id: ");
        String id = sc.nextLine();
        System.out.println("Enter Item Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Item Price: ");
        int price = sc.nextInt();
        System.out.println("Enter Item Quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine(); // 버퍼 소비
        System.out.println("Enter Item Category (Electronics / Furniture): ");
        String category = sc.nextLine();

        // if( category가 대소문자 구분없이 문자열을 구분(equalsIgnoreCase)하여(Electronics)가 맞는지 검색
        if (category.equalsIgnoreCase("Electronics")) {
            System.out.println("Enter brand: ");
            String brand = sc.nextLine();
            System.out.println("Enter Warranty (months): ");
            int warranty = sc.nextInt();
            sc.nextLine();
            Item electronics = new Electronics(id, name, price, quantity, brand, warranty); // 업캐스팅
            service.addItem(electronics);
        } else if (category.equalsIgnoreCase("Furniture")) {
            System.out.println("Enter material: ");
            String material = sc.nextLine();
            System.out.println("Enter size: ");
            String size = sc.nextLine();
            Item furniture = new Furniture(id, name, price, quantity, material, size);
            service.addItem(furniture);
        } else {
            System.out.println("Invalid category, Item not added");
        }
    }

    private static void updateItemPrice(InventoryService service, Scanner sc) {
        System.out.println("가격을 수정할 아이템의 ID를 입력해주세요.");
        String id = sc.nextLine();
        System.out.println("새 가격을 입력해주세요.");
        int newPrice = sc.nextInt();
        sc.nextLine();
        service.updateItemPrice(id, newPrice);
        System.out.println("제품 가격이 성공적으로 수정되었습니다.");
    }

    private static void deleteItem(InventoryService service, Scanner sc) {
        System.out.println("삭제할 아이템의 ID를 입력해주세요.");
        String id = sc.nextLine();
        service.deleteItem(id);
        System.out.println("제품이 성공적으로 삭제되었습니다.");
    }

    // 메서드선언 (같은 클래스만 사용가능 - private)
    // Scanner 객체 자체를 받아서 메서드 내부에서 검색값을 받을 수 있게 만드는 구조
    // (InventoryService service, Scanner sc)는 메서드에 외부에서 이미 생성된 객체를 매개변수로 전달받는 것
    private static void viewAllItems(InventoryService service, Scanner sc) {
        // 컬렉션타입데이터A.addAll(컬렉션타입데이터B)
        // : A의 구조에 B의 모든 데이터를 각각 요소로 삽입

        // a = [1, 2, 3]
        // b = [4, 5, 6]

        // a.add(b): [1, 2, 3, [4, 5, 6]]
        // a.addAll(b): [1, 2, 3, 4, 5, 6]

        // = "Electronics" (전자제품) 카테고리에 해당하는 아이템 목록을 가져온다.
        List<Item> allItems = new ArrayList<>(service.getItemsByCategory("Electronics"));

        // 가구 카테고리 아이템을 가져와 기존 리스트(allItem)에 전부 추가(allAll)
        allItems.addAll(service.getItemsByCategory("Furniture"));

        // 아이템이 비어있는지 확인
        if (allItems.isEmpty()) {
            System.out.println("제품이 없습니다.");
        } else { // 아이템이 있으면 리스트 출력
            System.out.println("=== 모든 제품 목록 ===");
            for (Item item: allItems) {
                System.out.println(item);
            }
        }
    }

    // 메서드 선언 같은 클래스만 사용(private) 객체를 만들지 않고 바로호출(static)
    private static void viewItemsByCategory(InventoryService service, Scanner sc) {
        System.out.println("조회할 제품의 카테고리를 입력해주세요.");
        // 입력한 값을 category변수에 저장
        String category = sc.nextLine();

        // 입력받은 category기준으로 해당 카테고리의 아이템을 가져온다.
        // items는 결과값을 담는 리스트
        List<Item> items = service.getItemsByCategory(category);


        // 아이템 리스트가 비어있는지 확인
        if (items.isEmpty()) {
            System.out.println("해당 카테고리의 제품이 없습니다.");
        } else {
            System.out.println(category + " 카테고리의 제품 목록");
            for (Item item: items) {
                System.out.println(item);
            }
        }
    }
}

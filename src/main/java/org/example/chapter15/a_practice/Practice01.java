package org.example.chapter15.a_practice;

// == 주문 목록에 상품별 총 판매량 계산 == //

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 주문 클래스
@Getter
@ToString
@AllArgsConstructor
class Order {
    private String product; // 제품명
    private int quantity; // 주문 수량

}

public class Practice01 {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("노트북",5),
                new Order("핸드폰",6),
                new Order("태블릿",1),
                new Order("스마트워치",3),
                new Order("핸드폰",5),
                new Order("이어폰",2),
                new Order("노트푹",7),
                new Order("태블릿",1)
        );

        // == 상품명 총 판매량 계산 == //
        // 1) 각 상품 별 그룹화(분리)
        // 2) 해당 데이터에서 그룹화 된 요소의 quantity(수량)를 모두 더함 = summingInt()
        // >> 총 판매량 계산

        Map<String, Integer> productSales = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getProduct, Collectors.summingInt(Order::getQuantity)));

        System.out.println(productSales);

    }
}

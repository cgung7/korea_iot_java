package org.example.chapter15;

/*
    1. 불변성 데이터: Stream API 정렬 사용
        목적) 원본 리스트 변경 X, 정렬된 새로운 리스트만 필요 시
        EX) 클라이언트 응답용 DTO 리스트 정렬

    2. 원본 리스트 자체 정렬
     - List.sort() 또는 Collection.sort()
     목적) 원본 데이터를 직접 수정해서 정렬 순서를 유지해야 하는 경우
     EX) 캐시된 리스트, 재사용 리스트, 통계 계산용 리스트 등
        >> 데이터베이스나 외부 API에서 자주 조회되는 데이터를 미리 리스트에 저장해두고
            , 필요 시 다시 원본을 가져오지 않고 빠르게 읽어오는 용도

    3. Comparator 추출로 정렬 기준 재사용
    목적) 정렬 기준이 자주 반복되거나 복잡한 로직일 때 재 사용성을 높이기 위함

 */



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
class Product {
    private int price;
}

@AllArgsConstructor
class Post {
    private String title;
}

@Getter
@AllArgsConstructor
@ToString
class User {
    private String name;
    private int age;
}

class ProductRepository {
    List<Product> findAll() {
        return new ArrayList<>(List.of(
                new Product(15),
                new Product(10),
                new Product(20),
                new Product(21),
                new Product(9)
        ));
    }

}

class PostRepository {
   // DB SQL를 통해 정렬된 데이터를 반환하여 가져옴
    // Post 데이터들에서 조회수 순으로 내림차순 정렬, 상위 5개의 데이터를 반환
    List<Post> findTop5ByOrderByViewsDesc() {
        return new ArrayList<>(List.of(
                new Post("인기 1"),
                new Post("인기 2"),
                new Post("인기 3"),
                new Post("인기 4"),
                new Post("인기 5")
        ));
    }
}

// 제품과 관련된 비즈니스 로직을 수행하는 클래스
// CRUD + 필터링 / 통계
// : 가격 기준으로 정렬 조회
class ProductService {
    ProductRepository productRepository = new ProductRepository();

    // 생성
    void createProduct() {}
    // 수정
        void updateProduct() {}
    // 가격 기준으로 정렬된 새로운 리스트 반환 (원본 products는 변경되지 않음)
    List<Product> getProductsSortedByPrice() {
        List<Product> products = productRepository.findAll();


        // stream().sorted()는 중간 연산
        // : 원본을 그대로 두고, 가공된 결과를 생성
        // - 불변 데이터 처리에 유리, 클린 코드 작성에도 적합
        return products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
    }


}

class PostService {
    PostRepository postRepository = new PostRepository();
    private List<Post> cachedPopularPosts;

    // List.sort()는 리스트 그자체를 변경
    // stream() 보다 메모리 효율이 좋음 (새 리스트 생성 X)
    // : 캐시나 반복 사용 데이터에 적합
    public List<Post> getPopularPosts() {
        if (cachedPopularPosts == null) {
            // DB 에서 인기 게시글 조회
            cachedPopularPosts = postRepository.findTop5ByOrderByViewsDesc();
        }
        // 한 번 불러온 후 매번 DB 조회를 하지 않고 재사용
        return cachedPopularPosts;
    }

    public void refreshPopularPostCache() {
        //필요할 때 갱신
        cachedPopularPosts = postRepository.findTop5ByOrderByViewsDesc();
    }
}

// 정렬 기준을 별도로 유딜 클래스로 분리
// 사용자 데이터를 정렬 로직을 정리
class UserComparator {
    // 사용자 이름 오름차순 정렬 설정
    public static final Comparator<User> BY_NAME = Comparator.comparing(User::getName);

    // 사용자 나이 내림차순 정렬 설정 (연장자 순) // .reversed();
    public static final Comparator<User> BY_AGE_DESC = Comparator.comparingInt(User::getAge).reversed();

    // 정렬 로직을 메서드에서 분리하여 한 곳에서 관리 가능
    // : 테스트 용이성, 유지보수성 향상
    // - 실무 프로젝트에서는 ComparatorUtils, SortConstants 클래스에 모아서 정의

}

public class B_sort {
    public static void main(String[] args) {

        List<User> userList = new ArrayList<>(List.of(
           new User("이승아",25),
           new User("이도경",20),
           new User("김명진",30),
           new User("조승범",23),
           new User("윤대휘",27)
        ));

        userList.sort(UserComparator.BY_AGE_DESC); // 나이순 정렬(내림차순)

        System.out.println(userList);

        userList.sort(UserComparator.BY_NAME); // 이름순 정렬(오름차순)

        System.out.println(userList);



    }
}

// SQL 정렬 VS Java 정렬의 역할 분리
// >> 성능 최적화 및 역할 구분
// 1) 데이터가 많고 단순한 정렬: SQL - ORDER BY
// 2) 복잡한 정렬 기준: Java - Comparator, Stream API
// 3) 정렬 조건이 요청 마다 달라짐: Java 처리
// 4) 정렬된 순서를 DB에서 보장: SQL 처리
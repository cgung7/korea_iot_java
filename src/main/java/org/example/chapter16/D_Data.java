package org.example.chapter16;

/*
    === DTO, VO, DAO, Entity ===
    공통점: 데이터를 목적에 따라 정의하는 구조

    1) DTO(Data Transfer Object): 데이터를 전달하기 위한 객체
    2) VO(Value Object): 값 자체를 표현하는 객체
    3) DAO(Date Access Object): Database에 접근하는 역할을 하는 객체
    4) Entity: 실제 DB 테이블과 매핑되는 클래스

 */



import lombok.*;

import java.util.Date;

// 1) DTO
// : 계층 간 데이터 교환을 위해 사용하는 객체
// - 로직을 가지지 않는 순수한 데이터 객체 (비즈니스 로직 X, Getter & Setter만 존재)
// - 요청(Request)과 응답(Response) 객체로 구분하여 사용

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class UserSignInRequestDto {
    // 로그인을 위한 요청값
    private String userId;
    private String password;
}

// 2) VO
// : 특정 값을 표현하는 객체
// - 주로 사용자 주소, 이름, 좌표 등 도메인에서 의미 있는 값을 표현
// - 불변성(읽기 전용): 생성 시 내용 변경 불가
// >> 주로 필드값 final, Getter만 가짐

@AllArgsConstructor
@Getter
@EqualsAndHashCode
class Address {
    // 데이터 식별 값 필요 X (ID가 없음)
    // 동일성 보다 동등성이 중요(VO는 값이 같으면 동일하다고 본다)
    private final String city;
    private final String zipcode;
}

// 3) DAO
// : 데이터베이스 접근 객체
// - 서비스 모델과 데이터베이스를 연결하는 역할
// - DB에 접근해 CRUD 작업을 담당
// >> 일반적으로 JDBC 또는 JPA, MyBatis를 통해 구현
// >> Spring 기반 프로젝트에서 Repository 또는 Mapper로 대체됨

// JDBC 기반 (Java + Database)
@AllArgsConstructor
class UserResponseDto {
    String id;
    String nickname;
}

// 실질적인 로직은 DAO 대신 JPA - Repository interface를 사용
class UserDao {
    // 로그인 시 userId로 사용자 정보 조회
    public UserResponseDto getUserById(String userId) {
        // DB에 접근해 해당 userId 사용자의 닉네임을 조회했다고 가정
        String id = "qwe";
        String nickname = "개구리";

        return new UserResponseDto(id, nickname);
    }
}

// 4) Entity
//: 실제 데이터베이스의 테이블에 해당하는 데이터 구조와 매핑되는 클래스
// - JPA(Java Persistence API)와 같은 ORM(Object-Related Mapping) 툴에서 사용
// - DB의 각 레코드와 매핑
// > @Entity, @Id, @Column 등을 사용
@Getter
@Setter
// @Entity - entity 클래스임을 명시
// @Table(name = "users") - DB의 user 테이블과 연결을 명시
class User {
    private Long id;
    private String userId;
    private String password;
    private String name;
    private String email;
    private Date createdAt; // 해당 데이터가 생성된 일시 - 회원가입 날짜
}

public class D_Data {}

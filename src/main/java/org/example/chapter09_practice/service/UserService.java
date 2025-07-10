package org.example.chapter09_practice.service;

import org.example.chapter09_practice.model.User;

import java.util.List;

public interface UserService {

    // 인터페이스의 특징
    // 내부의 멤버(변수, 메서드)는 각각 public static final, public abstract이 생략함

    // 1. 사용자 등록(추가)
    // 요청값: 사용자 정보, 반환값 X
    void addUser(User user); // 추상 메서드 (구현 X)

    // 2. 사용자 조회(단건)
    // 요청값: 사용자 특정 값, 반환값: 단일 사용자 정보
    User getUserById(int id);

    // 3. 사용자 조회(전체)
    // 요청값: X, 반환값: 전체 사용자 정보(배열)
    List<User> getAllUsers();

    // 4. 사용자 수정
    // 요청값: 사용자 특정값, 새로운 이메일값, 반환값: X
    void updateUserEmail(int id, String newEmail);

    // 5. 사용자 삭제
    // 요청값: 사용자 특정값, 반환값: X
    void deleteUser(int id);

    // 6. 사용자 필터링(이름)
    // 요청값: 조회하고자 하는 이름, 반환값:필터링 된 사용자 정보(배열)
    List<User> findUsersByName(String name);
}

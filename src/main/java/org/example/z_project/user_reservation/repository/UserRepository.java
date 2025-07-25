package org.example.z_project.user_reservation.repository;

import org.example.z_project.user_reservation.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private final List<User> users = new ArrayList<>();

    // 사용자 - 회원가입
    // : DB에 새로운 사용자 정보를 저장
    // +) 요청(회원 정보), 응답(X)
    public void save(User user) {
        users.add(user);
    }


    // 로그인
    // : DB에 해당 사용자의 아이디와 비밀번호가 모두 일치하는지 확인
    // +) 사용자 조회 - 요청(userId), 응답(사용자 정보)
    public Optional<User> findByUserId(String userId) {
        return users.stream()
                .filter(user -> user.getUserId().equals(userId)).findFirst();
    }

    // 로그아웃
}

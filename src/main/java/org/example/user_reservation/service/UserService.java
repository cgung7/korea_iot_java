package org.example.user_reservation.service;


import org.example.user_reservation.dto.UserLoginRequestDto;
import org.example.user_reservation.dto.UserRegisterRequestDto;
import org.example.user_reservation.entity.User;

import java.util.Optional;

public interface UserService {
    void registerUser(UserRegisterRequestDto dto);
    void login(UserLoginRequestDto dto);
    void logout();
    boolean isLoggedIn(); // 사용자 로그인 유무를 확인
    Optional<User> findUserById(String userId);
}

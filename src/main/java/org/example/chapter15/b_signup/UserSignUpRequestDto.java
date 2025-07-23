package org.example.chapter15.b_signup;

// 사용자-회원가입-요청-데이터형식

// 사용자 회원가입 요청 DTO

import lombok.AllArgsConstructor;
import lombok.Getter;

// cf) DTO: Date Transfer Object
// - 데이터 전송 객체
// - 프로세스(계층) 간에 데이터를 전달하는 객체를 의미
@AllArgsConstructor
@Getter
public class UserSignUpRequestDto {
    private String username; // 사용자 로그인 아이디
    private String password;
    private String passwordCheck; // 비밀번호 확인
    private String name;
    private String email;
    private String phone;
    private String nickname;
}

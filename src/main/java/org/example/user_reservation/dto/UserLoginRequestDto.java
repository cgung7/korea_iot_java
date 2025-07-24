package org.example.user_reservation.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserLoginRequestDto {
    private String userId;
    private String password;
}

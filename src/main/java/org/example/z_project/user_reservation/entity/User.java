package org.example.z_project.user_reservation.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    private final String userId;
    private final String password;
    private final String name;
    private final String email;
}

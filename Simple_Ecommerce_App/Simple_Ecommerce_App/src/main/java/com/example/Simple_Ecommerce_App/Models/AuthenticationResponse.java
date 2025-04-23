package com.example.Simple_Ecommerce_App.Models;

import com.example.Simple_Ecommerce_App.Enums.UserRole;
import com.example.Simple_Ecommerce_App.Repositries.UserRepo;
import lombok.Data;


@Data
public class AuthenticationResponse {
    private final String jwt;

    private final String userName;

    private final UserRole role;

    private Long userId;

    public AuthenticationResponse(String jwt, UserRole role , String userName, Long userId) {
        this.jwt = jwt;
        this.role= role;
        this.userName=userName;
        this.userId=userId;

    }

    public String getJwt() {
        return jwt;
    }
}

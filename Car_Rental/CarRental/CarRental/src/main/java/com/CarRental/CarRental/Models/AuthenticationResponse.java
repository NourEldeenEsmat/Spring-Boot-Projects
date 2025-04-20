package com.CarRental.CarRental.Models;

import com.CarRental.CarRental.Enums.Role;
import lombok.Data;

@Data
public class AuthenticationResponse {
    private final String jwt;

    private final String userName;

    private final Role role;

    private Long userId;

    public AuthenticationResponse(String jwt,Role role ,String userName,Long userId) {
        this.jwt = jwt;
        this.role= role;
        this.userName=userName;
        this.userId=userId;

    }

    public String getJwt() {
        return jwt;
    }
}

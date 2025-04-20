package com.taskManagementSystem.taskManagementSystem.Models;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;

    // Default constructor for JSON Parsing
    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters
}


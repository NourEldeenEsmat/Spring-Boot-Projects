package com.fullStack.serviceBookingSystem.dto;

import com.fullStack.serviceBookingSystem.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String name;
    private String lastName;
    private String phone;
    private String password;
    private UserRole role;
}

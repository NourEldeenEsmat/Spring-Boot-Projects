package com.CarRental.CarRental.Dto;

import com.CarRental.CarRental.Entity.User;
import com.CarRental.CarRental.Enums.Role;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class UserDto {

    private Long userId;

    private String userName;

    private String userEmail;

    private String userPassword;

    private Role role;
    public User dtoToUser(){
        User user = new User();
        user.setUserEmail(userEmail);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setUserId(userId);
        user.setRole(role);
        return user;
    }
}

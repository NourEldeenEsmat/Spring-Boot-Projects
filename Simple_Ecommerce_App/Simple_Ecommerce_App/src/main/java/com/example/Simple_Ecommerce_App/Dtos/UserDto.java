package com.example.Simple_Ecommerce_App.Dtos;

import com.example.Simple_Ecommerce_App.Entities.User;
import com.example.Simple_Ecommerce_App.Enums.UserRole;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class UserDto {
    @Autowired
    PasswordEncoder encoder;
    private Long userId;
    private String userName;
    private String email;
    private String password;
    private UserRole userRole;

    public User toUser() {
        User user = new User();
        user.setUserName(userName);
        user.setUserRole(userRole);
        user.setEmail(email);
        user.setPassword(encoder.encode(password));
        user.setUserId(userId);
        return user;
    }
}

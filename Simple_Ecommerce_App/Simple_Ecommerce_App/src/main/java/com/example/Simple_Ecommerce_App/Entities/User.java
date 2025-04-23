package com.example.Simple_Ecommerce_App.Entities;

import com.example.Simple_Ecommerce_App.Dtos.UserDto;
import com.example.Simple_Ecommerce_App.Enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  userId;
    private String userName;
    private String email;
    private String password;
    private UserRole userRole;
    public UserDto toDto(){
        UserDto userDto = new UserDto();
        userDto.setUserName(userName);
        userDto.setUserId(userId);
        userDto.setEmail(email);
        userDto.setPassword(password);
        userDto.setUserRole(userRole);
        return userDto;
    }
}

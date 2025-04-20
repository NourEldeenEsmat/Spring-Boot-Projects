package com.CarRental.CarRental.Entity;

import com.CarRental.CarRental.Dto.UserDto;
import com.CarRental.CarRental.Enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;

    private String userEmail;

    private String userPassword;

    private Role role;

    public UserDto userToDto(){
        UserDto userDto = new UserDto();
        userDto.setUserEmail(userEmail);
        userDto.setUserName(userName);
        userDto.setUserPassword(userPassword);
        userDto.setUserId(userId);
        userDto.setRole(role);
        return userDto;
    }
}

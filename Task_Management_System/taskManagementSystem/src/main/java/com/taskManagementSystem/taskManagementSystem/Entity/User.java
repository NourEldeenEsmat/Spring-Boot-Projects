package com.taskManagementSystem.taskManagementSystem.Entity;

import com.taskManagementSystem.taskManagementSystem.Dto.UserDto;
import com.taskManagementSystem.taskManagementSystem.Enums.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;
    private String passWord;
    private Role role;

    public UserDto userToDto() {
        UserDto userDto = new UserDto();
        userDto.setUserName(userName);
        userDto.setPassWord(passWord);
        userDto.setId(userId);
        userDto.setRole(role);
        return userDto;
    }
}

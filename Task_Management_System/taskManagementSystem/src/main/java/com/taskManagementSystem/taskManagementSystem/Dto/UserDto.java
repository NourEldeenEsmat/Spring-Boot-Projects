package com.taskManagementSystem.taskManagementSystem.Dto;

import com.taskManagementSystem.taskManagementSystem.Enums.Role;
import lombok.Data;

@Data
public class UserDto {
    Long id;
    String userName;
    String passWord;
    Role role;
}

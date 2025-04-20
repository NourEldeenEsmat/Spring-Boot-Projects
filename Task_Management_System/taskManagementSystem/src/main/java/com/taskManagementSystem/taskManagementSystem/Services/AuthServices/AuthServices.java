package com.taskManagementSystem.taskManagementSystem.Services.AuthServices;

import com.taskManagementSystem.taskManagementSystem.Dto.UserDto;
import com.taskManagementSystem.taskManagementSystem.Entity.User;
import com.taskManagementSystem.taskManagementSystem.Enums.Role;

public interface AuthServices {
    public User signUp(UserDto userDto);
    public UserDto getUser(String userName);
}

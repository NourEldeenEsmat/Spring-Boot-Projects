package com.example.Simple_Ecommerce_App.Services.AuthServices;

import com.example.Simple_Ecommerce_App.Dtos.UserDto;

import java.util.List;

public interface AuthServices {
    UserDto createUser(UserDto userDto);
    UserDto getUserDto(String userName);
    List<UserDto> getAllUsers();
    void deleteUser(Long userId);

    UserDto getUserById(Long id);

}

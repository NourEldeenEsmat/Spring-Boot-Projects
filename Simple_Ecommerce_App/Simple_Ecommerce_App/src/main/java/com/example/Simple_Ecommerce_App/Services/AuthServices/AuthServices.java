package com.example.Simple_Ecommerce_App.Services.AuthServices;

import com.example.Simple_Ecommerce_App.Dtos.UserDto;

public interface AuthServices {
    UserDto createUser(UserDto userDto);
    UserDto getUserDto(String userName);

}

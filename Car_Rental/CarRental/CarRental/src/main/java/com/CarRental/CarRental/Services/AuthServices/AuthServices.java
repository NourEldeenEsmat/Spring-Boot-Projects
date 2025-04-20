package com.CarRental.CarRental.Services.AuthServices;

import com.CarRental.CarRental.Dto.UserDto;
import org.springframework.stereotype.Service;

public interface AuthServices {
    UserDto createUser(UserDto userDto);
    UserDto getUserDto(String userName);
}

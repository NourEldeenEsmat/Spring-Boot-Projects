package com.CarRental.CarRental.Services.AuthServices;

import com.CarRental.CarRental.Dto.UserDto;
import com.CarRental.CarRental.Entity.User;
import com.CarRental.CarRental.Repositries.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthImp implements AuthServices {
    @Autowired
    AuthRepo authRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserPassword(passwordEncoder.encode(userDto.getUserPassword()));
        User user = authRepo.save(userDto.dtoToUser());
        return user.userToDto();
    }

    public UserDto getUserDto(String email){
        User user = authRepo.findByUserEmail(email);
        return user.userToDto();
    }
}

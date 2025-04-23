package com.example.Simple_Ecommerce_App.Services.AuthServices;

import com.example.Simple_Ecommerce_App.Dtos.UserDto;
import com.example.Simple_Ecommerce_App.Entities.User;
import com.example.Simple_Ecommerce_App.Repositries.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServicesImp implements AuthServices {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder encoder;
    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setPassword(encoder.encode(userDto.getPassword()));
        User user = userRepo.save(userDto.toUser());
        return user.toDto();
    }

    @Override
    public UserDto getUserDto(String userName) {
       User user = userRepo.findByUserName(userName);
        return user.toDto();
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepo.findAll();
        return userList.stream().map(User::toDto).toList();
    }

    @Override
    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }


}

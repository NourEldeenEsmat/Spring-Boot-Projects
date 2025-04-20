package com.taskManagementSystem.taskManagementSystem.Services.AuthServices;

import com.taskManagementSystem.taskManagementSystem.Dto.UserDto;
import com.taskManagementSystem.taskManagementSystem.Entity.User;
import com.taskManagementSystem.taskManagementSystem.Enums.Role;
import com.taskManagementSystem.taskManagementSystem.Repositry.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServicesImp implements AuthServices {
    @Autowired
    AuthRepo authRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public User signUp(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setPassWord(passwordEncoder.encode(userDto.getPassWord()));
        user.setRole(userDto.getRole());
        User savedUser = authRepo.save(user);
        return savedUser ;
    }

    @Override
    public UserDto getUser(String userName) {
        User user = authRepo.findByUserName(userName);
        return user.userToDto();
    }
}

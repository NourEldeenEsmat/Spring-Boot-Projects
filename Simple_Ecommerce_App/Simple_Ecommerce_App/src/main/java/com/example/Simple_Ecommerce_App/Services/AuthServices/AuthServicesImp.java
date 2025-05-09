package com.example.Simple_Ecommerce_App.Services.AuthServices;

import com.example.Simple_Ecommerce_App.Dtos.UserDto;
import com.example.Simple_Ecommerce_App.Entities.User;
import com.example.Simple_Ecommerce_App.Errors.CustomExceptionHandler;
import com.example.Simple_Ecommerce_App.Errors.DoubleRecordException;
import com.example.Simple_Ecommerce_App.Repositries.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthServicesImp implements AuthServices {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDto createUser(UserDto userDto) {
      Optional<User>  user = userRepo.findByEmail(userDto.getEmail());
        if (user.isPresent()) {
            throw new DoubleRecordException("user name is exists");
        } else {
            userDto.setPassword(encoder.encode(userDto.getPassword()));
            User newUser = userRepo.save(userDto.toUser());
            return newUser.toDto();
        }
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

    @Override
    public UserDto getUserById(Long id) {
        return userRepo.findById(id).get().toDto();
    }


}

package com.example.Simple_Ecommerce_App.Services.AuthServices;
import com.example.Simple_Ecommerce_App.Dtos.UserDto;
import com.example.Simple_Ecommerce_App.Entities.User;
import com.example.Simple_Ecommerce_App.Repositries.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServicesImp implements AuthServices{
    @Autowired
    UserRepo userRepo;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user =userRepo.save(userDto.toUser());
        return user.toDto();
    }

    @Override
    public UserDto login(UserDto userDto) {
        return null;
    }
}

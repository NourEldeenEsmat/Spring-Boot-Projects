package com.fullStack.serviceBookingSystem.services.authantcation;

import com.fullStack.serviceBookingSystem.dto.SignupRequestDTO;
import com.fullStack.serviceBookingSystem.dto.UserDto;
import com.fullStack.serviceBookingSystem.entity.User;
import com.fullStack.serviceBookingSystem.enums.UserRole;
import com.fullStack.serviceBookingSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthService{
    @Autowired
    private UserRepository userRepository;
    public UserDto signupClient(SignupRequestDTO signupRequestDTO){
        User user=new User();
        user.setName(signupRequestDTO.getName());
        user.setEmail(signupRequestDTO.getEmail());
        user.setLastName(signupRequestDTO.getLastName());
        user.setPhone(signupRequestDTO.getPhone());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequestDTO.getPassword()));
        user.setRole(UserRole.CLIENT);
        return userRepository.save(user).getDto();
    }
    public boolean presentByEmail(String email){
        return userRepository.findFirstByEmail(email)!=null;
    }
    public UserDto signupCompany(SignupRequestDTO signupRequestDTO){
        User user=new User();
        user.setName(signupRequestDTO.getName());
        user.setEmail(signupRequestDTO.getEmail());
        user.setLastName(signupRequestDTO.getLastName());
        user.setPhone(signupRequestDTO.getPhone());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequestDTO.getPassword()));
        user.setRole(UserRole.COMPANY);
        return userRepository.save(user).getDto();
    }
}

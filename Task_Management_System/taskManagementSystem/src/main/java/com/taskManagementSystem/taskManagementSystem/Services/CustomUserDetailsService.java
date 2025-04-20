package com.taskManagementSystem.taskManagementSystem.Services;

import com.taskManagementSystem.taskManagementSystem.Entity.User;
import com.taskManagementSystem.taskManagementSystem.Repositry.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    AuthRepo authRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = authRepo.findByUserName(username);
        if (user==null){
           throw new  UsernameNotFoundException("user not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user
                .getPassWord(),new ArrayList<>());
    }
}

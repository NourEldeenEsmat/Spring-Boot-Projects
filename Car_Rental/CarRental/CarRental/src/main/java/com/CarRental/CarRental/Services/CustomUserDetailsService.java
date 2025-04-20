package com.CarRental.CarRental.Services;

import com.CarRental.CarRental.Entity.User;
import com.CarRental.CarRental.Repositries.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user =  userRepository.findByUserEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails
                .User(user.getUserName(), user.getUserPassword(), new ArrayList<>());
    }
}

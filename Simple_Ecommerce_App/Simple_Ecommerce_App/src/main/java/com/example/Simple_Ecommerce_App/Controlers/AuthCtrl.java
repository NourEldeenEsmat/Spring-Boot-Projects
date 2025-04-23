package com.example.Simple_Ecommerce_App.Controlers;

import com.example.Simple_Ecommerce_App.Dtos.UserDto;
import com.example.Simple_Ecommerce_App.JwtSecurity.JwtUtils;
import com.example.Simple_Ecommerce_App.Models.AuthenticationRequest;
import com.example.Simple_Ecommerce_App.Models.AuthenticationResponse;
import com.example.Simple_Ecommerce_App.Services.AuthServices.AuthServices;
import com.example.Simple_Ecommerce_App.Services.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthCtrl {
    @Autowired
    AuthServices authServices;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    CustomUserDetails userDetails;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
                    request.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity("userName or password are wrong!!!" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        UserDetails details = userDetails.loadUserByUsername(request.getUsername());
        String jwt = jwtUtils.generateToken(details.getUsername());
        UserDto dto = authServices.getUserDto(details.getUsername());
        return ResponseEntity.ok(new AuthenticationResponse(jwt, dto.getUserRole(),
                dto.getUserName(), dto.getUserId()));
    }

        @PostMapping("/create_account")
    public ResponseEntity<?> createAccount(@RequestBody UserDto userDto) {
        try {
            UserDto dto = authServices.createUser(userDto);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get_all_users")
    public ResponseEntity<?> getAllUsers(){
        try {
            List<UserDto> userDos = authServices.getAllUsers();
            return ResponseEntity.ok(userDos);
        } catch (RuntimeException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete_user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        try {
            authServices.deleteUser(userId);
            return ResponseEntity.ok("deleted");
        } catch (RuntimeException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update_user")
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto){
        try {
            UserDto dto = authServices.createUser(userDto);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

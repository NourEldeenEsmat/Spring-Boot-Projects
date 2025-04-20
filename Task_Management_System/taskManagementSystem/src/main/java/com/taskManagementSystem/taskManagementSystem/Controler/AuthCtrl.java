package com.taskManagementSystem.taskManagementSystem.Controler;

import com.taskManagementSystem.taskManagementSystem.Dto.UserDto;
import com.taskManagementSystem.taskManagementSystem.Entity.User;
import com.taskManagementSystem.taskManagementSystem.Jwt.JwtUtils;
import com.taskManagementSystem.taskManagementSystem.Models.AuthenticationRequest;
import com.taskManagementSystem.taskManagementSystem.Models.AuthenticationResponse;
import com.taskManagementSystem.taskManagementSystem.Services.AuthServices.AuthServices;
import com.taskManagementSystem.taskManagementSystem.Services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthCtrl {
    @Autowired
    AuthServices authServices;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity("userName or password are wrong!!!" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtils.generateToken(userDetails.getUsername());
        UserDto dto = authServices.getUser(userDetails.getUsername());
        return new ResponseEntity(new AuthenticationResponse(jwt, dto.getRole(),
                userDetails.getUsername(), dto.getId()), HttpStatus.ACCEPTED);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserDto userDto) {
        User user = authServices.signUp(userDto);
        return ResponseEntity.ok(user);
    }
}

package com.CarRental.CarRental.Controllers;

import com.CarRental.CarRental.Dto.UserDto;
import com.CarRental.CarRental.Jwt.JwtUtility;
import com.CarRental.CarRental.Models.AuthenticationRequest;
import com.CarRental.CarRental.Models.AuthenticationResponse;
import com.CarRental.CarRental.Services.AuthServices.AuthServices;
import com.CarRental.CarRental.Services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class AuthCtrl {
    @Autowired
    AuthServices authServices;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtility jwtUtil;
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken
            (@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
//            throw new Exception("Incorrect username or password", e);
            return new ResponseEntity("Incorrect username or password = "+e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        UserDto loggedUser = authServices.getUserDto(authenticationRequest.getUsername());
        return ResponseEntity.ok(new AuthenticationResponse(jwt,loggedUser.getRole(),userDetails.getUsername(),loggedUser.getUserId()));
    }

    @PostMapping("/add_user")
    public ResponseEntity<?> signup(@RequestBody UserDto userDto) {
        try {
            UserDto createdUser = authServices.createUser(userDto);
            return ResponseEntity.ok(createdUser);
        } catch (Error error) {
            return new ResponseEntity(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

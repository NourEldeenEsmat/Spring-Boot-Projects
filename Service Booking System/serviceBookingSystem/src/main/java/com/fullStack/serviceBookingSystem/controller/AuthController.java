package com.fullStack.serviceBookingSystem.controller;

import com.fullStack.serviceBookingSystem.Models.AuthRequest;
import com.fullStack.serviceBookingSystem.dto.SignupRequestDTO;
import com.fullStack.serviceBookingSystem.dto.UserDto;
import com.fullStack.serviceBookingSystem.entity.User;
import com.fullStack.serviceBookingSystem.repository.UserRepository;
import com.fullStack.serviceBookingSystem.services.authantcation.AuthService;
import com.fullStack.serviceBookingSystem.utill.JwtUtils;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/authenticate")
    public void createAuthenticationToken(@RequestBody AuthRequest authRequest, HttpServletResponse response)
    throws IOException, JSONException {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword())
            );

            String jwt = jwtUtils.generateToken(authentication.getName());
            User user = userRepository.findFirstByEmail(authentication.getName());
            response.getWriter().write(new JSONObject().put("id",user.getId()).put("role",user.getRole()).toString());
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }

    }

    @PostMapping("/client/signup")
    public ResponseEntity<UserDto> signupClient(@RequestBody SignupRequestDTO signupRequestDTO) {
        if (authService.presentByEmail(signupRequestDTO.getEmail())) {
            return new ResponseEntity<>(new UserDto(), HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto userDto = authService.signupClient(signupRequestDTO);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/company/signup")
    public ResponseEntity<UserDto> signupCompany(@RequestBody SignupRequestDTO signupRequestDTO) {
        if (authService.presentByEmail(signupRequestDTO.getEmail())) {
            return new ResponseEntity<>(new UserDto(), HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto userDto = authService.signupCompany(signupRequestDTO);
        return ResponseEntity.ok(userDto);
    }
}


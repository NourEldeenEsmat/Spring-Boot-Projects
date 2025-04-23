package com.example.Simple_Ecommerce_App.Controlers;

import com.example.Simple_Ecommerce_App.Dtos.UserDto;
import com.example.Simple_Ecommerce_App.Services.AuthServices.AuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthCtrl {
    @Autowired
    AuthServices authServices;
    @PostMapping("/create_account")
    public ResponseEntity<?> createAccount(@RequestBody UserDto userDto){
        try {
            UserDto dto = authServices.createUser(userDto);
            return ResponseEntity.ok(dto);
        }catch (RuntimeException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

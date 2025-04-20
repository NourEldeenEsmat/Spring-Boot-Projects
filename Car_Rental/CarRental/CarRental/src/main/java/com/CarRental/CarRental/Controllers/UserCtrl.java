package com.CarRental.CarRental.Controllers;

import com.CarRental.CarRental.Dto.BookingsDto;
import com.CarRental.CarRental.Dto.CarDto;
import com.CarRental.CarRental.Services.UserSeervices.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.geom.RectangularShape;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class UserCtrl {
    @Autowired
    UserServices userServices;

    @PostMapping("/bookCar")
    public ResponseEntity<?> bookCar(@RequestBody BookingsDto bookingsDto) {
        try {
            BookingsDto bookingsDto1 = userServices.bookCar(bookingsDto);
            if (bookingsDto1 != null)
                return ResponseEntity.ok(bookingsDto1);
            else
                return new ResponseEntity("car is reserved before", HttpStatus.FOUND);
        } catch (Error e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getAllCars")
    public ResponseEntity<?> getAllCars(){
        try {
           List<CarDto> carDtoList = userServices.getAllCars();
           return ResponseEntity.ok(carDtoList);
        }catch (Exception e){
            return new ResponseEntity(e,HttpStatus.BAD_REQUEST );
        }
    }
    @GetMapping("/getUserBookings/{userId}")
    public ResponseEntity<?> getUserBookings(@PathVariable Long userId){
        try
        {
            List<BookingsDto> bookingsDto = userServices.getUserBookings(userId);
            return ResponseEntity.ok(bookingsDto);
        }catch (Exception e){
            return new ResponseEntity(e,HttpStatus.BAD_REQUEST);
        }
    }
}

package com.CarRental.CarRental.Controllers;

import com.CarRental.CarRental.Dto.BookingsDto;
import com.CarRental.CarRental.Dto.CarDto;
import com.CarRental.CarRental.Dto.SearchCarDto;
import com.CarRental.CarRental.Dto.searchedCarList;
import com.CarRental.CarRental.Services.AdminServices.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class AdminCtrl {
    @Autowired
    AdminServices adminServices;

    @PostMapping("/addCar")
    public ResponseEntity<?> addCar
            (@ModelAttribute CarDto carDto,
             @RequestParam("pic") MultipartFile image) {
        byte[] imageBytes = new byte[0];
        try {
            imageBytes = image.getBytes();
            carDto.setImage(imageBytes);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to convert image");
        }
        try {
            CarDto carDto1 = adminServices.postCar(carDto);
            return ResponseEntity.ok(carDto1);
        } catch (Error e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAdminCars/{id}")
    public ResponseEntity<?> getCars(@PathVariable Long id){
       try {
            List<CarDto> adminCars = adminServices.getAdminCars(id);
            return ResponseEntity.ok(adminCars);
        }catch (Error e){
           return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }
    @GetMapping("/getAdminBookings/{id}")
    public ResponseEntity<?> getBookings(@PathVariable Long id){
        try {
            List<BookingsDto> bookingsDtoList = adminServices.getAllAdminBookings(id);
            return ResponseEntity.ok(bookingsDtoList);
        }catch (Error e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/getSearchedList")
    public ResponseEntity<?> getSearchedList(@RequestBody SearchCarDto searchCarDto){
        try {
            searchedCarList carDtoList =adminServices.searchCarList(searchCarDto);
           return ResponseEntity.ok(carDtoList);
        }
        catch (Error e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}

package com.example.Simple_Ecommerce_App.Controlers;

import com.example.Simple_Ecommerce_App.Dtos.ReservationDto;
import com.example.Simple_Ecommerce_App.Services.ClinetServices.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ClientCtrl {
    @Autowired
    private ClientServices clientServices;
    @PostMapping("/create_reservation")
    public ResponseEntity<?> createReservation(@RequestBody ReservationDto reservationDto){
        try {
            ReservationDto dto = clientServices.createReservation(reservationDto);
            return ResponseEntity.ok(dto);
        }catch (RuntimeException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

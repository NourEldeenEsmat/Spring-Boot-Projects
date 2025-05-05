package com.example.Simple_Ecommerce_App.Controlers;

import com.example.Simple_Ecommerce_App.Dtos.ReservationDto;
import com.example.Simple_Ecommerce_App.Services.ClinetServices.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientCtrl {
    @Autowired
    private ClientServices clientServices;

    @PostMapping("/create_reservation")
    public ResponseEntity<?> createReservation(@RequestBody ReservationDto reservationDto) {
        try {
            ReservationDto dto = clientServices.createReservation(reservationDto);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-reservations-by-user-id/{id}")
    public ResponseEntity<?> getUserReservations(@PathVariable Long id) {
        return ResponseEntity.ok(clientServices.getAllUserReservations(id));
    }

    @GetMapping("search-products")
    public ResponseEntity<?> search(@RequestParam String pName, @RequestParam Double price) {
        return ResponseEntity
                .ok(clientServices.searchProducts(pName, price));
    }

}

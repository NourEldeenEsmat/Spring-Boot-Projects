package com.fullStack.serviceBookingSystem.controller;

import com.fullStack.serviceBookingSystem.dto.AddDto;
import com.fullStack.serviceBookingSystem.dto.ReserveDto;
import com.fullStack.serviceBookingSystem.entity.Reservation;
import com.fullStack.serviceBookingSystem.enums.ReserveStates;
import com.fullStack.serviceBookingSystem.services.company.CompanyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ClientController {
    @Autowired
    private CompanyServices companyServices;

    @GetMapping("/adds")
    public ResponseEntity<?> addsList() {
        return ResponseEntity.ok(companyServices.addDtoList());
    }

    @PostMapping("create_adds/{id}")
    public ResponseEntity<?> createAdd(@PathVariable Long id,
                                       @ModelAttribute AddDto addDto,
                                       @RequestParam("pic") MultipartFile image) {
        byte[] imageBytes = new byte[0];
        try {
            imageBytes = image.getBytes();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to convert image");
        }
        boolean createdAdd = companyServices.adds(id, addDto, imageBytes);
        return ResponseEntity.ok(createdAdd);
    }

    @GetMapping("getAddsByCompanyId/{id}")
    public ResponseEntity<?> getAddsByCompanyId(@PathVariable Long id) {
        return ResponseEntity.ok(companyServices.companyAddsList(id));
    }

    @DeleteMapping("deleteAdd/{id}")
    public void deleteAdd(@PathVariable Long id)throws RuntimeException {
       boolean deleted = companyServices.deleteAdd(id);
    }
    @GetMapping("getAd/{id}")
    public ResponseEntity<?> getAd(@PathVariable Long id){
        return ResponseEntity.ok(companyServices.selectedAd(id));
    }
    @GetMapping("getReservationsByCompanyId/{id}")
    public ResponseEntity<?> getAllCompanyReservations(@PathVariable Long id){
        return ResponseEntity.ok(companyServices.getAllCompanyReservations(id));
    }
    @PostMapping("company_action/{id}")
    public ResponseEntity<?> companyAction(@PathVariable Long id, @RequestBody ReserveStates reserveStates){
       ReserveDto reserveDto =  companyServices.companyAction(id,reserveStates);
        return ResponseEntity.ok(reserveDto);
    }
    @GetMapping("getReservationsByClientId/{id}")
    public ResponseEntity<?> getAllClientReservations(@PathVariable Long id){
        return ResponseEntity.ok(companyServices.getAllUserReservations(id));
    }
    @GetMapping("getUserById/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        return ResponseEntity.ok(companyServices.getUserById(id));
    }
    @PostMapping("bookAd")
    public ResponseEntity<?> bookAd(@RequestBody ReserveDto reserveDto){
     try {
            ReserveDto dto = companyServices.postReservation(reserveDto);
            return ResponseEntity.ok(dto);
        }catch (Error e){
         throw new RuntimeException(e);
     }
    }
    @DeleteMapping("deleteReservationById/{id}")
    public void deleteRReservation(@PathVariable Long id){
        try {
            companyServices.deleteReservation(id);
        }catch (Error e){
            throw new RuntimeException(e);
        }
    }
    @GetMapping("getReservation/{id}")
    public ResponseEntity<?> getReservation(@PathVariable Long id){
       try {
            ReserveDto reserveDto = companyServices.getReservation(id);
            return ResponseEntity.ok(reserveDto);
        }catch (Error e){
           throw new RuntimeException(e);
       }
    }
}

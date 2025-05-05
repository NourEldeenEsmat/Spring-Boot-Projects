package com.example.Simple_Ecommerce_App.Services.ClinetServices;

import com.example.Simple_Ecommerce_App.Dtos.ProductDto;
import com.example.Simple_Ecommerce_App.Dtos.ReservationDto;
import com.example.Simple_Ecommerce_App.Entities.Reservation;
import com.example.Simple_Ecommerce_App.Entities.User;
import com.example.Simple_Ecommerce_App.Repositries.ReservationRepo;
import com.example.Simple_Ecommerce_App.Services.AdminServices.AdminServices;
import com.example.Simple_Ecommerce_App.Services.AuthServices.AuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServicesImp implements ClientServices {
    @Autowired
    ReservationRepo reservationRepo;
    @Autowired
    AuthServices authServices;
    @Autowired
    AdminServices adminServices;

    @Override
    public ReservationDto createReservation(ReservationDto reservationDto) {
        Reservation savedReservation = reservationRepo.save(reservationDto.toReservation());
        return savedReservation.toDto();
    }

    @Override
    public List<ReservationDto> getAllUserReservations(Long userId) {
        User user = authServices.getUserById(userId).toUser();
        return reservationRepo.findByUser(user).stream().map(Reservation::toDto).toList();
    }

    @Override
    public List<ProductDto> searchProducts(String pName, Double price) {
        return adminServices.searchProduct(pName,price);
    }

}

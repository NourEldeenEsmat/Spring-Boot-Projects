package com.example.Simple_Ecommerce_App.Services.ClinetServices;

import com.example.Simple_Ecommerce_App.Dtos.ProductDto;
import com.example.Simple_Ecommerce_App.Dtos.ReservationDto;
import com.example.Simple_Ecommerce_App.Entities.Reservation;

import java.util.List;

public interface ClientServices {
    ReservationDto createReservation(ReservationDto reservationDto);

    List<ReservationDto> getAllUserReservations(Long userId);

    public List<ProductDto> searchProducts(String pName,Double price);
}

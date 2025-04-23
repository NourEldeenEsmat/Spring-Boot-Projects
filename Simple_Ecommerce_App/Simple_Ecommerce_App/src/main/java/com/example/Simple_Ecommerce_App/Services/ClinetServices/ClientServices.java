package com.example.Simple_Ecommerce_App.Services.ClinetServices;

import com.example.Simple_Ecommerce_App.Dtos.ReservationDto;
import com.example.Simple_Ecommerce_App.Entities.Reservation;

public interface ClientServices {
    public ReservationDto createReservation(ReservationDto reservationDto);
}

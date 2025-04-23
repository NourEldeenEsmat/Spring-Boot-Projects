package com.example.Simple_Ecommerce_App.Dtos;

import com.example.Simple_Ecommerce_App.Entities.Reservation;
import lombok.Data;

@Data
public class ReservationDto {
    private Long reservationId;
    private Double reservationNumber;
    private Long userId;
    private Long productId;
    public Reservation toReservation(){
        Reservation reservation = new Reservation();
        reservation.setReservationId(reservationId);
        reservation.setReservationNumber(reservationNumber);
        return reservation;
    }
}

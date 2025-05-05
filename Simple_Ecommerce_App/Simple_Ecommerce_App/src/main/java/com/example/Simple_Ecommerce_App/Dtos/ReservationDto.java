package com.example.Simple_Ecommerce_App.Dtos;

import com.example.Simple_Ecommerce_App.Entities.Product;
import com.example.Simple_Ecommerce_App.Entities.Reservation;
import com.example.Simple_Ecommerce_App.Entities.User;
import lombok.Data;

@Data
public class ReservationDto {
    private Long reservationId;
    private Double reservationNumber;
    private User user;
    private Product product;
    public Reservation toReservation(){
        Reservation reservation = new Reservation();
        reservation.setReservationId(reservationId);
        reservation.setReservationNumber(reservationNumber);
        reservation.setUser(user);
        reservation.setProduct(product);
        return reservation;
    }
}

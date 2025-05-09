package com.example.Simple_Ecommerce_App.Entities;

import com.example.Simple_Ecommerce_App.Dtos.ReservationDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "reservations")
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;
    private Double reservationNumber;
    @ManyToOne
    @JoinColumn(name = "userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    @ManyToOne
    @JoinColumn(name = "productId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;
    public ReservationDto toDto(){
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setReservationId(reservationId);
        reservationDto.setProduct(product);
        reservationDto.setReservationNumber(reservationNumber);
        reservationDto.setUser(user);
        return reservationDto;
    }
}

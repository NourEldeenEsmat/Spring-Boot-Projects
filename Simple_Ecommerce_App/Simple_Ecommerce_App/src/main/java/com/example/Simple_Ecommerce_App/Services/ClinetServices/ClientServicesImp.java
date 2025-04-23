package com.example.Simple_Ecommerce_App.Services.ClinetServices;

import com.example.Simple_Ecommerce_App.Dtos.ReservationDto;
import com.example.Simple_Ecommerce_App.Entities.Product;
import com.example.Simple_Ecommerce_App.Entities.Reservation;
import com.example.Simple_Ecommerce_App.Entities.User;
import com.example.Simple_Ecommerce_App.Repositries.ProductRepo;
import com.example.Simple_Ecommerce_App.Repositries.ReservationRepo;
import com.example.Simple_Ecommerce_App.Repositries.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClientServicesImp implements ClientServices {
    @Autowired
    ReservationRepo reservationRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    ProductRepo productRepo;

    @Override
    public ReservationDto createReservation(ReservationDto reservationDto) {
        Optional<Product> product = productRepo.findById(reservationDto.getProductId());
        Optional<User> user = userRepo.findById(reservationDto.getUserId());
        Reservation reservation = reservationDto.toReservation();
        reservation.setProduct(product.get());
        reservation.setUser(user.get());
        product.get().setReserved(true);
        productRepo.save(product.get());
        Reservation savedReservation = reservationRepo.save(reservation);
        return savedReservation.toDto();
    }
}

package com.example.Simple_Ecommerce_App.Repositries;

import com.example.Simple_Ecommerce_App.Entities.Reservation;
import com.example.Simple_Ecommerce_App.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation,Long> {
    List<Reservation> findByUser(User user);
}

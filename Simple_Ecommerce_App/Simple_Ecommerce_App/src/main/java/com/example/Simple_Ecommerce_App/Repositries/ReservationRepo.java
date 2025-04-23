package com.example.Simple_Ecommerce_App.Repositries;

import com.example.Simple_Ecommerce_App.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation,Long> {
}

package com.CarRental.CarRental.Repositries;

import com.CarRental.CarRental.Entity.Bookings;
import com.CarRental.CarRental.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Bookings,Long> {
    List<Bookings> findByUser(User user);
    List<Bookings> findByAdmin(User user);
}

package com.CarRental.CarRental.Repositries;

import com.CarRental.CarRental.Entity.Car;
import com.CarRental.CarRental.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car,Long> {
  List<Car> findByAdmin(User user);
}

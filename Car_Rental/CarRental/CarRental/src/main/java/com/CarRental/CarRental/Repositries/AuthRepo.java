package com.CarRental.CarRental.Repositries;

import com.CarRental.CarRental.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepo extends JpaRepository<User,Long> {

    User findByUserEmail(String username);
}

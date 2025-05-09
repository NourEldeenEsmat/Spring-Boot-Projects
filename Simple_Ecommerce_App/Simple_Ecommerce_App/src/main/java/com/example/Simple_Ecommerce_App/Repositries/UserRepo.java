package com.example.Simple_Ecommerce_App.Repositries;

import com.example.Simple_Ecommerce_App.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findByUserName(String userName);
    Optional<User> findByEmail(String email);
}

package com.taskManagementSystem.taskManagementSystem.Repositry;

import com.taskManagementSystem.taskManagementSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepo extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}

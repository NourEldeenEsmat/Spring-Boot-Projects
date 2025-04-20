package com.fullStack.serviceBookingSystem.repository;

import com.fullStack.serviceBookingSystem.entity.Adds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddRepo extends JpaRepository<Adds,Long>
{
    List<Adds> findByUserId(Long userId);
    List<Adds> findByisReserved(boolean isReserved);
}
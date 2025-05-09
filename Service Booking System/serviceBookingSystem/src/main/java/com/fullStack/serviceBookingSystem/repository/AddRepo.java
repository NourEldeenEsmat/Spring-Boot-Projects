package com.fullStack.serviceBookingSystem.repository;

import com.fullStack.serviceBookingSystem.entity.Ads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddRepo extends JpaRepository<Ads,Long>
{
    List<Ads> findByUserId(Long userId);
    List<Ads> findByisReserved(boolean isReserved);
}
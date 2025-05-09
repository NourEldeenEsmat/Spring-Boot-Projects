package com.fullStack.serviceBookingSystem.repository;

import com.fullStack.serviceBookingSystem.entity.Ads;
import com.fullStack.serviceBookingSystem.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReservationRepo extends JpaRepository<Reservation,Long> {
    List<Reservation> findByCompanyId(Long id);
    List<Reservation> findByUserId(Long id);
    Reservation findByAdds(Ads ad);
}

package com.fullStack.serviceBookingSystem.services.company;

import com.fullStack.serviceBookingSystem.dto.AdDto;
import com.fullStack.serviceBookingSystem.dto.ReserveDto;
import com.fullStack.serviceBookingSystem.dto.UserDto;
import com.fullStack.serviceBookingSystem.entity.Ads;
import com.fullStack.serviceBookingSystem.entity.Reservation;
import com.fullStack.serviceBookingSystem.entity.User;
import com.fullStack.serviceBookingSystem.enums.ReserveStates;
import com.fullStack.serviceBookingSystem.repository.AddRepo;
import com.fullStack.serviceBookingSystem.repository.ReservationRepo;
import com.fullStack.serviceBookingSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyServicesImpl implements CompanyServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddRepo addRepo;

    @Autowired
    private ReservationRepo reservationRepo;

    public boolean adds(Long userId, AdDto addDto, byte[] image) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            Ads add = new Ads();
            add.setImage(image);
            add.setPrice(addDto.getPrice());
            add.setServiceName(addDto.getServiceName());
            add.setServiceDetails(addDto.getServiceDetails());
            add.setUser(user.get());
            addRepo.save(add);
            return true;
        }
        return false;
    }

    public List<AdDto> addDtoList() {
        List<Ads> adds = addRepo.findByisReserved(false);
        return adds.stream().map(add -> add.addDto())
                .collect(Collectors.toList());
    }

    public List<AdDto> companyAddsList(Long id) {
        List<Ads> adds = addRepo.findByUserId(id);
        return adds.stream().map(add -> add.addDto())
                .collect(Collectors.toList());
    }

    public boolean deleteAdd(Long id) {
        try {
            addRepo.deleteById(id);
            return true;
        } catch (Error e) {
            throw new RuntimeErrorException(e);
        }
    }

    public AdDto selectedAd(Long adId) {
        Optional<Ads> add = addRepo.findById(adId);
        return add.get().addDto();
    }

    public List<ReserveDto> getAllCompanyReservations(Long id) {
        List<Reservation> reservations = reservationRepo.findByCompanyId(id);
        return reservations.stream().map(Reservation::toDto).toList();
    }

    public ReserveDto companyAction(Long id, ReserveStates reserveStates) {
        Optional<Reservation> reservation = reservationRepo.findById(id);
        Optional<Ads> ad = addRepo.findById(reservation.get().getAdds().getAddId());
        reservation.get().setState(reserveStates);
        reservationRepo.save(reservation.get());
        if (reserveStates.name().equals("REJECTED")) {
            ad.get().setReserved(false);
            addRepo.save(ad.get());
        }
        return reservation.get().toDto();
    }

    public List<ReserveDto> getAllUserReservations(Long id) {
        List<Reservation> reservations = reservationRepo.findByUserId(id);
        return reservations.stream().map(Reservation::toDto).toList();
    }

    public UserDto getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get().getDto();
    }

    public ReserveDto postReservation(ReserveDto reserveDto) {
        Optional<User> user = userRepository.findById(reserveDto.getUserId());
        Optional<User> company = userRepository.findById(reserveDto.getCompanyId());
        Optional<Ads> adds = addRepo.findById(reserveDto.getAdId());
        Reservation reservation = new Reservation();

        adds.get().setReserved(true);
        Ads savedAd = addRepo.save(adds.get());

        reservation.setAdds(savedAd);
        reservation.setUser(user.get());
        reservation.setState(reserveDto.getState());
        reservation.setCompany(company.get());
        reservation.setDate(reserveDto.getDate());
        reservationRepo.save(reservation);
        return reservation.toDto();
    }

    public void deleteReservation(Long id) {
        Optional<Reservation> reservation = reservationRepo.findById(id);
        Optional<Ads> adds = addRepo.findById(reservation.get().getAdds().getAddId());
        adds.get().setReserved(false);
        addRepo.save(adds.get());
        reservationRepo.deleteById(id);
    }

    public ReserveDto getReservation(Long id) {
        Optional<Reservation> reservation = reservationRepo.findById(id);
        return reservation.get().toDto();
    }
}

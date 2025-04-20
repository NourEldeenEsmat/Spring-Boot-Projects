package com.fullStack.serviceBookingSystem.services.company;

import com.fullStack.serviceBookingSystem.dto.AddDto;
import com.fullStack.serviceBookingSystem.dto.ReserveDto;
import com.fullStack.serviceBookingSystem.dto.UserDto;
import com.fullStack.serviceBookingSystem.entity.Reservation;
import com.fullStack.serviceBookingSystem.entity.User;
import com.fullStack.serviceBookingSystem.enums.ReserveStates;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CompanyServices {
    public  boolean adds(Long userId, AddDto addDto, byte[] image);
    public  List<AddDto> addDtoList() ;
    public List<AddDto> companyAddsList(Long id);
    public boolean deleteAdd(Long id);
    public AddDto selectedAd(Long adId);
    public List<ReserveDto> getAllCompanyReservations(Long id);
    public ReserveDto companyAction(Long id, ReserveStates reserveStates);
    public List<ReserveDto> getAllUserReservations(Long id);
    public UserDto getUserById(Long id);
    public ReserveDto postReservation(ReserveDto reserveDto);
    public void deleteReservation(Long id);
    public ReserveDto getReservation(Long id);
}

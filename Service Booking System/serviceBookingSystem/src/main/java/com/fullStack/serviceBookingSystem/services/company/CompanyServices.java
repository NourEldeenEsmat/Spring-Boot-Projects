package com.fullStack.serviceBookingSystem.services.company;

import com.fullStack.serviceBookingSystem.dto.AdDto;
import com.fullStack.serviceBookingSystem.dto.ReserveDto;
import com.fullStack.serviceBookingSystem.dto.UserDto;
import com.fullStack.serviceBookingSystem.enums.ReserveStates;

import java.util.List;

public interface CompanyServices {
    public  boolean adds(Long userId, AdDto addDto, byte[] image);
    public  List<AdDto> addDtoList() ;
    public List<AdDto> companyAddsList(Long id);
    public boolean deleteAdd(Long id);
    public AdDto selectedAd(Long adId);
    public List<ReserveDto> getAllCompanyReservations(Long id);
    public ReserveDto companyAction(Long id, ReserveStates reserveStates);
    public List<ReserveDto> getAllUserReservations(Long id);
    public UserDto getUserById(Long id);
    public ReserveDto postReservation(ReserveDto reserveDto);
    public void deleteReservation(Long id);
    public ReserveDto getReservation(Long id);
}

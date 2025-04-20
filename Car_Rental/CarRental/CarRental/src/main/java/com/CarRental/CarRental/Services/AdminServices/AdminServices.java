package com.CarRental.CarRental.Services.AdminServices;

import com.CarRental.CarRental.Dto.BookingsDto;
import com.CarRental.CarRental.Dto.CarDto;
import com.CarRental.CarRental.Dto.SearchCarDto;
import com.CarRental.CarRental.Dto.searchedCarList;

import java.util.List;

public interface AdminServices {
    CarDto postCar(CarDto carDto);
    public List<CarDto> getAdminCars(Long adminId);

    List<BookingsDto> getAllAdminBookings(Long adminId);

    searchedCarList searchCarList(SearchCarDto searchCarDto);
}

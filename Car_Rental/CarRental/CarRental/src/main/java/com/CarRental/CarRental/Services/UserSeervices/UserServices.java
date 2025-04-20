package com.CarRental.CarRental.Services.UserSeervices;

import com.CarRental.CarRental.Dto.BookingsDto;
import com.CarRental.CarRental.Dto.CarDto;

import java.util.List;

public interface UserServices {
    public BookingsDto bookCar(BookingsDto bookingsDto);
    public List<CarDto> getAllCars();
    public List<BookingsDto> getUserBookings(Long userId);
}

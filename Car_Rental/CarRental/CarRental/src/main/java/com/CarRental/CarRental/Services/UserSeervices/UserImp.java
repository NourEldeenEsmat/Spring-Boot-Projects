package com.CarRental.CarRental.Services.UserSeervices;

import com.CarRental.CarRental.Dto.BookingsDto;
import com.CarRental.CarRental.Dto.CarDto;
import com.CarRental.CarRental.Entity.Bookings;
import com.CarRental.CarRental.Entity.Car;
import com.CarRental.CarRental.Entity.User;
import com.CarRental.CarRental.Repositries.AuthRepo;
import com.CarRental.CarRental.Repositries.BookRepo;
import com.CarRental.CarRental.Repositries.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImp implements UserServices {
    @Autowired
    BookRepo bookRepo;
    @Autowired
    AuthRepo authRepo;
    @Autowired
    CarRepo carRepo;

    @Override
    public BookingsDto bookCar(BookingsDto bookingsDto) {
        Optional<Car> car = carRepo.findById(bookingsDto.getCarId());

        if (car.get().getBookings() == null) {
            Optional<User> admin = authRepo.findById(bookingsDto.getAdminId());
            Optional<User> user = authRepo.findById(bookingsDto.getUserId());
            Bookings book = bookingsDto.dtoToBookings();
            book.setCar(car.get());
            book.setUser(user.get());
            book.setAdmin(admin.get());
            Bookings booked = bookRepo.save(book);
            car.get().setBookings(booked);
            carRepo.save(car.get());
            return booked.toDto();
        }
        return null;
    }
    public List<CarDto> getAllCars(){
        List<Car> cars = carRepo.findAll();
        List<CarDto> carsDto = cars.stream().map(Car::carDto).toList();
        return carsDto;
    }
    public List<BookingsDto> getUserBookings(Long userId){
        Optional<User> user = authRepo.findById(userId);
       List<Bookings> userBookings = bookRepo.findByUser(user.get());
       List<BookingsDto> bookingsDto = userBookings.stream().map(Bookings::toDto).toList();
       return bookingsDto;
    }
}

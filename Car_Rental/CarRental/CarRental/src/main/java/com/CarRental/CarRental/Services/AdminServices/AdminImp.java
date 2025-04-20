package com.CarRental.CarRental.Services.AdminServices;

import com.CarRental.CarRental.Dto.BookingsDto;
import com.CarRental.CarRental.Dto.CarDto;
import com.CarRental.CarRental.Dto.SearchCarDto;
import com.CarRental.CarRental.Dto.searchedCarList;
import com.CarRental.CarRental.Entity.Bookings;
import com.CarRental.CarRental.Entity.Car;
import com.CarRental.CarRental.Entity.User;
import com.CarRental.CarRental.Repositries.AuthRepo;
import com.CarRental.CarRental.Repositries.BookRepo;
import com.CarRental.CarRental.Repositries.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminImp implements AdminServices {
    @Autowired
    CarRepo carRepo;
    @Autowired
    AuthRepo authRepo;
    @Autowired
    BookRepo bookRepo;

    @Override
    public CarDto postCar(CarDto carDto) {
        Car car = carDto.dtoToCar();
        Optional<User> admin = authRepo.findById(carDto.getAdminId());
        car.setAdmin(admin.get());
        carRepo.save(car);
        return car.carDto();
    }

    public List<CarDto> getAdminCars(Long adminId) {
        Optional<User> user = authRepo.findById(adminId);
       List<Car> cars = carRepo.findByAdmin(user.get());
       List<CarDto> carDtoList = cars.stream().map(car -> car.carDto()).toList();
       return carDtoList;
    }

    @Override
    public List<BookingsDto> getAllAdminBookings(Long adminId) {
        Optional<User> user=authRepo.findById(adminId);
        List<Bookings> AdminBookings = bookRepo.findByAdmin(user.get());
        return AdminBookings.stream()
                .map(Bookings::toDto).toList();
    }

    @Override
    public searchedCarList searchCarList(SearchCarDto searchCarDto) {
        Car car = new Car();
        car.setCarName(searchCarDto.getCarName());
        car.setType(searchCarDto.getType());
        car.setModel(searchCarDto.getModel());
        car.setColor(searchCarDto.getColor());
        ExampleMatcher exampleMatcher=ExampleMatcher.matchingAll()
                .withMatcher("carName",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("color",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("model",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("type",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        Example<Car> carExample=Example.of(car,exampleMatcher);
        List<Car> carList=carRepo.findAll(carExample);
        searchedCarList searchedCarList = new searchedCarList();
        searchedCarList.setCarDtoList(carList.stream().map(Car::carDto).collect(Collectors.toList()));
        return searchedCarList;
    }
}

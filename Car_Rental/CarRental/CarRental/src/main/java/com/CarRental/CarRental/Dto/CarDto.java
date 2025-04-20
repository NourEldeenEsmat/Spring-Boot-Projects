package com.CarRental.CarRental.Dto;

import com.CarRental.CarRental.Entity.Car;
import lombok.Data;

@Data
public class CarDto {
    private Long carId;
    private String carName;
    private String color;
    private Double price;
    private String model;
    private String type;
    private int year;
    private byte[] image;
    private Long adminId;
    private Long bookId;

    public Car dtoToCar() {
        Car car = new Car();
        car.setCarId(carId);
        car.setCarName(carName);
        car.setColor(color);
        car.setPrice(price);
        car.setType(type);
        car.setModel(model);
        car.setYear(year);
        car.setImage(image);
        car.setAdmin(null);
        car.setBookings(null);
        return car;
    }
}

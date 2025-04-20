package com.CarRental.CarRental.Entity;

import com.CarRental.CarRental.Dto.CarDto;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "cars")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;
    private String carName;
    private String color;
    private Double price;
    private String model;
    private String type;
    private int year;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] image;
    @ManyToOne
    @JoinColumn(name = "userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User admin;

    @ManyToOne
    @JoinColumn(name = "bookId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Bookings bookings;
   public CarDto carDto(){
        CarDto dto=new CarDto();
        dto.setCarId(carId);
        dto.setCarName(carName);
        dto.setModel(model);
        dto.setImage(image);
        dto.setColor(color);
        dto.setPrice(price);
        dto.setType(type);
        dto.setYear(year);
        dto.setAdminId(admin.getUserId());
        if (bookings!=null)
        dto.setBookId(bookings.getBookId());
        return dto;
    }
}

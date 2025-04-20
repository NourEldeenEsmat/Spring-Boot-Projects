package com.CarRental.CarRental.Entity;

import com.CarRental.CarRental.Dto.BookingsDto;
import com.CarRental.CarRental.Enums.BookState;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.service.annotation.DeleteExchange;

@Entity
@Table(name = "bookings")
@Data
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String startDate;
    private String endDate;
    private BookState state;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "adminId")
    private User admin;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "carId")
    private Car car;

    public BookingsDto toDto(){
        BookingsDto bookingsDto = new BookingsDto();
        bookingsDto.setBookId(bookId);
        bookingsDto.setUserId(user.getUserId());
        bookingsDto.setCarId(car.getCarId());
        bookingsDto.setState(state);
        bookingsDto.setStartDate(startDate);
        bookingsDto.setEndDate(endDate);
        bookingsDto.setAdminId(admin.getUserId());
        return bookingsDto;
    }
}

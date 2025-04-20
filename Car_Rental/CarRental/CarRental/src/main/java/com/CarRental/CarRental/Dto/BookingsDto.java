package com.CarRental.CarRental.Dto;

import com.CarRental.CarRental.Entity.Bookings;
import com.CarRental.CarRental.Enums.BookState;
import lombok.Data;

@Data
public class BookingsDto {
    private Long bookId;
    private String startDate;
    private String endDate;
    private BookState state;
    private Long userId;
    private Long adminId;
    private Long carId;

    public Bookings dtoToBookings() {
        Bookings bookings = new Bookings();
        bookings.setUser(null);
        bookings.setBookId(bookId);
        bookings.setState(state);
        bookings.setStartDate(startDate);
        bookings.setEndDate(endDate);
        bookings.setAdmin(null);
        bookings.setCar(null);
        return bookings;
    }
}

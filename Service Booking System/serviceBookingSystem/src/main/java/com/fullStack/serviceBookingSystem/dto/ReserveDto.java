package com.fullStack.serviceBookingSystem.dto;

import com.fullStack.serviceBookingSystem.entity.Reservation;
import com.fullStack.serviceBookingSystem.enums.ReserveStates;
import lombok.Data;

import java.util.Date;
@Data
public class ReserveDto {

    private Long reserveId;

    private Long userId;

    private Long companyId;

    private Long adId;

    private String date;

    private ReserveStates state;
}

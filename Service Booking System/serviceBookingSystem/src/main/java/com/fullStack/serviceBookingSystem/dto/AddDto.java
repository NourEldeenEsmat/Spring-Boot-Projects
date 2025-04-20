package com.fullStack.serviceBookingSystem.dto;

import com.fullStack.serviceBookingSystem.entity.User;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class AddDto {
    private Long id;

    private String serviceName;

    private String serviceDetails;

    private Double price;

    private byte[] image;

    private Long userId;

    private String companyName;

    private boolean isReserved;
}

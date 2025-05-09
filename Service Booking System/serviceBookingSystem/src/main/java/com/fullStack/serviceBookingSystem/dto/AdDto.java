package com.fullStack.serviceBookingSystem.dto;

import lombok.Data;

@Data
public class AdDto {
    private Long id;

    private String serviceName;

    private String serviceDetails;

    private Double price;

    private byte[] image;

    private Long userId;

	private String companyName;

    private boolean isReserved;
}

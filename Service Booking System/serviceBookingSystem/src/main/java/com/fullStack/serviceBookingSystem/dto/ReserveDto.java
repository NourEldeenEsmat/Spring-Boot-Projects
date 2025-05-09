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

	public Long getReserveId() {
		return reserveId;
	}

	public void setReserveId(Long reserveId) {
		this.reserveId = reserveId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getAdId() {
		return adId;
	}

	public void setAdId(Long adId) {
		this.adId = adId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ReserveStates getState() {
		return state;
	}

	public void setState(ReserveStates state) {
		this.state = state;
	}
}

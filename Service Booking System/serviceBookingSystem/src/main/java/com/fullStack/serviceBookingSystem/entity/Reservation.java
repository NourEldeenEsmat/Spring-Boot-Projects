package com.fullStack.serviceBookingSystem.entity;

import com.fullStack.serviceBookingSystem.dto.ReserveDto;
import com.fullStack.serviceBookingSystem.enums.ReserveStates;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "reservations")
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action =  OnDeleteAction.CASCADE)
    private User user;
    @OneToOne
    @JoinColumn(name = "addId")
    @OnDelete(action =  OnDeleteAction.CASCADE)
    private Adds adds;
    @ManyToOne
    @JoinColumn(name = "company_id")
    @OnDelete(action =  OnDeleteAction.CASCADE)
    private User company;

    private String date;

    private ReserveStates state;

    public ReserveDto toDto() {
        ReserveDto reserveDto = new ReserveDto();

        reserveDto.setReserveId(getId());
        reserveDto.setDate(getDate());
        reserveDto.setAdId(adds.getAddId());
        reserveDto.setUserId(user.getId());
        reserveDto.setState(getState());
        reserveDto.setCompanyId(company.getId());

        return reserveDto;
    }
}

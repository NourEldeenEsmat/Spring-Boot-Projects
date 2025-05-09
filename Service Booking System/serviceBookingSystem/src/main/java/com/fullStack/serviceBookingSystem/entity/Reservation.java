package com.fullStack.serviceBookingSystem.entity;

import com.fullStack.serviceBookingSystem.dto.ReserveDto;
import com.fullStack.serviceBookingSystem.enums.ReserveStates;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "reservations")
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
    private Ads adds;
    @ManyToOne
    @JoinColumn(name = "company_id")
    @OnDelete(action =  OnDeleteAction.CASCADE)
    private User company;

    private String date;

    private ReserveStates state;

    public ReserveDto toDto() {
        ReserveDto reserveDto = new ReserveDto();

        reserveDto.setReserveId(id);
        reserveDto.setDate(date);
        reserveDto.setAdId(id);
        reserveDto.setUserId(id);
        reserveDto.setState(state);
        reserveDto.setCompanyId(company.getId());

        return reserveDto;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Ads getAdds() {
		return adds;
	}

	public void setAdds(Ads adds) {
		this.adds = adds;
	}

	public User getCompany() {
		return company;
	}

	public void setCompany(User company) {
		this.company = company;
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

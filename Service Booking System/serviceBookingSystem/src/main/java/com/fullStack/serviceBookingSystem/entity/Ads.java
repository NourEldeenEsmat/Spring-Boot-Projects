package com.fullStack.serviceBookingSystem.entity;

import com.fullStack.serviceBookingSystem.dto.AdDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "adds")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addId;

    private String serviceName;

    private String serviceDetails;

    private Double price;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] image;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    private boolean isReserved;
    public AdDto addDto() {
    	AdDto addDto = new AdDto();
    	addDto.setCompanyName(user.getName());
    	addDto.setId(getAddId());
    	addDto.setImage(getImage());
    	addDto.setPrice(getPrice());
    	addDto.setReserved(isReserved());
addDto.setServiceDetails(serviceDetails);
addDto.setServiceName(serviceName);
addDto.setUserId(user.getId());

        return addDto;
    }
	public Long getAddId() {
		return addId;
	}
	public void setAddId(Long addId) {
		this.addId = addId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceDetails() {
		return serviceDetails;
	}
	public void setServiceDetails(String serviceDetails) {
		this.serviceDetails = serviceDetails;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isReserved() {
		return isReserved;
	}
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
    
}

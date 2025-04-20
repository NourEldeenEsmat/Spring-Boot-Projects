package com.fullStack.serviceBookingSystem.entity;

import com.fullStack.serviceBookingSystem.dto.AddDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "adds")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Adds {
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
    public AddDto addDto(Adds adds) {
        return AddDto.builder()
                .id(adds.getAddId())
                .serviceName(adds.getServiceName())
                .price(adds.getPrice())
                .serviceDetails(adds.getServiceDetails())
                .image(adds.getImage())
                .companyName(adds.user.getName())
                .userId(adds.user.getId())
                .isReserved(adds.isReserved())
                .build();
    }
}

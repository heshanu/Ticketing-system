package com.example.tikecktingSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Vehicle")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "user")
@ToString(exclude = "user")
public class VehicleEntity {
    @Id
    private String registrationNumber;
    private String vehicleChassisNumber;
    private String vehicleType;
    private String vehicleModel;
    private String vehicleYear;
    private String vehicleColor;
    private String vehicleEngine;
    private String vehicleFuelType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_nic")
    private UserEntity user;
}

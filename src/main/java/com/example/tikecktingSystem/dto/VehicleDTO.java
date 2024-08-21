package com.example.tikecktingSystem.dto;

import com.example.tikecktingSystem.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleDTO {
    private String registrationNumber;
    private String vehicleChassisNumber;
    private String vehicleType;
    private String vehicleModel;
    private String vehicleYear;
    private String vehicleColor;
    private String vehicleEngine;
    private String vehicleFuelType;
}

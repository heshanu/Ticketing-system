package com.example.tikecktingSystem.service;

import com.example.tikecktingSystem.dto.VehicleDTO;

import java.util.List;

public interface VehicleService{
    List<VehicleDTO> getAllVehicles();
    void registerVehicle(VehicleDTO vehicleDTO);
    void updateVehicle(VehicleDTO vehicleDTO);
}

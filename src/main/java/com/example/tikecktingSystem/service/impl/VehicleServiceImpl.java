package com.example.tikecktingSystem.service.impl;

import com.example.tikecktingSystem.dto.UserDTO;
import com.example.tikecktingSystem.dto.VehicleDTO;
import com.example.tikecktingSystem.entity.UserEntity;
import com.example.tikecktingSystem.entity.VehicleEntity;
import com.example.tikecktingSystem.repo.VehicleRepo;
import com.example.tikecktingSystem.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    private VehicleDTO mapToVehicleDTO(VehicleEntity vehicleEntity) {
        return new VehicleDTO().builder()
                .registrationNumber(vehicleEntity.getRegistrationNumber())
                .vehicleChassisNumber(vehicleEntity.getVehicleChassisNumber())
                .vehicleType(vehicleEntity.getVehicleType())
                .vehicleModel(vehicleEntity.getVehicleModel())
                .vehicleYear(vehicleEntity.getVehicleYear())
                .vehicleColor(vehicleEntity.getVehicleColor())
                .vehicleEngine(vehicleEntity.getVehicleEngine())
                .vehicleFuelType(vehicleEntity.getVehicleFuelType())
                .build();
    }

    private VehicleEntity maptToVehicleEntity(VehicleDTO vehicleDTO){
        return new VehicleEntity().builder()
                .registrationNumber(vehicleDTO.getRegistrationNumber())
                .vehicleChassisNumber(vehicleDTO.getVehicleChassisNumber())
                .vehicleType(vehicleDTO.getVehicleType())
                .vehicleModel(vehicleDTO.getVehicleModel())
                .vehicleYear(vehicleDTO.getVehicleYear())
                .vehicleColor(vehicleDTO.getVehicleColor())
                .vehicleEngine(vehicleDTO.getVehicleEngine())
                .vehicleFuelType(vehicleDTO.getVehicleFuelType())

                .build();
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        log.info("Show all Users");
        return vehicleRepo.findAll().stream()
                .map(this::mapToVehicleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void registerVehicle(VehicleDTO vehicleDTO) {
        if(vehicleRepo.existsById(vehicleDTO.getRegistrationNumber())){
            throw new RuntimeException("Vehicle Id "+vehicleDTO.getRegistrationNumber()+" All ready exist");
        }
        VehicleEntity vehicle = maptToVehicleEntity(vehicleDTO);
        vehicleRepo.save(vehicle);
    }

    @Override
    public void updateVehicle(VehicleDTO vehicleDTO) {
        if(!vehicleRepo.existsById(vehicleDTO.getRegistrationNumber())){
            throw new RuntimeException("Vehicle Id "+vehicleDTO.getRegistrationNumber()+" does not exist");
        }
        vehicleRepo.save(maptToVehicleEntity(vehicleDTO));
    }
}

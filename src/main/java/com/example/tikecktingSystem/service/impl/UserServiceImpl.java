package com.example.tikecktingSystem.service.impl;

import com.example.tikecktingSystem.dto.UserDTO;
import com.example.tikecktingSystem.entity.UserEntity;
import com.example.tikecktingSystem.entity.VehicleEntity;
import com.example.tikecktingSystem.repo.UserRepo;
import com.example.tikecktingSystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    private UserDTO mapToUserDTO(UserEntity user) {
        return new UserDTO(user.getUserName(), user.getContact(),
                user.getAddress(),user.getVehicles());
    }

    private UserEntity maptToUserEntity(UserEntity userResponse){
        return new UserEntity(
                userResponse.getUserNic(),
                userResponse.getUserName(),
                userResponse.getAddress(),
                userResponse.getContact(),
                userResponse.getVehicles()
                );
    }

    @Override
    public List<UserDTO> getAllUser() {

        log.info("Show all Users");
        return userRepo.findAll().stream()
                .map(this::mapToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void registerUser(UserEntity userEntity) {
//        if(userRepo.existsById(userEntity.getUserNic())){
//            throw new RuntimeException("User Id "+userEntity.getUserNic()+" All ready exist");
//        }
//        userRepo.save(userEntity);
//        log.info("user saved",userEntity.getUserNic());
        // Create and set data as shown in the previous example
        UserEntity user = UserEntity.builder()
                .userNic("123456789V")
                .userName("John Doe")
                .address("123 Main St")
                .contact("123-456-7890")
                .build();

        VehicleEntity vehicle1 = VehicleEntity.builder()
                .registrationNumber("ABC123")
                .vehicleChassisNumber("CHASSIS123")
                .vehicleType("Car")
                .vehicleModel("Corolla")
                .vehicleYear("2020")
                .vehicleColor("Red")
                .vehicleEngine("1.8L")
                .vehicleFuelType("Petrol")
                .user(user)
                .build();

        VehicleEntity vehicle2 = VehicleEntity.builder()
                .registrationNumber("DEF456")
                .vehicleChassisNumber("CHASSIS456")
                .vehicleType("Car")
                .vehicleModel("Civic")
                .vehicleYear("2021")
                .vehicleColor("Blue")
                .vehicleEngine("2.0L")
                .vehicleFuelType("Diesel")
                .user(user)
                .build();

        Set<VehicleEntity> vehicles = new HashSet<>();
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        user.setVehicles(vehicles);

        userRepo.save(user);
//        log.info("user saved",userEntity.getUserNic());

    }

    @Override
    public void updateUser(UserEntity userEntity) {
        if(!userRepo.existsById(userEntity.getUserNic())){
            throw new RuntimeException("Customer Id "+userEntity.getUserNic()+" does not exist");
        }
        userRepo.save(userEntity);
        log.info("user updated",userEntity.getUserNic());
    }
}

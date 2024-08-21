package com.example.tikecktingSystem.controller;


import com.example.tikecktingSystem.dto.VehicleDTO;
import com.example.tikecktingSystem.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
public class Vehiclecontroller {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VehicleDTO>> getVehicleDetails() {
        return new ResponseEntity<>( vehicleService.getAllVehicles(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleDTO> registerVehicle(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.registerVehicle(vehicleDTO);
       return new ResponseEntity<>(vehicleDTO,HttpStatus.CREATED);
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleDTO>  updateVehicle(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.updateVehicle(vehicleDTO);
        return new ResponseEntity<>(vehicleDTO,HttpStatus.ACCEPTED);
    }
}

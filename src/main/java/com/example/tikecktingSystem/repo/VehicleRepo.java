package com.example.tikecktingSystem.repo;

import com.example.tikecktingSystem.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepo extends JpaRepository<VehicleEntity,String> {
}

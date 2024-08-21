package com.example.tikecktingSystem.repo;

import com.example.tikecktingSystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;

public interface UserRepo extends JpaRepository<UserEntity,String> {
}

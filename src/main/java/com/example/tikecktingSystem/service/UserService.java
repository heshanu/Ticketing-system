package com.example.tikecktingSystem.service;

import com.example.tikecktingSystem.dto.UserDTO;
import com.example.tikecktingSystem.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUser();
    void registerUser(UserEntity userEntity);
    void updateUser(UserEntity userEntity);
}

package com.example.tikecktingSystem.service.impl;

import com.example.tikecktingSystem.dto.UserDTO;
import com.example.tikecktingSystem.entity.UserEntity;
import com.example.tikecktingSystem.repo.UserRepo;
import com.example.tikecktingSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    private UserDTO mapToUserDTO(UserEntity user) {
        return new UserDTO(user.getUserName(), user.getContact(),
                user.getAddress());
    }

    private UserEntity maptToUserEntity(UserEntity userResponse){
        return new UserEntity(userResponse.getUserNic(),userResponse.getUserName(),
                userResponse.getAddress(),
                userResponse.getContact());
    }

    @Override
    public List<UserDTO> getAllUser() {

        return userRepo.findAll().stream()
                .map(this::mapToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void registerUser(UserEntity userEntity) {
        if(userRepo.existsById(userEntity.getUserNic())){
            throw new RuntimeException("User Id "+userEntity.getUserNic()+" All ready exist");
        }
        userRepo.save(userEntity);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        if(!userRepo.existsById(userEntity.getUserNic())){
            throw new RuntimeException("Customer Id "+userEntity.getUserNic()+" does not exist");
        }
        userRepo.save(userEntity);
    }
}

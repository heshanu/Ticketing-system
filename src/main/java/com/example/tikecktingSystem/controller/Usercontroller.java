package com.example.tikecktingSystem.controller;

import com.example.tikecktingSystem.dto.UserDTO;
import com.example.tikecktingSystem.entity.UserEntity;
import com.example.tikecktingSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class Usercontroller {
   @Autowired
    private UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>>  getUsers() {
        return new ResponseEntity<>(
                userService.getAllUser(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserEntity> registerUser(@RequestBody UserEntity userEntity) {
       userService.registerUser(userEntity);
        return new ResponseEntity<>(userEntity,HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity userEntity) {
        userService.updateUser(userEntity);
        return new ResponseEntity<>(userEntity,HttpStatus.ACCEPTED);
    }
}

package com.maxiamikel.age_calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxiamikel.age_calculator.dto.AgeInfoRequestDTO;
import com.maxiamikel.age_calculator.dto.AgeInfoResponseDTO;
import com.maxiamikel.age_calculator.dto.UserCreateRequestDTO;
import com.maxiamikel.age_calculator.dto.UserCreatedResponseDTO;
import com.maxiamikel.age_calculator.service.impl.UserServiveImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserServiveImpl userServive;

    @PostMapping
    public ResponseEntity<UserCreatedResponseDTO> createNewUser(@RequestBody @Valid UserCreateRequestDTO request) {
        return new ResponseEntity<UserCreatedResponseDTO>(userServive.createNewUser(request), HttpStatus.CREATED);
    }

    @GetMapping("/infos")
    public ResponseEntity<AgeInfoResponseDTO> getUserInfo(@RequestBody AgeInfoRequestDTO request) {
        var user = userServive.getUserInfo(request);
        return new ResponseEntity<AgeInfoResponseDTO>(user, HttpStatus.OK);
    }

}

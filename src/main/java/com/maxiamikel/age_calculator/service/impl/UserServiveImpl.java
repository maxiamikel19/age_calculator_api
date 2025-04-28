package com.maxiamikel.age_calculator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxiamikel.age_calculator.dto.UserCreateRequestDTO;
import com.maxiamikel.age_calculator.dto.UserCreatedResponseDTO;
import com.maxiamikel.age_calculator.repository.UserRepository;
import com.maxiamikel.age_calculator.service.UserServive;

@Service
public class UserServiveImpl implements UserServive {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserCreatedResponseDTO createNewUser(UserCreateRequestDTO request) {
        return null;
    }

}

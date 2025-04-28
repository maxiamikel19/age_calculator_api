package com.maxiamikel.age_calculator.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxiamikel.age_calculator.dto.UserCreateRequestDTO;
import com.maxiamikel.age_calculator.dto.UserCreatedResponseDTO;
import com.maxiamikel.age_calculator.mapper.UserMapper;
import com.maxiamikel.age_calculator.model.User;
import com.maxiamikel.age_calculator.repository.UserRepository;
import com.maxiamikel.age_calculator.service.UserServive;
import com.maxiamikel.age_calculator.utils.DateFormatter;

@Service
public class UserServiveImpl implements UserServive {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserCreatedResponseDTO createNewUser(UserCreateRequestDTO request) {

        if (findByEmail(request.getEmail()) != null) {
            throw new RuntimeException("This email: " + request.getEmail() + " has been taken by another user");
        }

        String burthDateFormatted = DateFormatter.formatInputDate(request.getBurthDate());

        User user = new User();

        user.setUserId(null);
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setGender(request.getGender());
        user.setBurthDate(burthDateFormatted);
        user.setCreatedAt(LocalDate.now());

        var newUser = userRepository.save(user);

        return UserMapper.mapToUserCreateResponseDto(newUser);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

}

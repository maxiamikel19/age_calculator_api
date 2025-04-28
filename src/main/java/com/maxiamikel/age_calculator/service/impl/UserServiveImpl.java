package com.maxiamikel.age_calculator.service.impl;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxiamikel.age_calculator.dto.AgeInfoRequestDTO;
import com.maxiamikel.age_calculator.dto.AgeInfoResponseDTO;
import com.maxiamikel.age_calculator.dto.UserCreateRequestDTO;
import com.maxiamikel.age_calculator.dto.UserCreatedResponseDTO;
import com.maxiamikel.age_calculator.exception.EntityAlereadyExistException;
import com.maxiamikel.age_calculator.exception.EntityNotFoundException;
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
            throw new EntityAlereadyExistException(
                    "This email: " + request.getEmail() + " has been taken by another user");
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

    @Override
    public AgeInfoResponseDTO getUserInfo(AgeInfoRequestDTO request) {

        User user = findUserByEmailOrUserId(request.getCriteria());

        LocalDate today = LocalDate.now();
        Period period = Period.between(LocalDate.parse(user.getBurthDate()), today);

        AgeInfoResponseDTO response = new AgeInfoResponseDTO();
        response.setUserId(user.getUserId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setBurthDate(user.getBurthDate());
        response.setGender(user.getGender());
        response.setAgeYear(period.getYears());
        response.setAgeMonths(period.getMonths());
        response.setAgeDays(period.getDays());

        return response;

    }

    private User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    private User findUserByEmailOrUserId(String criteria) {
        return userRepository.findByEmail(criteria)
                .or(() -> userRepository.findByUserId(criteria))
                .orElseThrow(() -> new EntityNotFoundException(
                        "No reccord found under this email: " + criteria));
    }

}

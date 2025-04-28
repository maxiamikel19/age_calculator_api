package com.maxiamikel.age_calculator.service;

import com.maxiamikel.age_calculator.dto.AgeInfoResponseDTO;
import com.maxiamikel.age_calculator.dto.UserCreateRequestDTO;
import com.maxiamikel.age_calculator.dto.UserCreatedResponseDTO;

public interface UserServive {

    UserCreatedResponseDTO createNewUser(UserCreateRequestDTO request);

    AgeInfoResponseDTO getUserInfo(String criteria);
}

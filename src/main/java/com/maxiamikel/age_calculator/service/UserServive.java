package com.maxiamikel.age_calculator.service;

import com.maxiamikel.age_calculator.dto.UserCreateRequestDTO;
import com.maxiamikel.age_calculator.dto.UserCreatedResponseDTO;

public interface UserServive {

    UserCreatedResponseDTO createNewUser(UserCreateRequestDTO request);
}

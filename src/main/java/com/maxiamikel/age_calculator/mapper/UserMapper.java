package com.maxiamikel.age_calculator.mapper;

import com.maxiamikel.age_calculator.dto.UserCreatedResponseDTO;
import com.maxiamikel.age_calculator.model.User;

public class UserMapper {

    public static UserCreatedResponseDTO mapToUserCreateResponseDto(User user) {

        UserCreatedResponseDTO obj = new UserCreatedResponseDTO();
        obj.setUserId(user.getUserId());
        obj.setName(user.getName());
        obj.setEmail(user.getEmail());
        obj.setBurthDate(user.getBurthDate());
        obj.setGender(user.getGender());
        obj.setCreatedAt(user.getCreatedAt());

        return obj;
    }
}

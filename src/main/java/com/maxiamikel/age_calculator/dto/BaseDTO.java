package com.maxiamikel.age_calculator.dto;

import com.maxiamikel.age_calculator.enums.Gender;

import lombok.Data;

@Data
public abstract class BaseDTO {

    private String name;

    private String email;

    private String burthDate;

    private Gender gender;

}

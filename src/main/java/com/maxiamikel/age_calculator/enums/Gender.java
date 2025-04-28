package com.maxiamikel.age_calculator.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Gender {

    M("Male"),
    F("Femele");

    private String gender;
}

package com.maxiamikel.age_calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AgeInfoResponseDTO extends BaseDTO {

    private String userId;

    private Integer ageYear;

    private Integer ageMonths;

    private Integer ageDays;
}

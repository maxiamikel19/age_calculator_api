package com.maxiamikel.age_calculator.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserCreatedResponseDTO extends BaseDTO {

    private String userId;

    private LocalDate createdAt;
}

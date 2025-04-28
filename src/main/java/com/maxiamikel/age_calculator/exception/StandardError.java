package com.maxiamikel.age_calculator.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {

    private Integer codeStatus;
    private String message;
}

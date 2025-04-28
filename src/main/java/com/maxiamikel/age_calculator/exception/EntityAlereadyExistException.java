package com.maxiamikel.age_calculator.exception;

public class EntityAlereadyExistException extends RuntimeException {
    public EntityAlereadyExistException(String message) {
        super(message);
    }
}

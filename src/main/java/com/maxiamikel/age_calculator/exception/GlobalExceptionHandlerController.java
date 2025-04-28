package com.maxiamikel.age_calculator.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(EntityAlereadyExistException.class)
    public ResponseEntity<StandardError> entityAlereadyExistException(EntityAlereadyExistException ex) {
        StandardError err = new StandardError();
        err.setCodeStatus(HttpStatus.CONFLICT.value());
        err.setMessage(ex.getMessage());
        return new ResponseEntity<StandardError>(err, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFoundException(EntityNotFoundException ex) {
        StandardError err = new StandardError();
        err.setCodeStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(ex.getMessage());
        return new ResponseEntity<StandardError>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidInputDateException.class)
    public ResponseEntity<StandardError> invalidInputDateException(InvalidInputDateException ex) {
        StandardError err = new StandardError();
        err.setCodeStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage(ex.getMessage());
        return new ResponseEntity<StandardError>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> httpMessageNotReadableException(HttpMessageNotReadableException ex) {
        StandardError err = new StandardError();
        err.setCodeStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage("The available gender value must be [ M or F ] only!");
        return new ResponseEntity<StandardError>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<StandardError> noResourceFoundException(NoResourceFoundException ex) {
        StandardError err = new StandardError();
        err.setCodeStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage("URL not found!");
        return new ResponseEntity<StandardError>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> constraintViolationException(ConstraintViolationException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("errors", ex.getConstraintViolations()
                .stream()
                .map(error -> error.getPropertyPath() + ":" + error.getMessage()).toList());

        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }

}

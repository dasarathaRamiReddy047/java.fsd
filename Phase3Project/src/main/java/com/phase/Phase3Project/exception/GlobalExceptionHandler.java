package com.phase.Phase3Project.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex) {
        String errorMessage = "Not found or does not exist.";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    
}

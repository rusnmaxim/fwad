package com.example.fwad.controllers;

import com.example.fwad.models.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleAllExceptions(Exception ex) {

        return ResponseEntity.status(400).body(new ErrorDto(ex.getMessage()));
    }



}

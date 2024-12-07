package com.example.fwad.models;

import lombok.Data;

@Data
public class ErrorDto {
    public ErrorDto(String err){
        this.error = err;
    }
    String error;
}

package com.example.fwad.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookPut {
    @NotBlank
    private String name;
    @NotBlank
    private String author;
    private String description;
    @Min(1)
    private Integer pages;
}

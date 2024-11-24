package com.example.demo.models.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class User {
    private String username;
    private String password;
    private String role;
}

package com.example.demo.controllers;

import com.example.demo.models.entities.UserEntity;
import com.example.demo.services.UserService;
import com.example.demo.utils.JWTUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserService userService;
    private JWTUtils jwtUtils;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        User user = (User) authentication.getPrincipal();
        return jwtUtils.generateToken(user.getUsername());
    }

    @PostMapping("/register")
    public UserEntity register(@RequestBody com.example.demo.models.dtos.User user) {
        return userService.createUser(user);
    }
}
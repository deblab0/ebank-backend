package com.ebank.ebankbackend.controllers;

import com.ebank.ebankbackend.dto.LoginRequestDTO;
import com.ebank.ebankbackend.dto.LoginResponseDTO;
import com.ebank.ebankbackend.config.JwtProvider;
import com.ebank.ebankbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;


    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );
        String token = jwtProvider.generateToken(authentication);
        return new LoginResponseDTO(token);
    }
}

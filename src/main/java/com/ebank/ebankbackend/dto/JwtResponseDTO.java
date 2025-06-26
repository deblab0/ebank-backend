package com.ebank.ebankbackend.dto;

public record JwtResponseDTO(
        String token,
        String email,
        String role
) {}

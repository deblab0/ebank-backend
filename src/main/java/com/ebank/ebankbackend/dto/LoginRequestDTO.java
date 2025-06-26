package com.ebank.ebankbackend.dto;

public record LoginRequestDTO(
        String email,
        String password
) {}

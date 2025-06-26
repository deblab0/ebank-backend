package com.ebank.ebankbackend.dto;

public record VirementRequestDTO(
        String sourceRib,
        String destinationRib,
        double montant,
        String intitule
) {}

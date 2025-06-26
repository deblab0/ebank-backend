package com.ebank.ebankbackend.dto;

import java.time.LocalDate;

public record ClientRequestDTO(
        String nom,
        String prenom,
        String numeroIdentite,
        LocalDate dateAnniversaire,
        String email,
        String adressePostale
) {}

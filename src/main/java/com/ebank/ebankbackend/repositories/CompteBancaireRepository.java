package com.ebank.ebankbackend.repositories;

import com.ebank.ebankbackend.entities.CompteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompteBancaireRepository extends JpaRepository<CompteBancaire, Long> {
    Optional<CompteBancaire> findByRib(String rib);

    List<CompteBancaire> findByClientId(Long clientId);

}

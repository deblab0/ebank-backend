package com.ebank.ebankbackend.repositories;
import com.ebank.ebankbackend.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    // Spring Data creates the query from the method name!
    Optional<Client> findByEmail(String email);
    Optional<Client> findByNumeroIdentite(String numeroIdentite);
}
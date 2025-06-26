package com.ebank.ebankbackend.services;

import com.ebank.ebankbackend.entities.Client;
import com.ebank.ebankbackend.entities.CompteBancaire;
import com.ebank.ebankbackend.entities.AccountStatus;
import com.ebank.ebankbackend.repositories.ClientRepository;
import com.ebank.ebankbackend.repositories.CompteBancaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompteService {
    @Autowired
    private CompteBancaireRepository compteRepo;

    @Autowired
    private ClientRepository clientRepo;

    public CompteBancaire createCompte(Long clientId, double soldeInitial) {
        Client client = clientRepo.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));

        CompteBancaire compte = new CompteBancaire();
        compte.setClient(client);
        compte.setRib(UUID.randomUUID().toString());
        compte.setSolde(soldeInitial);
        compte.setStatut(AccountStatus.OUVERT);
        return compteRepo.save(compte);
    }

    public List<CompteBancaire> getComptesByClient(Long clientId) {
        return compteRepo.findByClientId(clientId);
    }
}

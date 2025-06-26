package com.ebank.ebankbackend.controllers;

import com.ebank.ebankbackend.entities.Client;
import com.ebank.ebankbackend.entities.CompteBancaire;
import com.ebank.ebankbackend.services.ClientService;
import com.ebank.ebankbackend.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agent")
@PreAuthorize("hasAuthority('AGENT_GUICHET')")
public class AgentController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private CompteService compteService;

    @PostMapping("/clients")
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @PostMapping("/comptes")
    public CompteBancaire createCompte(@RequestParam Long clientId, @RequestParam double soldeInitial) {
        return compteService.createCompte(clientId, soldeInitial);
    }

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
}

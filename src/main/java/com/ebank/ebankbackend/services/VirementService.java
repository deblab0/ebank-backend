package com.ebank.ebankbackend.services;

import com.ebank.ebankbackend.dto.VirementRequestDTO;
import com.ebank.ebankbackend.entities.CompteBancaire;
import com.ebank.ebankbackend.entities.Operation;
import com.ebank.ebankbackend.repositories.CompteBancaireRepository;
import com.ebank.ebankbackend.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class VirementService {


    @Autowired
    private CompteBancaireRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;

    public void effectuerVirement(VirementRequestDTO virementDTO) {
        CompteBancaire compteSource = compteRepository.findByRib(virementDTO.sourceRib())
                .orElseThrow(() -> new RuntimeException("Source account not found!"));
        CompteBancaire compteDest = compteRepository.findByRib(virementDTO.destinationRib())
                .orElseThrow(() -> new RuntimeException("Destination account not found!"));

        if (!"Ouvert".equals(compteSource.getStatut())) {
            throw new RuntimeException("Source account is not active!");
        }
        if (compteSource.getSolde() < virementDTO.montant()) {
            throw new RuntimeException("Insufficient funds!");
        }

        compteSource.setSolde(compteSource.getSolde() - virementDTO.montant());
        compteRepository.save(compteSource);

        compteDest.setSolde(compteDest.getSolde() + virementDTO.montant());
        compteRepository.save(compteDest);

        Operation debitOp = new Operation();
        debitOp.setDateOperation(new Date());
        debitOp.setMontant(virementDTO.montant());
        debitOp.setType("Débit");
        debitOp.setIntitule("Virement à " + compteDest.getClient().getNom());
        debitOp.setCompteBancaire(compteSource);
        operationRepository.save(debitOp);

        Operation creditOp = new Operation();
        creditOp.setDateOperation(new Date());
        creditOp.setMontant(virementDTO.montant());
        creditOp.setType("Crédit");
        creditOp.setIntitule("Virement de " + compteSource.getClient().getNom());
        creditOp.setCompteBancaire(compteDest);
        operationRepository.save(creditOp);
    }
}
package com.ebank.ebankbackend.controllers;

import com.ebank.ebankbackend.dto.VirementRequestDTO;
import com.ebank.ebankbackend.services.VirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private VirementService virementService;

    @PostMapping("/virements")
    @PreAuthorize("hasAuthority('CLIENT')")
    public ResponseEntity<Void> nouveauVirement(@RequestBody VirementRequestDTO virementDTO) {
        try {
            virementService.effectuerVirement(virementDTO);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
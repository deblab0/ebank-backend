package com.ebank.ebankbackend.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "operations")
@Data
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOperation;

    private double montant;
    private String type;
    private String intitule;

    @ManyToOne
    @JoinColumn(name = "compte_bancaire_id", nullable = false)
    private CompteBancaire compteBancaire;
}

package com.ebank.ebankbackend.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "comptes_bancaires")
@Data
public class CompteBancaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String rib;

    @Column(nullable = false)
    private double solde;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus statut;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "compteBancaire", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Operation> operations;
}
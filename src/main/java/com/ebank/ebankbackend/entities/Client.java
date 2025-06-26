package com.ebank.ebankbackend.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clients")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(unique = true, nullable = false)
    private String numeroIdentite;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateAnniversaire;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String adressePostale;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<CompteBancaire> comptes;

    public Client() {}

    public Client(String nom, String prenom, String numeroIdentite, Date dateAnniversaire, String email, String adressePostale, User user, List<CompteBancaire> comptes) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.numeroIdentite = numeroIdentite;
        this.dateAnniversaire = dateAnniversaire;
        this.email = email;
        this.adressePostale = adressePostale;
        this.user = user;
        this.comptes = comptes;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumeroIdentite() {
        return numeroIdentite;
    }

    public Date getDateAnniversaire() {
        return dateAnniversaire;
    }

    public String getEmail() {
        return email;
    }

    public String getAdressePostale() {
        return adressePostale;
    }

    public User getUser() {
        return user;
    }

    public List<CompteBancaire> getComptes() {
        return comptes;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNumeroIdentite(String numeroIdentite) {
        this.numeroIdentite = numeroIdentite;
    }

    public void setDateAnniversaire(Date dateAnniversaire) {
        this.dateAnniversaire = dateAnniversaire;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdressePostale(String adressePostale) {
        this.adressePostale = adressePostale;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setComptes(List<CompteBancaire> comptes) {
        this.comptes = comptes;
    }
}
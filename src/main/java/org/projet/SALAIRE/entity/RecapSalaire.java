package org.projet.SALAIRE.entity;

import javax.persistence.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class RecapSalaire implements Serializable{

    // Pour recuperer le salaire net de chaque contrat traité
   // private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double montant;


    @ManyToOne
    private BulletinSalaire bulletinSalaire;

    @ManyToOne
    private Contrat contrat;

    public RecapSalaire() {

    }

    public RecapSalaire(Long id) {
        this.id = id;
    }

    public RecapSalaire(double montant, BulletinSalaire bulletinSalaire, Contrat contrat) {
        this.montant = montant;
        this.bulletinSalaire = bulletinSalaire;
        this.contrat = contrat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public BulletinSalaire getBulletin() {
        return bulletinSalaire;
    }

    public void setBulletin(BulletinSalaire bulletin) {
        this.bulletinSalaire = bulletin;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }



}
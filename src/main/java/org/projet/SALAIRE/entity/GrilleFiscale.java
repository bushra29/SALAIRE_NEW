package org.projet.SALAIRE.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GrilleFiscale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long IdGrilleFiscale;
    public double BorneInf;
    public double BorneSup;
    public double Taux;

    public GrilleFiscale(Long idGrilleFiscale) {
        IdGrilleFiscale = idGrilleFiscale;
    }

    public GrilleFiscale() {
    }

    public Long getIdGrilleFiscale() {
        return IdGrilleFiscale;
    }

    public void setIdGrilleFiscale(Long idGrilleFiscale) {
        IdGrilleFiscale = idGrilleFiscale;
    }

    public double getBorneInf() {
        return BorneInf;
    }

    public void setBorneInf(double borneInf) {
        BorneInf = borneInf;
    }

    public double getBorneSup() {
        return BorneSup;
    }

    public void setBorneSup(double borneSup) {
        BorneSup = borneSup;
    }

    public double getTaux() {
        return Taux;
    }

    public void setTaux(double taux) {
        Taux = taux;
    }
}

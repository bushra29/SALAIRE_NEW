package org.projet.SALAIRE.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AgeAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdAgeAgent;
    private Integer AgeMin;
    private Integer AgeMax;

    public Long getIdAgeAgent() {
        return IdAgeAgent;
    }

    public void setIdAgeAgent(Long idAgeAgent) {
        IdAgeAgent = idAgeAgent;
    }

    public Integer getAgeMin() {
        return AgeMin;
    }

    public void setAgeMin(Integer ageMin) {
        AgeMin = ageMin;
    }

    public Integer getAgeMax() {
        return AgeMax;
    }

    public void setAgeMax(Integer ageMax) {
        AgeMax = ageMax;
    }
}

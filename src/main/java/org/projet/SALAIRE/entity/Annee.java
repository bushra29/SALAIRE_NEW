package org.projet.SALAIRE.entity;

import javax.persistence.*;

@Entity
//@Table(name = "Annee",uniqueConstraints = {@UniqueConstraint(columnNames={"libelle_annee"})})
public class Annee 
{
@Id

@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long IdAnnee;
@Column(length=10,nullable = false, unique = true)
private String LibelleAnnee;
@Column(length=10,nullable = false)
private Boolean Etat=false;

public Annee() {
}

public Long getIdAnnee() {
	return IdAnnee;
}

public void setIdAnnee(Long idAnnee) {
	IdAnnee = idAnnee;
}

public String getLibelleAnnee() {
	return LibelleAnnee;
}

public void setLibelleAnnee(String libelleAnnee) {
	LibelleAnnee = libelleAnnee;
}

public Boolean getEtat() {
	return Etat;
}

public void setEtat(Boolean etat) {
	Etat = etat;
}




}

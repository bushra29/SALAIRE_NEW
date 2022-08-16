package org.projet.SALAIRE.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mois {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdMois;
	@Column(length=50,nullable =false, unique = true)
	private String LibelleMois;
	@Column(nullable =false)
	private Boolean Etat=false;
	
	public Mois() {

	}

	public Mois(Long idMois) {
		IdMois = idMois;
	}

	public Boolean getEtat() {
		return Etat;
	}



	public void setEtat(Boolean etat) {
		Etat = etat;
	}



	public Long getIdMois() {
		return IdMois;
	}

	public void setIdMois(Long idMois) {
		IdMois = idMois;
	}

	public String getLibelleMois() {
		return LibelleMois;
	}

	public void setLibelleMois(String libelleMois) {
		LibelleMois = libelleMois;
	}
	
	
	

}

package org.projet.SALAIRE.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Portee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdPortee;
	@Column(length=50,nullable = false,unique = true)
	private String LibellePortee;
	
	public Portee() {
	}

	public Portee(Long idPortee) {
		IdPortee = idPortee;
	}

	public Long getIdPortee() {
		return IdPortee;
	}

	public void setIdPortee(Long idPortee) {
		IdPortee = idPortee;
	}

	public String getLibellePortee() {
		return LibellePortee;
	}

	public void setLibellePortee(String libellePortee) {
		LibellePortee = libellePortee;
	}
	
	
	
	

}

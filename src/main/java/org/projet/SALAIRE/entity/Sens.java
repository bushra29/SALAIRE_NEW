package org.projet.SALAIRE.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sens {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdSens;
	@Column(length=50,nullable = true,unique = true)
	private String LibelleSens;
	
	public Sens() {

	}

	public Sens(Long idSens) {
		IdSens = idSens;
	}

	public Long getIdSens() {
		return IdSens;
	}

	public void setIdSens(Long idSens) {
		IdSens = idSens;
	}

	public String getLibelleSens() {
		return LibelleSens;
	}

	public void setLibelleSens(String libelleSens) {
		LibelleSens = libelleSens;
	}
	
	

	

}

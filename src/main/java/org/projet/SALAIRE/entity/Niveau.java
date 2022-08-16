package org.projet.SALAIRE.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Niveau {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdNiveau;
	@Column(length=50,nullable = false, unique = true)
	private String LibelleNiveau;
	@Column(nullable = false)
	private Integer NbreCateg;
	@Column(nullable = true)
	private Integer Rang;


	
	public Niveau() {

	}

	public Niveau(Long idNiveau) {
		IdNiveau = idNiveau;
	}

	public Long getIdNiveau() {
		return IdNiveau;
	}

	public void setIdNiveau(Long idNiveau) {
		IdNiveau = idNiveau;
	}

	public String getLibelleNiveau() {
		return LibelleNiveau;
	}

	public void setLibelleNiveau(String libelleNiveau) {
		LibelleNiveau = libelleNiveau;
	}

	public Integer getNbreCateg() {
		return NbreCateg;
	}

	public void setNbreCateg(Integer nbreCateg) {
		NbreCateg = nbreCateg;
	}

	public Integer getRang() {
		return Rang;
	}

	public void setRang(Integer rang) {
		Rang = rang;
	}
	
	
	
	

}

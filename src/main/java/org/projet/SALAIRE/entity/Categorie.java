package org.projet.SALAIRE.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdCateg;
	@Column(length=50,nullable = false)
	private String LibelleCateg;
	@Column(nullable = false)
	private Integer NbreEchellon;
	@Column(nullable = true)
	private Integer Rang;
	
	@ManyToOne
	private Niveau niveau;

	public Categorie() {

	}

	public Categorie(Long idCateg) {
		IdCateg = idCateg;
	}

	public Categorie(Long idCateg, String libelleCateg, Integer nbreEchellon, Integer rang, Niveau niveau) {
		IdCateg = idCateg;
		LibelleCateg = libelleCateg;
		NbreEchellon = nbreEchellon;
		Rang = rang;
		this.niveau = niveau;
	}

	public Categorie(String libelleCateg, Integer nbreEchellon, Integer rang, Niveau niveau) {
		LibelleCateg = libelleCateg;
		NbreEchellon = nbreEchellon;
		Rang = rang;
		this.niveau = niveau;
	}




	public Long getIdCateg() {
		return IdCateg;
	}

	public void setIdCateg(Long idCateg) {
		IdCateg = idCateg;
	}

	public String getLibelleCateg() {
		return LibelleCateg;
	}

	public void setLibelleCateg(String libelleCateg) {
		LibelleCateg = libelleCateg;
	}

	public Integer getNbreEchellon() {
		return NbreEchellon;
	}

	public void setNbreEchellon(Integer nbreEchellon) {
		NbreEchellon = nbreEchellon;
	}

	public Integer getRang() {
		return Rang;
	}

	public void setRang(Integer rang) {
		Rang = rang;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
}

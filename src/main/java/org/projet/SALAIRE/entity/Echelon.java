package org.projet.SALAIRE.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Echelon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdEchel;
	@Column(length=50,nullable =false)
	private String LibelleEchel;
	private double Salaire;
	@Column(nullable = false)
	private Integer Rang;
	
	@ManyToOne
	private Categorie categorie;
	
	public Echelon() {

	}

	public Echelon(Long idEchel) {
		IdEchel = idEchel;
	}

	public Echelon(String libelleEchel, Integer rang, Categorie categorie) {
		LibelleEchel = libelleEchel;
		Rang = rang;
		this.categorie = categorie;
	}



	public Long getIdEchel() {
		return IdEchel;
	}

	public void setIdEchel(Long idEchel) {
		IdEchel = idEchel;
	}

	public String getLibelleEchel() {
		return LibelleEchel;
	}

	public void setLibelleEchel(String libelleEchel) {
		LibelleEchel = libelleEchel;
	}

	public double getSalaire() {
		return Salaire;
	}

	public void setSalaire(double salaire) {
		Salaire = salaire;
	}

	public Integer getRang() {
		return Rang;
	}

	public void setRang(Integer rang) {
		Rang = rang;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	
	
	

}

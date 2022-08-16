package org.projet.SALAIRE.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parametre {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Libelle;
	private Integer Valeur;
	
	public Parametre() {

	}

	public Parametre(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return Libelle;
	}

	public void setLibelle(String libelle) {
		Libelle = libelle;
	}

	public int getValeur() {
		return Valeur;
	}

	public void setValeur(int valeur) {
		Valeur = valeur;
	}
	
	
}

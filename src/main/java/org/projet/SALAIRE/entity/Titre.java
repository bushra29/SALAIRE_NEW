package org.projet.SALAIRE.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Titre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdTitre;
	@Column(length=50,nullable = false,unique = true)
	private String LibelleTitre;
	
	public Titre() {

	}

	public Titre(Long idTitre) {
		IdTitre = idTitre;
	}

	public Long getIdTitre() {
		return IdTitre;
	}

	public void setIdTitre(Long idTitre) {
		IdTitre = idTitre;
	}

	public String getLibelleTitre() {
		return LibelleTitre;
	}

	public void setLibelleTitre(String libelleTitre) {
		LibelleTitre = libelleTitre;
	}


	
	
	
	

}

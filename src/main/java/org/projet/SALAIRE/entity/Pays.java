package org.projet.SALAIRE.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
public class Pays {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdPays;
	@Column(length=50,nullable = false,unique = true)
	private String NomPays;
	@Column(length=50,nullable = false,unique = true)
	private String LibelleNationnalite;
	
	public Pays() {

	}

	

	public Pays(Long idPays) {
		IdPays = idPays;
	}


	public Pays(String nomPays, String libelleNationnalite) {
		super();
		NomPays = nomPays;
		LibelleNationnalite = libelleNationnalite;
	}


	public Long getIdPays() {
		return IdPays;
	}

	public void setIdPays(Long idPays) {
		IdPays = idPays;
	}

	public String getNomPays() {
		return NomPays;
	}

	public void setNomPays(String nomPays) {
		NomPays = nomPays;
	}

	public String getLibelleNationnalite() {
		return LibelleNationnalite;
	}

	public void setLibelleNationnalite(String libelleNationnalite) {
		LibelleNationnalite = libelleNationnalite;
	}
	
	
	
}

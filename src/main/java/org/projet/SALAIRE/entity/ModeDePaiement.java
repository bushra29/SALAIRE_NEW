package org.projet.SALAIRE.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ModeDePaiement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdModeP;
	@Column(length=50,nullable =false)
	private String LibelleModeP;


	public ModeDePaiement() {

	}


	public ModeDePaiement(Long idModeP) {
		IdModeP = idModeP;
	}

	public Long getIdModeP() {
		return IdModeP;
	}

	public void setIdModeP(Long idModeP) {
		IdModeP = idModeP;
	}

	public String getLibelleModeP() {
		return LibelleModeP;
	}

	public void setLibelleModeP(String libelleModeP) {
		LibelleModeP = libelleModeP;
	}
	
	
	
	

}

package org.projet.SALAIRE.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SituationMatrimoniale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long IdSitMat;
	@Column(length=50,nullable = false)
	 private String LibelleSitMat;
 

	public SituationMatrimoniale() {

	}

	public SituationMatrimoniale(Long idSitMat) {
		IdSitMat = idSitMat;
	}

	public Long getIdSitMat() {
	return IdSitMat;
}
	public void setIdSitMat(Long idSitMat) {
		IdSitMat = idSitMat;
	}
	public String getLibelleSitMat() {
		return LibelleSitMat;
	}
	public void setLibelleSitMat(String libelleSitMat) {
	LibelleSitMat = libelleSitMat;
}


 
 
	
}

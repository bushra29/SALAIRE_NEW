package org.projet.SALAIRE.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeRubrique
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdTypeR;
	@Column(length=50,nullable = false)
	private String LibelleTypeR;
	
	public TypeRubrique() {

	}

	public TypeRubrique(Long idTypeR) {
		IdTypeR = idTypeR;
	}

	public Long getIdTypeR() {
		return IdTypeR;
	}

	public void setIdTypeR(Long idTypeR) {
		IdTypeR = idTypeR;
	}

	public String getLibelleTypeR() {
		return LibelleTypeR;
	}

	public void setLibelleTypeR(String libelleTypeR) {
		LibelleTypeR = libelleTypeR;
	}
	
	
	
	
 
}

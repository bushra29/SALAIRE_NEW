package org.projet.SALAIRE.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rubrique {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdRubrique;
	@Column(length=50,nullable =false,unique = true)
	private String LibelleRubri;
	private double Taux;
	@ManyToOne
	private Portee portee;
	@ManyToOne
	private Sens sens;
	
	public Rubrique() {

	}

	public Rubrique(Long idRubrique) {
		IdRubrique = idRubrique;
	}

	public Long getIdRubrique() {
		return IdRubrique;
	}

	public void setIdRubrique(Long idRubrique) {
		IdRubrique = idRubrique;
	}

	public String getLibelleRubri() {
		return LibelleRubri;
	}

	public void setLibelleRubri(String libelleRubri) {
		LibelleRubri = libelleRubri;
	}


	public Portee getPortee() {
		return portee;
	}

	public void setPortee(Portee portee) {
		this.portee = portee;
	}

	public Sens getSens() {
		return sens;
	}

	public void setSens(Sens sens) {
		this.sens = sens;
	}

	public double getTaux() {
		return Taux;
	}

	public void setTaux(double taux) {
		Taux = taux;
	}
}

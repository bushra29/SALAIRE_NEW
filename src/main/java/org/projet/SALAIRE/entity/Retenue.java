package org.projet.SALAIRE.entity;

import javax.persistence.*;

@Entity
//@Table(name = "Retenue",uniqueConstraints = {@UniqueConstraint(columnNames={"libelle_retenue","taux_employ","taux_patron","taux_fixe"})})
public class Retenue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdRetenue;

	private String LibelleRetenue;
	@Column(nullable = false)
	private double  TauxPatron;
	@Column(nullable =false)
	private double  TauxEmploy;
	@Column(nullable = false)
	private double  TauxFixe;

	@ManyToOne
	private Rubrique rubrique;
	
	public Retenue() {

	}

	public Retenue(Long idRetenue) {
		IdRetenue = idRetenue;
	}

	public Rubrique getRubrique() {
		return rubrique;
	}

	public void setRubrique(Rubrique rubrique) {
		this.rubrique = rubrique;
	}

	public String getLibelleRetenue() {
		return LibelleRetenue;
	}

	public void setLibelleRetenue(String libelleRetenue) {
		LibelleRetenue = libelleRetenue;
	}

	public Long getIdRetenue() {
		return IdRetenue;
	}

	public void setIdRetenue(Long idRetenue) {
		IdRetenue = idRetenue;
	}

	public double getTauxPatron() {
		return TauxPatron;
	}

	public void setTauxPatron(double tauxPatron) {
		TauxPatron = tauxPatron;
	}

	public double getTauxEmploy() {
		return TauxEmploy;
	}

	public void setTauxEmploy(double tauxEmploy) {
		TauxEmploy = tauxEmploy;
	}

	public double getTauxFixe() {
		return TauxFixe;
	}

	public void setTauxFixe(double tauxFixe) {
		TauxFixe = tauxFixe;
	}
}

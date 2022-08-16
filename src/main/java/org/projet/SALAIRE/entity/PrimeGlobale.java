package org.projet.SALAIRE.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PrimeGlobale 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdPrimeG;
	@Column(nullable = false)
	private double Montant;
	private Date DateDebut;
	private Date DateFin;
	
	@ManyToOne
	private Categorie categorie;
	@ManyToOne
	private Rubrique rubrique;
	
	public PrimeGlobale() {

	}

	public PrimeGlobale(Long idPrimeG) {
		IdPrimeG = idPrimeG;
	}

	public Date getDateDebut() {
		return DateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		DateDebut = dateDebut;
	}

	public Date getDateFin() {
		return DateFin;
	}

	public void setDateFin(Date dateFin) {
		DateFin = dateFin;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Rubrique getRubrique() {
		return rubrique;
	}

	public void setRubrique(Rubrique rubrique) {
		this.rubrique = rubrique;
	}

	public Long getIdPrimeG() {
		return IdPrimeG;
	}

	public void setIdPrimeG(Long idPrimeG) {
		this.IdPrimeG = idPrimeG;
	}

	public double getMontant() {
		return Montant;
	}

	public void setMontant(double montant) {
		Montant = montant;
	}

	
	
	
}

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
public class PrimeIndividuelle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdPrimeI;
	@Column(nullable = false)
	private double Montant;
	private Date DateDebut;
	private Date DateFin;
	@ManyToOne
	private Contrat contrat;
	@ManyToOne
	private Rubrique rubrique;


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

	public PrimeIndividuelle() {

	}

	public PrimeIndividuelle(Long idPrimeI) {
		IdPrimeI = idPrimeI;
	}

	public Long getIdPrimeI() {
		return IdPrimeI;
	}

	public void setIdPrimeI(Long idPrimeI) {
		IdPrimeI = idPrimeI;
	}
	public double getMontant() {
		return Montant;
	}

	public void setMontant(double montant) {
		Montant = montant;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public Rubrique getRubrique() {
		return rubrique;
	}

	public void setRubrique(Rubrique rubrique) {
		this.rubrique = rubrique;
	}



	
	

	

}

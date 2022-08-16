package org.projet.SALAIRE.entity;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Avance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdAvance;
	@Column(nullable = false)
	private LocalDate DateDebut;
	@Column(nullable =false)
	private LocalDate DateFin;
	@Column(nullable = false)
	private int Montant;
	@Column(nullable = false)
	private int NbreMois;
	
	@ManyToOne
	private Precompte precompte;
	@ManyToOne
	private Contrat contrat;
	
	public Avance() {

	}

	public Avance(Long idAvance) {
		IdAvance = idAvance;
	}

	public Long getIdAvance() {
		return IdAvance;
	}

	public void setIdAvance(Long idAvance) {
		IdAvance = idAvance;
	}

	public LocalDate getDateDebut() {
		return DateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		DateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return DateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		DateFin = dateFin;
	}

	public Precompte getPrecompte() {
		return precompte;
	}

	public void setPrecompte(Precompte precompte) {
		this.precompte = precompte;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public int getMontant() {
		return Montant;
	}

	public void setMontant(int montant) {
		Montant = montant;
	}

	public int getNbreMois() {
		return NbreMois;
	}

	public void setNbreMois(int nbreMois) {
		NbreMois = nbreMois;
	}
	
	
	
	
	

}

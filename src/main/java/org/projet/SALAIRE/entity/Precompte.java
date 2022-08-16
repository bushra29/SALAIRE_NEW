package org.projet.SALAIRE.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Precompte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdPreco;
	@Column(nullable =  false)
	@Temporal(TemporalType.DATE)
	private Date DatePreco;
	@Column(nullable = false)
	private Integer Montant;
	
	public Precompte() {

	}

	public Precompte(Long idPreco) {
		IdPreco = idPreco;
	}

	public Long getIdPreco() {
		return IdPreco;
	}

	public void setIdPreco(Long idPreco) {
		IdPreco = idPreco;
	}

	public  Date getDatePreco() {
		return DatePreco;
	}

	public void setDatePreco(Date datePreco) {
		DatePreco = datePreco;
	}

	public int getMontant() {
		return Montant;
	}

	public void setMontant(int montant) {
		Montant = montant;
	}
	
	
	
	

	
}

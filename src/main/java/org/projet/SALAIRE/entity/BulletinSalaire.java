package org.projet.SALAIRE.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "BulletinSalaire",uniqueConstraints = {@UniqueConstraint(columnNames={"mois_id_mois","annee_id_annee"})})
public class BulletinSalaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdBulletin;
	@Column(nullable = false)
	private Date DateBulletin=new Date();
	/*private LocalDate DateBulletin=LocalDate.now();*/
	private double Montant;
	@Column(length=10,nullable = false)
	private Boolean Etat=false;
	
	@ManyToOne
	@JoinColumn(name="annee_id_annee")
	private Annee annee;
	@ManyToOne
	@JoinColumn(name="mois_id_mois")
	private Mois mois;
	
	public BulletinSalaire() {

	}

	public BulletinSalaire(Long idBulletin) {
		IdBulletin = idBulletin;
	}

	public double getMontant() {
		return Montant;
	}

	public void setMontant(double montant) {
		Montant = montant;
	}

	public Long getIdBulletin() {
		return IdBulletin;
	}

	public void setIdBulletin(Long idBulletin) {
		IdBulletin = idBulletin;
	}


	public Date getDateBulletin() {
		return DateBulletin;
	}

	public void setDateBulletin(Date dateBulletin) {
		DateBulletin = dateBulletin;
	}

	public Annee getAnnee() {
		return annee;
	}

	public void setAnnee(Annee annee) {
		this.annee = annee;
	}

	public Mois getMois() {
		return mois;
	}

	public void setMois(Mois mois) {
		this.mois = mois;
	}

	public Boolean getEtat() {
		return Etat;
	}

	public void setEtat(Boolean etat) {
		Etat = etat;
	}
	
	
	

}

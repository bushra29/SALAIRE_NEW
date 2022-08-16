package org.projet.SALAIRE.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class GrilleSalariale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdGrille;
	private Date DateGrille;
	private double MontantSalaire;
	private double MontantPrimeG;
	private double MontantPrimeI;
	private double MontantRetenue;
	private double TauxPg;
	private double TauxPi;

	private double TauxRetenue;
	private double TauxPatron;
	private double TauxEmploy;
	private double TauxFixe;


	@ManyToOne
	private Avance avance;

	@ManyToOne
	private BulletinSalaire bulletinSalaire;


	@ManyToOne
	private Contrat contrat;
	@ManyToOne
	private PrimeGlobale primeGlobale;
	@ManyToOne
	private PrimeIndividuelle primeIndividuelle;
	@ManyToOne
	private Retenue retenue;


	public GrilleSalariale() {

	}

	public GrilleSalariale(Date dateGrille, double tauxPatron, double tauxEmploy, double tauxFixe, BulletinSalaire bulletinSalaire, Contrat contrat, Retenue retenue) {
		DateGrille = dateGrille;
		TauxPatron = tauxPatron;
		TauxEmploy = tauxEmploy;
		TauxFixe = tauxFixe;
		this.bulletinSalaire = bulletinSalaire;
		this.contrat = contrat;
		this.retenue = retenue;
	}

	public Date getDateGrille() {
		return DateGrille;
	}

	public void setDateGrille(Date dateGrille) {
		DateGrille = dateGrille;
	}

	public GrilleSalariale(Long idGrille) {
		IdGrille = idGrille;
	}

	public double getMontantSalaire() {
		return MontantSalaire;
	}

	public double getMontantPrimeG() {
		return MontantPrimeG;
	}

	public double getMontantPrimeI() {
		return MontantPrimeI;
	}

	public double getMontantRetenue() {
		return MontantRetenue;
	}

	public double getTauxPg() {
		return TauxPg;
	}

	public void setTauxPg(double tauxPg) {
		TauxPg = tauxPg;
	}

	public double getTauxPi() {
		return TauxPi;
	}

	public void setTauxPi(double tauxPi) {
		TauxPi = tauxPi;
	}

	public void setTauxRetenue(double tauxRetenue) {
		TauxRetenue = tauxRetenue;
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

	public Avance getAvance() {
		return avance;
	}

	public BulletinSalaire getBulletinSalaire() {
		return bulletinSalaire;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public PrimeGlobale getPrimeGlobale() {
		return primeGlobale;
	}

	public PrimeIndividuelle getPrimeIndividuelle() {
		return primeIndividuelle;
	}

	public Retenue getRetenue() {
		return retenue;
	}

	public void setRetenue(Retenue retenue) {
		this.retenue = retenue;
	}

	public void setPrimeIndividuelle(PrimeIndividuelle primeIndividuelle) {
		this.primeIndividuelle = primeIndividuelle;
	}

	public void setPrimeGlobale(PrimeGlobale primeGlobale) {
		this.primeGlobale = primeGlobale;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public void setBulletinSalaire(BulletinSalaire bulletinSalaire) {
		this.bulletinSalaire = bulletinSalaire;
	}

	public void setAvance(Avance avance) {
		this.avance = avance;
	}

	public void setMontantRetenue(double montantRetenue) {
		MontantRetenue = montantRetenue;
	}

	public void setMontantPrimeI(double montantPrimeI) {
		MontantPrimeI = montantPrimeI;
	}


	public void setMontantPrimeG(double montantPrimeG) {
		MontantPrimeG = montantPrimeG;
	}

	public void setMontantSalaire(double montantSalaire) {
		MontantSalaire = montantSalaire;
	}

	/*public GrilleSalariale(LocalDate dateGrille,PrimeGlobale primeGlobale,Double montantSalaire,BulletinSalaire bulletinSalaire, Contrat contrat) {

		DateGrille = dateGrille;
		this.primeGlobale = primeGlobale;
		MontantSalaire=montantSalaire;
		this.bulletinSalaire=bulletinSalaire;
		this.contrat = contrat;
	}

	public GrilleSalariale(LocalDate dateGrille,PrimeGlobale primeGlobale,Double montantPrimeG,BulletinSalaire bulletinSalaire, Contrat contrat) {

		DateGrille = dateGrille;
		this.primeGlobale = primeGlobale;
		MontantPrimeG=montantPrimeG;
		this.bulletinSalaire=bulletinSalaire;
		this.contrat = contrat;
	}*/

	public GrilleSalariale(Date dateGrille, double montantSalaire, double montantPrimeG, double montantPrimeI, double tauxPg, double tauxPi, BulletinSalaire bulletinSalaire, Contrat contrat, PrimeGlobale primeGlobale) {
		DateGrille = dateGrille;
		MontantSalaire = montantSalaire;
		MontantPrimeG = montantPrimeG;
		MontantPrimeI = montantPrimeI;
		TauxPg = tauxPg;
		TauxPi = tauxPi;
		this.bulletinSalaire = bulletinSalaire;
		this.contrat = contrat;
		this.primeGlobale = primeGlobale;
	}

	public GrilleSalariale(Date dateGrille, double montantSalaire, double montantPrimeG, double montantPrimeI, double tauxPg, double tauxPi, BulletinSalaire bulletinSalaire, Contrat contrat, PrimeIndividuelle primeIndividuelle) {
		DateGrille = dateGrille;
		MontantSalaire = montantSalaire;
		MontantPrimeG = montantPrimeG;
		MontantPrimeI = montantPrimeI;
		TauxPg = tauxPg;
		TauxPi = tauxPi;
		this.bulletinSalaire = bulletinSalaire;
		this.contrat = contrat;
		this.primeIndividuelle = primeIndividuelle;

	}



	/*public GrilleSalariale(LocalDate dateGrille, PrimeGlobale primeGlobale, Double montantSalaire, BulletinSalaire bulletinSalaire, Contrat contrat, float tauxPg) {


		DateGrille = dateGrille;
		this.primeGlobale = primeGlobale;
		MontantSalaire=montantSalaire;
		this.bulletinSalaire=bulletinSalaire;
		this.contrat = contrat;
		TauxPg=tauxPg;
	}

	public GrilleSalariale(LocalDate dateGrille,PrimeIndividuelle primeIndividuelle,Double montantPrimeI,BulletinSalaire bulletinSalaire, Contrat contrat) {

		DateGrille = dateGrille;
		this.primeIndividuelle = primeIndividuelle;
		MontantPrimeI=montantPrimeI;
		this.bulletinSalaire=bulletinSalaire;
		this.contrat = contrat;
	}

	public GrilleSalariale(LocalDate dateGrille,PrimeIndividuelle primeIndividuelle,Double montantSalaire,BulletinSalaire bulletinSalaire, Contrat contrat,float tauxPi) {

		DateGrille = dateGrille;
		this.primeIndividuelle = primeIndividuelle;
		MontantSalaire=montantSalaire;
		this.bulletinSalaire=bulletinSalaire;
		this.contrat = contrat;
		TauxPi=tauxPi;
	}

	public GrilleSalariale(LocalDate dateGrille, Retenue retenue,float tauxPatron, float  tauxEmploy, float tauxFixe,BulletinSalaire bulletinSalaire, Contrat contrat) {
		DateGrille = dateGrille;
		this.retenue=retenue;
		TauxPatron = tauxPatron;
		TauxEmploy = tauxEmploy;
		TauxFixe = tauxFixe;
		this.bulletinSalaire=bulletinSalaire;
		this.contrat = contrat;
	}*/

	public Long getIdGrille() {
		return IdGrille;
	}

	public void setIdGrille(Long idGrille) {
		IdGrille = idGrille;
	}
}



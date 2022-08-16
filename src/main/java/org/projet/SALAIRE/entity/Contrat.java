package org.projet.SALAIRE.entity;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

@Entity
//@Table(name = "Contrat",uniqueConstraints = {@UniqueConstraint(columnNames={"mois_id_mois","annee_id_annee"})})
public class Contrat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdContrat;


	private LocalDate DateDebut;

	private LocalDate DateFin;

	private LocalDate DateEntreeCateg;
	private boolean Etat=true;
	private LocalDate DateEntreeEchelon;
	private String CategorieInitiale;


	@ManyToOne
	private TypeContrat typeContrat;
	@ManyToOne
	private Echelon echelon;

    @ManyToOne
	private Echelon echelonStart;
	@ManyToOne
	private Agent agent;
	
	public Contrat() {

	}

	public Contrat(Long idContrat) {
		IdContrat = idContrat;
	}

	public LocalDate getDateEntreeEchelon() {
		return DateEntreeEchelon;
	}

	public void setDateEntreeEchelon(LocalDate dateEntreeEchelon) {
		DateEntreeEchelon = dateEntreeEchelon;
	}


	public String getCategorieInitiale() {
		return CategorieInitiale;
	}


	public void setCategorieInitiale(String categorieInitiale) {
		CategorieInitiale = categorieInitiale;
	}




	public void setDateDebut(LocalDate dateDebut) {
		DateDebut = dateDebut;
	}


	public void setDateFin(LocalDate dateFin) {
		DateFin = dateFin;
	}


	public void setDateEntreeCateg(LocalDate dateEntreeCateg) {
		DateEntreeCateg = dateEntreeCateg;
	}

	

	public Agent getAgent() {
		return agent;
	}


	public void setAgent(Agent agent) {
		this.agent = agent;
	}


	public Long getIdContrat() {
		return IdContrat;
	}

	public void setIdContrat(Long idContrat) {
		IdContrat = idContrat;
	}

	

	public LocalDate getDateDebut() {
		return DateDebut;
	}


	public LocalDate getDateFin() {
		return DateFin;
	}

	public LocalDate getDateEntreeCateg() {
		return DateEntreeCateg;
	}


	public Boolean getEtat() {
		return Etat;
	}

	public void setEtat(Boolean etat) {
		Etat = etat;
	}

	public TypeContrat getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(TypeContrat typeContrat) {
		this.typeContrat = typeContrat;
	}

	public boolean isEtat() {
		return Etat;
	}

	public void setEtat(boolean etat) {
		Etat = etat;
	}

	public Echelon getEchelon() {
		return echelon;
	}

	public void setEchelonActuel(Echelon echelonActuel) {
		this.echelon = echelonActuel;
	}

	public Echelon getEchelonStart() {
		return echelonStart;
	}

	public void setEchelonStart(Echelon echelonStart) {
		this.echelonStart = echelonStart;
	}
}

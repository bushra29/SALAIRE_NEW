package org.projet.SALAIRE.entity;

import javax.persistence.*;

import org.hibernate.annotations.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
//@Table(name = "Agent",uniqueConstraints = {@UniqueConstraint(columnNames={"nom_agent","prenom_agent","contact","matricule","email"})})
public class Agent implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdAgent;

	@Column(unique = true,length=100,nullable = false)
	private String Matricule;
	@Column(length=100,nullable = false)
	private String NomAgent;
	@Column(length=150,nullable = false)
	private String PrenomAgent;
	@Column(nullable = false)
	private Date DateNaiss;
	@Column(nullable = false)
	private Date DateEmbau;
	@Column(length=10,nullable = false)
	private String Genre;
	@Column(length=50,nullable = false, unique = true)
	private String Email;
	@Column(nullable = false, unique = true)
	private String Contact;
	@Column(length=100,nullable = false, unique = true)
	private String NumCompte;
	private Boolean Etat =false;
	
	@ManyToOne 
	private Fonction fonction;
	
	@ManyToOne
	private Pays pays;
	
	@ManyToOne
	private SituationMatrimoniale situationMatrimoniale;
	
	@ManyToOne
	private Titre titre;
	
	@ManyToOne
	private ModeDePaiement modeDePaiement;
	
	@ManyToOne
	private InstitutionFinanciere institutionFinanciere;

	public Agent() {
	}

	public Agent(Long idAgent) {
		IdAgent = idAgent;
	}

	public Long getIdAgent() {
		return IdAgent;
	}

	public void setIdAgent(Long idAgent) {
		IdAgent = idAgent;
	}

	public String getNomAgent() {
		return NomAgent;
	}

	public void setNomAgent(String nomAgent) {
		NomAgent = nomAgent;
	}

	public String getPrenomAgent() {
		return PrenomAgent;
	}

	public void setPrenomAgent(String prenomAgent) {
		PrenomAgent = prenomAgent;
	}

	public String getMatricule() {
		return Matricule;
	}

	public void setMatricule(String matricule) {
		Matricule = matricule;
	}

	public Date getDateNaiss() {
		return DateNaiss;
	}

	public void setDateNaiss(Date dateNaiss) {
		DateNaiss = dateNaiss;
	}

	public Date getDateEmbau() {
		return DateEmbau;
	}

	public void setDateEmbau(Date dateEmbau) {
		DateEmbau = dateEmbau;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public String getNumCompte() {
		return NumCompte;
	}

	public void setNumCompte(String numCompte) {
		NumCompte = numCompte;
	}

	public Boolean getEtat() {
		return Etat;
	}

	public void setEtat(Boolean etat) {
		Etat = etat;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public SituationMatrimoniale getSituationMatrimoniale() {
		return situationMatrimoniale;
	}

	public void setSituationMatrimoniale(SituationMatrimoniale situationMatrimoniale) {
		this.situationMatrimoniale = situationMatrimoniale;
	}

	public Titre getTitre() {
		return titre;
	}

	public void setTitre(Titre titre) {
		this.titre = titre;
	}

	public ModeDePaiement getModeDePaiement() {
		return modeDePaiement;
	}

	public void setModeDePaiement(ModeDePaiement modeDePaiement) {
		this.modeDePaiement = modeDePaiement;
	}

	public InstitutionFinanciere getInstitutionFinanciere() {
		return institutionFinanciere;
	}

	public void setInstitutionFinanciere(InstitutionFinanciere institutionFinanciere) {
		this.institutionFinanciere = institutionFinanciere;
	}



	
}

package org.projet.SALAIRE.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Entity
//@Table(name = "Fonction",uniqueConstraints = {@UniqueConstraint(columnNames={"mois_id_mois","annee_id_annee"})})
public class Fonction implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdFonct; 
	@Column(length=50,nullable = true,unique = true)
	private String LibelleFonct;
	
	public Fonction() {
		
	}

	public Fonction(Long idFonct) {
		IdFonct = idFonct;
	}


	public Long getIdFonct() {
		return IdFonct;
	}

	public void setIdFonct(Long idFonct) {
		IdFonct = idFonct;
	}

	public String getLibelleFonct() {
		return LibelleFonct;
	}

	public void setLibelleFonct(String libelleFonct) {
		LibelleFonct = libelleFonct;
	}

	

	
}

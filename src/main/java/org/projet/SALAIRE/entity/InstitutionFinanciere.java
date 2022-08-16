package org.projet.SALAIRE.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InstitutionFinanciere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdInsti;
	@Column(length=50,nullable = false,unique = true)
	private String NomInsti;
	
	public InstitutionFinanciere() {

	}

	public InstitutionFinanciere(Long idInsti) {
		IdInsti = idInsti;
	}

	public Long getIdInsti() {
		return IdInsti;
	}

	public void setIdInsti(Long idInsti) {
		IdInsti = idInsti;
	}

	public String getNomInsti() {
		return NomInsti;
	}

	public void setNomInsti(String nomInsti) {
		NomInsti = nomInsti;
	}
	
	
	
	
	
}

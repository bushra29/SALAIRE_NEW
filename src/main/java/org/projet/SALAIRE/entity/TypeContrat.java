package org.projet.SALAIRE.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeContrat {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long IdTypeC;
@Column(length=50,nullable = false,unique = true)
private String LibelleTypeC;

public TypeContrat() {
}

	public TypeContrat(long idTypeC) {
		IdTypeC = idTypeC;
	}

	public long getIdTypeC() {
	return IdTypeC;
}
public void setIdTypeC(long idTypeC) {
	IdTypeC = idTypeC;
}
public String getLibelleTypeC() {
	return LibelleTypeC;
}
public void setLibelleTypeC(String libelleTypeC) {
	LibelleTypeC = libelleTypeC;
}


}

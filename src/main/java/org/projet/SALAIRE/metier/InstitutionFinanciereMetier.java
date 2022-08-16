package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.InstitutionFinanciere;


public interface InstitutionFinanciereMetier {
	public InstitutionFinanciere addInstitution(InstitutionFinanciere i);
	public InstitutionFinanciere findInstitution(Long id);
	public void deleteInstitution(Long id);
	public List<InstitutionFinanciere> listInstitution();

	

}

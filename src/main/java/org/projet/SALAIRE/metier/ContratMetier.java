package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.Contrat;

public interface ContratMetier {

	public Contrat addContrat(Contrat c);
	public Contrat findContrat(Long id);
	public void deleteContrat(Long id);
	public List<Contrat> listContrat();
	public void activeContrat(Long id);


}

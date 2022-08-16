package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.Annee;

public interface AnneeMetier {

	public Annee addAnnee(Annee a);
	public Annee findAnnee(Long id);
	public void deleteAnnee(Long id);
	public List<Annee> listAnnee();
	public Annee activeAnnee(Long id);
	//public void rendreActive(Long id);



}

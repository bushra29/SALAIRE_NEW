package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.Titre;

public interface TitreMetier {
	public Titre addTitre(Titre t);
	public Titre findTitre(Long id);
	public void deleteTitre(Long id);
	public List<Titre> listTitre();

}

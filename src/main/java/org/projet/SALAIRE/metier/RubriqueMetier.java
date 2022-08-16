package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.Rubrique;

public interface RubriqueMetier {
	public Rubrique addRubrique(Rubrique r);
	public Rubrique findRubrique(Long id);
	public void deleteRubrique(Long id);
	public List<Rubrique> listRubrique();


}

package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.Categorie;


public interface CategorieMetier {
	public Categorie addCategorie(Categorie c);
	public Categorie findCategorie(Long id);
	public void deleteCategorie(Long id);
	public List<Categorie> listCategorie();
	public void genererEchelon();



}

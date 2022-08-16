package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.Niveau;

public interface NiveauMetier {
	public Niveau addNiveau(Niveau n);
	public Niveau findNiveau(Long id);
	public void deleteNiveau(Long id);
	public List<Niveau> listNiveau();
	public void genererCategorie();
	

}

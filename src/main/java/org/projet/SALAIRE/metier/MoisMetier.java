package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.Mois;


public interface MoisMetier {
	public Mois addMois(Mois m);
	public Mois findMois(Long id);
	public void deleteMois(Long id);
	public List<Mois> listMois();
	public Mois activeMois(Long id);
	

}

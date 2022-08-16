package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.Pays;

public interface PaysMetier {
	public Pays addPays(Pays p);
	public Pays findPays(Long id);
	public void deletePays(Long id);
	public List<Pays> listPays();
	

}

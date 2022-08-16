package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.PrimeGlobale;

public interface PrimeGlobaleMetier {
	public PrimeGlobale addPrimeGlobale(PrimeGlobale pg);
	public PrimeGlobale findPrimeGlobale(Long id);
	public void deletePrimeGlobale(Long id);
	public List<PrimeGlobale> listPrimeGlobale();

}

package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.PrimeIndividuelle;

public interface PrimeIndividuelleMetier {
	public PrimeIndividuelle addPrimeIndividuelle(PrimeIndividuelle pi);
	public PrimeIndividuelle findPrimeIndividuelle(Long id);
	public void deletePrimeIndividuelle(Long id);
	public List<PrimeIndividuelle> listPrimeIndividuelle();
	//public List<PrimeIndividuelle>findAllByIdContrat(long id);


}

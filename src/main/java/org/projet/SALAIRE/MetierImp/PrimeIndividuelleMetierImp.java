package org.projet.SALAIRE.MetierImp;

import java.util.List;

import org.projet.SALAIRE.dao.PrimeIndividuelleRepository;
import org.projet.SALAIRE.entity.PrimeIndividuelle;
import org.projet.SALAIRE.metier.PrimeIndividuelleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrimeIndividuelleMetierImp implements PrimeIndividuelleMetier {
	
	@Autowired
	PrimeIndividuelleRepository primeIndividuelleRepository;

	@Override
	public PrimeIndividuelle addPrimeIndividuelle(PrimeIndividuelle p) {
		// TODO Auto-generated method stub
		return primeIndividuelleRepository.save(p);
	}

	@Override
	public PrimeIndividuelle findPrimeIndividuelle(Long id) {
		// TODO Auto-generated method stub
		return primeIndividuelleRepository.findById(id).orElse(null);
	}

	@Override
	public void deletePrimeIndividuelle(Long id) {
		// TODO Auto-generated method stub
		primeIndividuelleRepository.deleteById(id);
		
		
	}

	/*@Override
	public List<PrimeIndividuelle> findAllByIdContrat(long id) {
		return primeIndividuelleRepository.findAllByIdContrat(id);
	}*/


	public List<PrimeIndividuelle> listPrimeIndividuelle() {
		// TODO Auto-generated method stub
		return primeIndividuelleRepository.findAll();
	}


	/*public List<PrimeIndividuelle>findAllByIdContratNull()
	{
		List<PrimeIndividuelle>ListPi = new ArrayList<PrimeIndividuelle>();
		List<PrimeIndividuelle>ListPi2 = new ArrayList<PrimeIndividuelle>();
		
		ListPi=primeIndividuelleRepository.findAll();
		ListPi2=primeIndividuelleRepository.findAllByIdContrat(id);
		ListePi.removeAll(ListPi2);
		
		return ListePi;
		
	}*/

	
}

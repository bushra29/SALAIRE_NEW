package org.projet.SALAIRE.MetierImp;

import java.util.List;

import org.projet.SALAIRE.dao.PrimeGlobaleRepository;
import org.projet.SALAIRE.entity.PrimeGlobale;
import org.projet.SALAIRE.metier.PrimeGlobaleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrimeGlobaleMetierImp implements PrimeGlobaleMetier {
	@Autowired
	PrimeGlobaleRepository primeGlobaleRepository;

	@Override
	public PrimeGlobale addPrimeGlobale(PrimeGlobale p) {
		// TODO Auto-generated method stub
		return primeGlobaleRepository.save(p);
	}
	@Override
	public PrimeGlobale findPrimeGlobale(Long id) {
		// TODO Auto-generated method stub
		return primeGlobaleRepository.findById(id).orElse(null);
	}
	@Override
	public void deletePrimeGlobale(Long id) {
		// TODO Auto-generated method stub
		primeGlobaleRepository.deleteById(id);
	}
	@Override
	public List<PrimeGlobale> listPrimeGlobale() {
		// TODO Auto-generated method stub
		return primeGlobaleRepository.findAll();
	}

}

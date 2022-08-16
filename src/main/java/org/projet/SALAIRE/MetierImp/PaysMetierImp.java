package org.projet.SALAIRE.MetierImp;

import java.util.List;

import org.projet.SALAIRE.dao.PaysRepository;
import org.projet.SALAIRE.entity.Pays;
import org.projet.SALAIRE.metier.PaysMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaysMetierImp implements PaysMetier {
	@Autowired
	org.projet.SALAIRE.dao.PaysRepository PaysRepository;

	@Override
	public Pays addPays(Pays p) {
		// TODO Auto-generated method stub
		return PaysRepository.save(p);
	}

	@Override
	public Pays findPays(Long id) {
		// TODO Auto-generated method stub
		return PaysRepository.findById(id).orElse(null);
	}

	@Override
	public void deletePays(Long id) {
		// TODO Auto-generated method stub
		PaysRepository.deleteById(id);
		
		
	}

	@Override
	public List<Pays> listPays() {
		// TODO Auto-generated method stub
		return PaysRepository.findAll();
	}


}

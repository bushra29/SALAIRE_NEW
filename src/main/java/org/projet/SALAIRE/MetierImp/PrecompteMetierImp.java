package org.projet.SALAIRE.MetierImp;

import java.util.List;

import org.projet.SALAIRE.dao.PrecompteRepository;
import org.projet.SALAIRE.entity.Precompte;
import org.projet.SALAIRE.metier.PrecompteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrecompteMetierImp implements PrecompteMetier {
	@Autowired
	PrecompteRepository precompteRepository;

	@Override
	public Precompte addPrecompte(Precompte p) {
		// TODO Auto-generated method stub
		return precompteRepository.save(p);
	}

	@Override
	public Precompte findPrecompte(Long id) {
		// TODO Auto-generated method stub
		return precompteRepository.findById(id).orElse(null);
	}

	@Override
	public void deletePrecompte(Long id) {
		// TODO Auto-generated method stub
		precompteRepository.deleteById(id);
		
		
	}

	@Override
	public List<Precompte> listPrecompte() {
		// TODO Auto-generated method stub
		return precompteRepository.findAll();
	}
}

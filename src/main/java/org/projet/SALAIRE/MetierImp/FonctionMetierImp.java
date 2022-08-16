package org.projet.SALAIRE.MetierImp;

import java.util.List;

import org.projet.SALAIRE.dao.FonctionRepository;
import org.projet.SALAIRE.entity.Fonction;
import org.projet.SALAIRE.metier.FonctionMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FonctionMetierImp implements FonctionMetier {
	@Autowired
	FonctionRepository fonctionRepository;

	@Override
	public Fonction addFonction(Fonction f) {
		// TODO Auto-generated method stub
		return fonctionRepository.save(f);
	}

	@Override
	public Fonction findFonction(Long id) {
		// TODO Auto-generated method stub
		return fonctionRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteFonction(Long id) {
		// TODO Auto-generated method stub
		fonctionRepository.deleteById(id);
		
		
	}

	@Override
	public List<Fonction> listFonction() {
		// TODO Auto-generated method stub
		return fonctionRepository.findAll();
	}


}

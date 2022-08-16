package org.projet.SALAIRE.MetierImp;

import java.util.List;

import org.projet.SALAIRE.dao.TitreRepository;
import org.projet.SALAIRE.entity.Titre;
import org.projet.SALAIRE.metier.TitreMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class  TitreMetierImp implements TitreMetier {
	@Autowired
	org.projet.SALAIRE.dao.TitreRepository TitreRepository;

	@Override
	public Titre addTitre(Titre t) {
		// TODO Auto-generated method stub
		return TitreRepository.save(t);
	}

	@Override
	public Titre findTitre(Long id) {
		// TODO Auto-generated method stub
		return TitreRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteTitre(Long id) {
		// TODO Auto-generated method stub
		TitreRepository.deleteById(id);
		
		
	}

	@Override
	public List<Titre> listTitre() {
		// TODO Auto-generated method stub
		return TitreRepository.findAll();
	}


}

package org.projet.SALAIRE.MetierImp;

import java.util.List;

import org.projet.SALAIRE.dao.RubriqueRepository;
import org.projet.SALAIRE.entity.Rubrique;
import org.projet.SALAIRE.metier.RubriqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubriqueMetierImp implements RubriqueMetier {
	@Autowired
	org.projet.SALAIRE.dao.RubriqueRepository RubriqueRepository;

	@Override
	public Rubrique addRubrique(Rubrique r) {
		// TODO Auto-generated method stub
		return RubriqueRepository.save(r);
	}

	@Override
	public Rubrique findRubrique(Long id) {
		return RubriqueRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteRubrique(Long id) {
		// TODO Auto-generated method stub
		RubriqueRepository.deleteById(id);
		
		
	}

	@Override
	public List<Rubrique> listRubrique() {
		// TODO Auto-generated method stub
		return RubriqueRepository.findAll();
	}


}

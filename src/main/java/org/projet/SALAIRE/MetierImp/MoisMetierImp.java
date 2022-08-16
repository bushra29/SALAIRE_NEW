package org.projet.SALAIRE.MetierImp;

import java.util.List;

import org.projet.SALAIRE.dao.MoisRepository;
import org.projet.SALAIRE.entity.Mois;
import org.projet.SALAIRE.metier.MoisMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class MoisMetierImp implements MoisMetier {
	@Autowired
	MoisRepository moisRepository;

	@Override
	public Mois addMois(Mois m) {
		return moisRepository.save(m);
	}

	@Override
	public Mois findMois(Long id) {
		return moisRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteMois(Long id) {
		moisRepository.deleteById(id);
		
		
	}
	public Mois activeMois(Long IdMois)
	{
		moisRepository.toutDesactiver();
		moisRepository.activerMois(IdMois);
		return moisRepository.findById(IdMois).orElseThrow(()->(new EntityNotFoundException("")));
	}
	@Override
	public List<Mois> listMois() {
		// TODO Auto-generated method stub
		return moisRepository.findAll();
	}

}

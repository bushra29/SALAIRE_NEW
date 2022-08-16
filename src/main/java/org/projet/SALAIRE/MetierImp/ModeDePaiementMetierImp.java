package org.projet.SALAIRE.MetierImp;

import java.util.List;

import org.projet.SALAIRE.dao.ModeDePaiementRepository;
import org.projet.SALAIRE.entity.ModeDePaiement;
import org.projet.SALAIRE.metier.ModeDePaiementMetier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeDePaiementMetierImp implements ModeDePaiementMetier {
	@Autowired
	ModeDePaiementRepository modeDePaiementRepository;

	@Override
	public ModeDePaiement addMode(ModeDePaiement m) {
		// TODO Auto-generated method stub
		return modeDePaiementRepository.save(m);
	}

	@Override
	public ModeDePaiement findMode(Long id) {
		// TODO Auto-generated method stub
		return modeDePaiementRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteMode(Long id) {
		// TODO Auto-generated method stub
		modeDePaiementRepository.deleteById(id);
		
		
	}

	@Override
	public List<ModeDePaiement> listMode() {
		// TODO Auto-generated method stub
		return modeDePaiementRepository.findAll();
	}

}

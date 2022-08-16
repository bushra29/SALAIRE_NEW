package org.projet.SALAIRE.MetierImp;

import java.util.List;

import org.projet.SALAIRE.dao.EchelonRepository;
import org.projet.SALAIRE.dao.ParametreRepository;
import org.projet.SALAIRE.entity.Echelon;
import org.projet.SALAIRE.entity.Parametre;
import org.projet.SALAIRE.metier.EchelonMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EchelonMetierImp implements EchelonMetier {
	@Autowired
	EchelonRepository echelonRepository;
	@Autowired
	ParametreRepository parametreRepository;

	@Override
	public Echelon addEchelon(Echelon e) {
		Parametre p = parametreRepository.findbyCategorie();
		e.setRang(p.getValeur()+1);
		p.setValeur(p.getValeur()+1);
		parametreRepository.save(p);
		return echelonRepository.save(e);
		
	}

	@Override
	public Echelon findEchelon(Long id) {
		// TODO Auto-generated method stub
		return echelonRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteEchelon(Long id) {
		// TODO Auto-generated method stub
		echelonRepository.deleteById(id);
		
		
	}

	@Override
	public List<Echelon> listEchelon() {
		// TODO Auto-generated method stub
		return echelonRepository.findAll();
	}

	//Liste de tous les agent avec leur niveau, categorie, echelon et salaire
	//Liste des agents avec leur contrats 
	//Liste agents avec leur primes indi

}

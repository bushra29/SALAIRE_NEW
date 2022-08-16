package org.projet.SALAIRE.MetierImp;

import java.util.List;

import org.projet.SALAIRE.dao.SituationMatrimonialeRepository;
import org.projet.SALAIRE.entity.SituationMatrimoniale;
import org.projet.SALAIRE.metier.SituationMatrimonialeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SituationMatrimonialeMetierImp implements SituationMatrimonialeMetier {
	@Autowired
	SituationMatrimonialeRepository situationMatrimonialeRepository;

	@Override
	public SituationMatrimoniale addSituation(SituationMatrimoniale s) {
		// TODO Auto-generated method stub
		return situationMatrimonialeRepository.save(s);
	}

	@Override
	public SituationMatrimoniale findSituation(Long id) {
		return situationMatrimonialeRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteSituation(Long id) {
		// TODO Auto-generated method stub
		situationMatrimonialeRepository.deleteById(id);
		
		
	}

	@Override
	public List<SituationMatrimoniale> listSituation() {
		// TODO Auto-generated method stub
		return situationMatrimonialeRepository.findAll();
	}


}

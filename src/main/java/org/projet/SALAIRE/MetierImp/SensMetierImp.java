package org.projet.SALAIRE.MetierImp;

import java.util.List;


import org.projet.SALAIRE.dao.SensRepository;
import org.projet.SALAIRE.entity.Sens;
import org.projet.SALAIRE.metier.SensMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensMetierImp implements SensMetier {
	@Autowired
	SensRepository sensRepository;

	@Override
	public Sens addSens(Sens s) {
		// TODO Auto-generated method stub
		return sensRepository.save(s);
	}

	@Override
	public Sens findSens(Long id) {
		return sensRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteSens(Long id) {
		// TODO Auto-generated method stub
		sensRepository.deleteById(id);
		
		
	}

	@Override
	public List<Sens> listSens() {
		// TODO Auto-generated method stub
		return sensRepository.findAll();
	}


}

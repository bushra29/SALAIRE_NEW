package org.projet.SALAIRE.MetierImp;

import java.util.List;

import org.projet.SALAIRE.dao.AvanceRepository;
import org.projet.SALAIRE.entity.Avance;
import org.projet.SALAIRE.metier.AvanceMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvanceMetierImp implements AvanceMetier {
	@Autowired
	AvanceRepository avanceRepository;

	@Override
	public Avance addAvance(Avance a) {
		// TODO Auto-generated method stub
		return avanceRepository.save(a);
	}

	@Override
	public Avance findAvance(Long id) {
		// TODO Auto-generated method stub
		return avanceRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteAvance(Long id) {
		// TODO Auto-generated method stub
		avanceRepository.deleteById(id);
		
		
	}

	@Override
	public List<Avance> listAvance() {
		// TODO Auto-generated method stub
		return avanceRepository.findAll();
	}


}

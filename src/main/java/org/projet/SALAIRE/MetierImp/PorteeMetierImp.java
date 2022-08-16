package org.projet.SALAIRE.MetierImp;

import java.util.List;

import org.projet.SALAIRE.dao.PorteeRepository;
import org.projet.SALAIRE.entity.Portee;
import org.projet.SALAIRE.metier.PorteeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PorteeMetierImp implements PorteeMetier {
	@Autowired
	org.projet.SALAIRE.dao.PorteeRepository PorteeRepository;

	@Override
	public Portee addPortee(Portee p) {
		// TODO Auto-generated method stub
		return PorteeRepository.save(p);
	}

	@Override
	public Portee findPortee(Long id) {
		// TODO Auto-generated method stub
		return PorteeRepository.findById(id).orElse(null);
	}

	@Override
	public void deletePortee(Long id) {
		// TODO Auto-generated method stub
		PorteeRepository.deleteById(id);
		
		
	}

	@Override
	public List<Portee> listPortee() {
		// TODO Auto-generated method stub
		return PorteeRepository.findAll();
	}

}

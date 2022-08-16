package org.projet.SALAIRE.MetierImp;
import java.util.List;

import org.projet.SALAIRE.dao.ParametreRepository;
import org.projet.SALAIRE.entity.Parametre;
import org.projet.SALAIRE.metier.ParametreMetier;
import org.springframework.beans.factory.annotation.Autowired;

public class ParametreMetierImp implements ParametreMetier {
	@Autowired
	ParametreRepository parametreRepository;

	@Override
	public Parametre addParametre(Parametre p) {
		// TODO Auto-generated method stub
		return parametreRepository.save(p);
	}

	@Override
	public Parametre findParametre(Long id) {
		// TODO Auto-generated method stub
		return parametreRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteParametre(Long id) {
		// TODO Auto-generated method stub
		parametreRepository.deleteById(id);
		
	}

	@Override
	public List<Parametre> listParametre() {
		// TODO Auto-generated method stub
		return parametreRepository.findAll();
	}

}

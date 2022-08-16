package org.projet.SALAIRE.MetierImp;

import java.util.List;

import org.projet.SALAIRE.dao.RetenueRepository;
import org.projet.SALAIRE.entity.Retenue;
import org.projet.SALAIRE.metier.RetenueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetenueMetierImp implements RetenueMetier {
	@Autowired
	RetenueRepository retenueRepository;

	@Override
	public Retenue addRetenue(Retenue r) {
		// TODO Auto-generated method stub
		return retenueRepository.save(r);
	}

	@Override
	public Retenue findRetenue(Long id) {
		// TODO Auto-generated method stub
		return retenueRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteRetenue(Long id) {
		// TODO Auto-generated method stub
		retenueRepository.deleteById(id);
		
		
	}

	@Override
	public List<Retenue> listRetenue() {
		// TODO Auto-generated method stub
		return retenueRepository.findAll();
	}

}

package org.projet.SALAIRE.MetierImp;

import java.util.List;

import org.projet.SALAIRE.dao.TypeContratRepository;
import org.projet.SALAIRE.entity.TypeContrat;
import org.projet.SALAIRE.metier.TypeContratMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeContratMetierImp implements TypeContratMetier {
	@Autowired
	org.projet.SALAIRE.dao.TypeContratRepository TypeContratRepository;

	@Override
	public TypeContrat addTypeContrat(TypeContrat tc) {
		// TODO Auto-generated method stub
		return TypeContratRepository.save(tc);
	}

	@Override
	public TypeContrat findTypeContrat(Long id) {
		// TODO Auto-generated method stub
		return TypeContratRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteTypeContrat(Long id) {
		// TODO Auto-generated method stub
		TypeContratRepository.deleteById(id);
		
		
	}

	@Override
	public List<TypeContrat> listTypeContrat() {
		// TODO Auto-generated method stub
		return TypeContratRepository.findAll();
	}

}

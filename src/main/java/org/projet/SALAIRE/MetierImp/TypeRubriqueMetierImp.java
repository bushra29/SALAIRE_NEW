package org.projet.SALAIRE.MetierImp;

import java.util.List;

import org.projet.SALAIRE.dao.TypeRubriqueRepository;
import org.projet.SALAIRE.entity.TypeRubrique;
import org.projet.SALAIRE.metier.TypeRubriqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeRubriqueMetierImp implements TypeRubriqueMetier {
	@Autowired
	org.projet.SALAIRE.dao.TypeRubriqueRepository TypeRubriqueRepository;

	@Override
	public TypeRubrique addTypeRubrique(TypeRubrique tr) {
		// TODO Auto-generated method stub
		return TypeRubriqueRepository.save(tr);
	}

	@Override
	public TypeRubrique findTypeRubrique(Long id) {
		// TODO Auto-generated method stub
		return TypeRubriqueRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteTypeRubrique(Long id) {
		// TODO Auto-generated method stub
		TypeRubriqueRepository.deleteById(id);
		
		
	}

	@Override
	public List<TypeRubrique> listTypeRubrique() {
		// TODO Auto-generated method stub
		return TypeRubriqueRepository.findAll();
	}

}

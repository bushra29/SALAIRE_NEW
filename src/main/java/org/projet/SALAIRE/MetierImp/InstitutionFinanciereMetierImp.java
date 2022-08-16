package org.projet.SALAIRE.MetierImp;

import java.util.List;

import org.projet.SALAIRE.dao.InstitutionFinanciereRepository;
import org.projet.SALAIRE.entity.InstitutionFinanciere;
import org.projet.SALAIRE.metier.InstitutionFinanciereMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutionFinanciereMetierImp implements InstitutionFinanciereMetier {
	@Autowired
	InstitutionFinanciereRepository institutionFinanciereRepository;

	@Override
	public InstitutionFinanciere addInstitution(InstitutionFinanciere i) {
		// TODO Auto-generated method stub
		return institutionFinanciereRepository.save(i);
	}

	@Override
	public InstitutionFinanciere findInstitution(Long id) {
		// TODO Auto-generated method stub
		return institutionFinanciereRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteInstitution(Long id) {
		// TODO Auto-generated method stub
		institutionFinanciereRepository.deleteById(id);
		
		
	}

	@Override
	public List<InstitutionFinanciere> listInstitution() {
		// TODO Auto-generated method stub
		return institutionFinanciereRepository.findAll();
	}

}

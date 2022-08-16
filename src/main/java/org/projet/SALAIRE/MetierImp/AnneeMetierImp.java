package org.projet.SALAIRE.MetierImp;

import java.util.List;

import org.projet.SALAIRE.dao.AnneeRepository;
import org.projet.SALAIRE.entity.Annee;
import org.projet.SALAIRE.metier.AnneeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class AnneeMetierImp implements AnneeMetier {
	@Autowired
	AnneeRepository anneeRepository;

	@Override
	public Annee addAnnee(Annee a) {
		// TODO Auto-generated method stub
		return anneeRepository.save(a);
	}

	public Annee activeAnnee(Long IdAnnee)
	{
		anneeRepository.toutDesactiver();
		anneeRepository.activerAnnee(IdAnnee);
		return anneeRepository.findById(IdAnnee).orElseThrow(()->(new EntityNotFoundException("")));
	}

	/*@Override
	public String findAnneActive() {
		return anneeRepository.findAnneActive();
	}*/

	public void rendreActive(Long IdAnnee)
{
	anneeRepository.activerAnnee(IdAnnee);
}
	@Override
	public Annee findAnnee(Long id) {
		// TODO Auto-generated method stub
		return anneeRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteAnnee(Long id) {
		// TODO Auto-generated method stub
		anneeRepository.deleteById(id);
	}

	@Override
	public List<Annee> listAnnee() {
		// TODO Auto-generated method stub
		return anneeRepository.findAll();
	}

}

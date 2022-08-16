package org.projet.SALAIRE.MetierImp;

import java.util.ArrayList;
import java.util.List;

import org.projet.SALAIRE.dao.AgentRepository;
import org.projet.SALAIRE.dao.ContratRepository;
import org.projet.SALAIRE.entity.Agent;
import org.projet.SALAIRE.entity.Contrat;
import org.projet.SALAIRE.metier.ContratMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ContratMetierImp implements ContratMetier {
	@Autowired
	ContratRepository contratRepository;
	@Autowired
	AgentRepository agentRepository;
	@Override
	public Contrat addContrat(Contrat c) {

		c.setEtat(true);

		Agent a = agentRepository.findById(c.getAgent().getIdAgent()).orElse(null);
		a.setEtat(true);
		agentRepository.save(a);

		c.setEchelonStart(c.getEchelonStart());
		return contratRepository.save(c);

	}

	@Override
	public Contrat findContrat(Long id) {
		// TODO Auto-generated method stub
		return contratRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteContrat(Long id) {
		// TODO Auto-generated method stub
		contratRepository.deleteById(id);
	}

	@Override
	public List<Contrat> listContrat() {
		// TODO Auto-generated method stub
		return contratRepository.findAll();
	}
	public void activeContrat(Long id)
	{
		 contratRepository.activerAgent();
	}

	public void ModifierEtat(Long idAgent){
		agentRepository.findAll().forEach(agentEtat -> {
			if (agentEtat.getIdAgent() == idAgent) {
				agentEtat.setEtat(true);
			}
		});
	}

}

package org.projet.SALAIRE.MetierImp;

import java.util.ArrayList;
import java.util.List;

import org.projet.SALAIRE.dao.AgentRepository;
import org.projet.SALAIRE.entity.Agent;
import org.projet.SALAIRE.metier.AgentMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
public class AgentMetierImp implements AgentMetier {
	@Autowired
	AgentRepository agentRepository;


	@Override
	public Agent addAgent(Agent a) {
		return agentRepository.save(a);
	}
 
	@Override
	public Agent findAgent(Long id) { 
		return agentRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteAgent(Long id) {
		agentRepository.deleteById(id);
		
	}

	@Override
	public List<Agent> listAgent() {
		return agentRepository.findAll();
	}
	public Agent activeAgent(Long IdAgent)
	{
		agentRepository.toutDesactiver();
		agentRepository.activerAgent(IdAgent);
		return agentRepository.findById(IdAgent).orElseThrow(()->(new EntityNotFoundException("")));
	}

	@Override
	public int nbreAgent(Agent a) {
		return agentRepository.nbreAgent(a);
	}


	@Override
	public List<Agent> searchAgent(String keyword) {
		List<Agent> Agent = new ArrayList<>();

		agentRepository.findAll().forEach(agents ->
		{
			if(agents.getNomAgent().contains(keyword) || agents.getPrenomAgent().contains(keyword) ){
				Agent.add(agents);
			}
		});
		return Agent;
	}

// appel la au niveau du controller ok
	
	 /* public void AgentSalaire(Agent a, double Salaire )
	 {
	     Agent a1 = agentRepository.save(a);
	     echelonRepository.save(new org.projet.entity.Echelon());
	 }*/

}

package org.projet.SALAIRE.metier;

import java.util.List;

import org.projet.SALAIRE.entity.Agent;

public interface AgentMetier {
	
	public Agent addAgent(Agent a);
	public Agent findAgent(Long id);
	public void deleteAgent(Long id);
	public List<Agent> listAgent();
	public Agent activeAgent(Long id);
	public int nbreAgent(Agent a);

	List<Agent> searchAgent(String keyword);
	//public List<Agent> searchAgent(String keyword);
	//essaie cette fonction ds postmn ok
	
}

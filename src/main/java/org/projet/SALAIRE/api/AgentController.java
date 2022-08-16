package org.projet.SALAIRE.api;

import java.util.List;


import org.projet.SALAIRE.entity.Agent;
import org.projet.SALAIRE.metier.AgentMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/Agent")
public class AgentController {
	
	@Autowired private AgentMetier agentMetier;
	

	@PostMapping(path="/Save")
	public Agent AjouterAgent(@RequestBody @Validated Agent a)
	{
		System.out.println(a.getPays().getIdPays()+" "+a.getInstitutionFinanciere().getIdInsti()+" "+a.getFonction().getIdFonct());
		return agentMetier.addAgent(a);
	}
	@GetMapping(path="/Nbre")
	public int NbreAgent (@RequestBody @Validated Agent a )
	{

		return agentMetier.nbreAgent(a);
	}

	@GetMapping(path="/Search/{keyword}")
	public List<Agent> SearchAgent (@PathVariable("keyword") String keyword )
	{
		
		return agentMetier.searchAgent(keyword);
	}
	@GetMapping(path="/Find/{id}")
	public Agent findOneAgent (@PathVariable("id") Long IdAgent)
	{
		
		return agentMetier.findAgent(IdAgent);
	}
	
	@DeleteMapping(path="/Delete/{id}")
	public void DeleteOneAgent (@PathVariable("id") Long IdAgent)
	{
		
		agentMetier.deleteAgent(IdAgent);
	}
	
	@GetMapping(path="/List")
	public List<Agent> ListAgent ()
	{
		return agentMetier.listAgent();
	}

	@GetMapping(path = "/ActiverAgent/{id}")
	public Agent ActiverAgent(@PathVariable("id") Long IdAgent) {
		return agentMetier.activeAgent(IdAgent);
	}


}

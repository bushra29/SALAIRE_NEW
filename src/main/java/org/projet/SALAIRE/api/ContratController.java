package org.projet.SALAIRE.api;

import java.util.List;

import org.projet.SALAIRE.MetierImp.ContratMetierImp;
import org.projet.SALAIRE.entity.Contrat;
import org.projet.SALAIRE.metier.ContratMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/Contrat")
public class ContratController {
@Autowired private ContratMetier contratMetier;
	@Autowired private ContratMetierImp contratMetierImp;
	

	@PostMapping(path="/Save")
	public Contrat AjouterContrat(@RequestBody Contrat c)
	{
		// contratMetierImp.ModifierEtat(c.getIdContrat());
		return contratMetier.addContrat(c);

	}


	@GetMapping(path="/Find/{id}")
	public Contrat findOneContrat (@PathVariable("id") Long id)
	{
		
		return contratMetier.findContrat(id);
	}
	
	@GetMapping(path="/List")
	public List<Contrat> ListContrat ()
	{
		return contratMetier.listContrat();
	}
	
	@DeleteMapping(path="/Delete/{id}")
	public void DeleteOneContrat (@PathVariable("id") Long IdContrat)
	{
		
		contratMetier.deleteContrat(IdContrat);
	}
	@GetMapping(path = "/ActiverContrat/{id}")
	public void ActiverContrat(@PathVariable("id") Long IdContrat) {
		contratMetier.activeContrat(IdContrat);
	}
}

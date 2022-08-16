package org.projet.SALAIRE.api;

import java.util.List;

import org.projet.SALAIRE.entity.Retenue;
import org.projet.SALAIRE.metier.RetenueMetier;
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
@RequestMapping(path = "/api/Retenue")
public class RetenueController {
@Autowired private RetenueMetier retenueMetier;
	

	@PostMapping(path="/Save")
	public Retenue AjouterRetenue(@RequestBody Retenue r)
	{
		return retenueMetier.addRetenue(r);
	}
	
	@GetMapping(path="/Find/{id}")
	public Retenue findOneRetenue (@PathVariable("id") Long id)
	{
		
		return retenueMetier.findRetenue(id);
	}
	
	@GetMapping(path="/List")
	public List<Retenue> ListRetenue ()
	{
		return retenueMetier.listRetenue();
	}
	
	@DeleteMapping(path="/Delete/{id}")
	public void DeleteOneRubrique (@PathVariable("id") Long IdRetenue)
	{
		
		retenueMetier.deleteRetenue(IdRetenue);
	}
}

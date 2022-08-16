package org.projet.SALAIRE.api;
import java.util.List;

import org.projet.SALAIRE.entity.Pays;
import org.projet.SALAIRE.metier.PaysMetier;
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
@RequestMapping(path = "/api/Pays")
public class PaysController {
@Autowired private PaysMetier paysMetier;
	

	@PostMapping(path="/Save")
	public Pays AjouterFonction(@RequestBody  Pays p)
	{
		return paysMetier.addPays(p);
	}
	
	@GetMapping(path="/Find/{id}")
	public  Pays findOnePays (@PathVariable("id") Long id)
	{
		
		return paysMetier.findPays(id);
	}
	
	@GetMapping(path="/List")
	public List< Pays> ListPays ()
	{
		return paysMetier.listPays();
	}

	@DeleteMapping(path="/Delete/{id}")
	public void DeleteOnePays (@PathVariable("id") Long IdPays)
	{
		
		paysMetier.deletePays(IdPays);
	}
	
}

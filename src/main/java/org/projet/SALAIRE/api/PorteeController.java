package org.projet.SALAIRE.api;

import java.util.List;

import org.projet.SALAIRE.entity.Portee;
import org.projet.SALAIRE.metier.PorteeMetier;
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
@RequestMapping(path = "/api/Portee")
public class PorteeController {
@Autowired private PorteeMetier porteeMetier;
	

	@PostMapping(path="/Save")
	public Portee AjouterPortee(@RequestBody Portee p)
	{
		return porteeMetier.addPortee(p);
	}
	
	@GetMapping(path="/Find/{id}")
	public Portee findOnePortee (@PathVariable("id") Long id)
	{
		
		return porteeMetier.findPortee(id);
	}
	
	@GetMapping(path="/List")
	public List<Portee> ListPortee ()
	{
		return porteeMetier.listPortee();
	}
	
	@DeleteMapping(path="/Delete/{id}")
	public void DeleteOnePortee (@PathVariable("id") Long IdPortee)
	{
		
		porteeMetier.deletePortee(IdPortee);
	}
	

}

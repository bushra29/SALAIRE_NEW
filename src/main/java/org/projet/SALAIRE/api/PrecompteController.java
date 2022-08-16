package org.projet.SALAIRE.api;

import java.util.List;

import org.projet.SALAIRE.entity.Precompte;
import org.projet.SALAIRE.metier.PrecompteMetier;
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
@RequestMapping(path = "/api/Precompte")
public class PrecompteController {
@Autowired private PrecompteMetier precompteMetier;
	

	@PostMapping(path="/Save")
	public Precompte AjouterPrecompte(@RequestBody Precompte p)
	{
		return precompteMetier.addPrecompte(p);
	}
	
	@GetMapping(path="/Find/{id}")
	public Precompte findOnePrecompte (@PathVariable("id") Long id)
	{
		
		return precompteMetier.findPrecompte(id);
	}
	
	@GetMapping(path="/List")
	public List<Precompte> ListPrecompte ()
	{
		return precompteMetier.listPrecompte();
	}
	@DeleteMapping(path="/Delete/{id}")
	public void DeleteOnePrecompte (@PathVariable("id") Long IdPreco)
	{
		precompteMetier.deletePrecompte(IdPreco);
		
		
	}
}

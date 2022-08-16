package org.projet.SALAIRE.api;

import java.util.List;

import org.projet.SALAIRE.entity.PrimeGlobale;
import org.projet.SALAIRE.metier.PrimeGlobaleMetier;
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
@RequestMapping(path = "/api/PrimeGlobale")
public class PrimeGlobaleController {

	@Autowired
	public PrimeGlobaleMetier primeGlobaleMetier;
	
	@PostMapping(path = "/save")
	public PrimeGlobale AjouterPrimeGlobale(@RequestBody PrimeGlobale p)
	{
		return primeGlobaleMetier.addPrimeGlobale(p);
	}
	
	@GetMapping(path="/Find/{id}")
	public PrimeGlobale FindOnePrimeGlobale(@PathVariable("id") Long id)
	{
		return primeGlobaleMetier.findPrimeGlobale(id);
	}
	
	@GetMapping(path="/List")
	public List<PrimeGlobale> ListePrimeGlobale()
	{
		return primeGlobaleMetier.listPrimeGlobale();
	}
	@DeleteMapping(path="/Delete/{id}")
	public void DeleteOnePrimeG (@PathVariable("id") Long IdPrimeG)
	{
		
		primeGlobaleMetier.deletePrimeGlobale(IdPrimeG);
	}
}


package org.projet.SALAIRE.api;

import java.util.List;

import org.projet.SALAIRE.entity.PrimeIndividuelle;
import org.projet.SALAIRE.metier.PrimeIndividuelleMetier;
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
@RequestMapping(path = "/api/PrimeIndividuelle")
public class PrimeIndividuelleController {
@Autowired private PrimeIndividuelleMetier primeIndividuelleMetier;
	

	@PostMapping(path="/Save")
	public PrimeIndividuelle AjouterPrimeIndividuelle(@RequestBody PrimeIndividuelle pi)
	{
		return primeIndividuelleMetier.addPrimeIndividuelle(pi);
	}
	
	@GetMapping(path="/Find/{id}")
	public PrimeIndividuelle findOnePrimeIndividuelle (@PathVariable("id") Long id)
	{
		
		return primeIndividuelleMetier.findPrimeIndividuelle(id);
	}
	
	/*@GetMapping(path="/List/{id}")
	public List<PrimeIndividuelle> ListPrimeIndividuelle (@PathVariable("id") Long id)
	{
		return primeIndividuelleMetier.findAllByIdContrat(id);
	}*/
	@GetMapping(path="/List")
	public List<PrimeIndividuelle> ListPrimeIndividuelle ()
	{
		return primeIndividuelleMetier.listPrimeIndividuelle();
	}
	
	@DeleteMapping(path="/Delete/{id}")
	public void DeleteOnePrimeI (@PathVariable("id") Long IdPrimeI)
	{
		
		primeIndividuelleMetier.deletePrimeIndividuelle(IdPrimeI);
	}
}

package org.projet.SALAIRE.api;

import java.util.List;

import org.projet.SALAIRE.entity.InstitutionFinanciere;
import org.projet.SALAIRE.metier.InstitutionFinanciereMetier;
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
@RequestMapping(path = "/api/InstitutionFinanciere")
public class InstitutionFinanciereController {
@Autowired private InstitutionFinanciereMetier institutionFinanciereMetier;
	

	@PostMapping(path="/Save")
	public InstitutionFinanciere AjouterInstitution(@RequestBody InstitutionFinanciere i)
	{
		return institutionFinanciereMetier.addInstitution(i);
	}
	
	@GetMapping(path="/Find/{id}")
	public InstitutionFinanciere findOneInstitution (@PathVariable("id") Long id)
	{
		
		return institutionFinanciereMetier.findInstitution(id);
	}
	
	@GetMapping(path="/List")
	public List<InstitutionFinanciere> ListInstitution ()
	{
		return institutionFinanciereMetier.listInstitution();
	}
	@DeleteMapping(path="/Delete/{id}")
	public void DeleteOneInsti (@PathVariable("id") Long IdInsti)
	{
		
		institutionFinanciereMetier.deleteInstitution(IdInsti);
	}
	

}

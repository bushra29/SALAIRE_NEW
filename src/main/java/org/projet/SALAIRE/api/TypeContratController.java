package org.projet.SALAIRE.api;

import java.util.List;

import org.projet.SALAIRE.entity.TypeContrat;
import org.projet.SALAIRE.metier.TypeContratMetier;
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
@RequestMapping(path = "/api/TypeContrat")
public class TypeContratController {
@Autowired private TypeContratMetier typeContratMetier;
	

	@PostMapping(path="/Save")
	public TypeContrat AjouterTypeContrat(@RequestBody TypeContrat tc)
	{
		return typeContratMetier.addTypeContrat(tc);
	}
	
	@GetMapping(path="/Find/{id}")
	public TypeContrat findOneTypeContrat (@PathVariable("id") Long id)
	{
		
		return typeContratMetier.findTypeContrat(id);
	}
	
	@GetMapping(path="/List")
	public List<TypeContrat> ListTypeContrat ()
	{
		return typeContratMetier.listTypeContrat();
	}
	@DeleteMapping(path="/Delete/{id}")
	public void DeleteTypeContrat (@PathVariable("id") Long IdTypeC)
	{
		
		 typeContratMetier.deleteTypeContrat(IdTypeC);
	}

}

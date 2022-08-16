package org.projet.SALAIRE.api;

import java.util.List;

import org.projet.SALAIRE.entity.Rubrique;
import org.projet.SALAIRE.metier.RubriqueMetier;
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
@RequestMapping(path = "/api/Rubrique")
public class RubriqueController {
@Autowired private RubriqueMetier rubriqueMetier;
	

	@PostMapping(path="/Save")
	public Rubrique AjouterRubrique(@RequestBody Rubrique r)
	{
		return rubriqueMetier.addRubrique(r);
	}
	
	@GetMapping(path="/Find/{id}")
	public Rubrique findOneRubrique (@PathVariable("id") Long id)
	{
		
		return rubriqueMetier.findRubrique(id);
	}
	
	@GetMapping(path="/List")
	public List<Rubrique> ListRubrique ()
	{
		return rubriqueMetier.listRubrique();
	}
	@DeleteMapping(path="/Delete/{id}")
	public void DeleteOneRubrique (@PathVariable("id") Long IdRubrique)
	{
		
		rubriqueMetier.deleteRubrique(IdRubrique);
	}
}

package org.projet.SALAIRE.api;

import java.util.List;

import org.projet.SALAIRE.entity.TypeRubrique;
import org.projet.SALAIRE.metier.TypeRubriqueMetier;
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
@RequestMapping(path = "/api/TypeRubrique")
public class TypeRubriqueController {
@Autowired private TypeRubriqueMetier TypeRubriqueMetier;
	

	@PostMapping(path="/Save")
	public TypeRubrique AjouterTypeRubrique(@RequestBody TypeRubrique tr)
	{
		return TypeRubriqueMetier.addTypeRubrique(tr);
	}
	
	@GetMapping(path="/Find/{id}")
	public TypeRubrique findOneTypeRubrique (@PathVariable("id") Long id)
	{
		
		return TypeRubriqueMetier.findTypeRubrique(id);
	}
	
	@GetMapping(path="/List")
	public List<TypeRubrique> ListTypeRubrique ()
	{
		return TypeRubriqueMetier.listTypeRubrique();
	}
	@DeleteMapping(path="/Delete/{id}")
	public void DeleteTypeRubrique(@PathVariable("id") Long IdTypeR)
	{
		
		TypeRubriqueMetier.deleteTypeRubrique(IdTypeR);
	}
}

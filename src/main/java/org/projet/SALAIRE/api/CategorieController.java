package org.projet.SALAIRE.api;

import java.util.List;

import org.projet.SALAIRE.entity.Categorie;
import org.projet.SALAIRE.metier.CategorieMetier;
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
@RequestMapping(path = "/api/Categorie")
public class CategorieController {
@Autowired private CategorieMetier categorieMetier;

	@GetMapping(path="/Generer")
public void GenererEchelon()
{
	categorieMetier.genererEchelon();
}
	@PostMapping(path="/Save")
	public Categorie AjouterCategorie(@RequestBody Categorie c)
	{
		return categorieMetier.addCategorie(c);
	}
	
	@GetMapping(path="/Find/{id}")
	public Categorie findOneCategorie (@PathVariable("id") Long id)
	{
		
		return categorieMetier.findCategorie(id);
	}
	
	@GetMapping(path="/List")
	public List<Categorie> ListCategorie ()
	{
		return categorieMetier.listCategorie();
	}
	
	@DeleteMapping(path="/Delete/{id}")
	public void DeleteOneCategorie (@PathVariable("id") Long IdCateg)
	{
		
		categorieMetier.deleteCategorie(IdCateg);
	}
	

}

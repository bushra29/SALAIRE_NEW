package org.projet.SALAIRE.api;

import java.util.List;

import org.projet.SALAIRE.entity.Titre;
import org.projet.SALAIRE.metier.TitreMetier;
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
@RequestMapping(path = "/api/Titre")
public class TitreController {
@Autowired private TitreMetier titreMetier;
	

	@PostMapping(path="/Save")
	public Titre AjouterTitre(@RequestBody Titre t)
	{
		return titreMetier.addTitre(t);
	}
	
	@GetMapping(path="/Find/{id}")
	public Titre findOneTitre (@PathVariable("id") Long id)
	{
		
		return titreMetier.findTitre(id);
	}
	
	@GetMapping(path="/List")
	public List<Titre> ListTitre ()
	{
		return titreMetier.listTitre();
	}
	@DeleteMapping(path="/Delete/{id}")
	public void DeleteOneTitre (@PathVariable("id") Long IdTitre)
	{
		
		titreMetier.deleteTitre(IdTitre);
	}
	

}

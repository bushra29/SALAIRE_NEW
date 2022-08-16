package org.projet.SALAIRE.api;

import java.util.List;

import org.projet.SALAIRE.entity.Fonction;
import org.projet.SALAIRE.metier.FonctionMetier;
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
@RequestMapping(path = "/api/Fonction")
public class FonctionController {
@Autowired private FonctionMetier fonctionMetier;
	

	@PostMapping(path="/Save")
	public Fonction AjouterFonction(@RequestBody Fonction f)
	{
		return fonctionMetier.addFonction(f);
	}
	
	@GetMapping(path="/Find/{id}")
	public Fonction findOneFonction (@PathVariable("id") Long id)
	{
		
		return fonctionMetier.findFonction(id);
	}
	
	@GetMapping(path="/List")
	public List<Fonction> ListFonction ()
	{
		return fonctionMetier.listFonction();
	}

	@DeleteMapping(path="/Delete/{id}")
	public void DeleteFonction(@PathVariable("id") Long IdFonct) {
		fonctionMetier.deleteFonction(IdFonct);
	}
}

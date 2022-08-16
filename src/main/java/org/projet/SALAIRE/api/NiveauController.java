package org.projet.SALAIRE.api;

import java.util.List;

import org.projet.SALAIRE.entity.Niveau;
import org.projet.SALAIRE.metier.NiveauMetier;
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
@RequestMapping(path = "api/Niveau")
public class NiveauController {
@Autowired private NiveauMetier niveauMetier;
	
@GetMapping(path="/Generer")
public void GenererCategorie()
{
   niveauMetier.genererCategorie();
}

	@PostMapping(path="/Save")
	public Niveau AjouterNiveau(@RequestBody Niveau n)
	{
		return niveauMetier.addNiveau(n);
	}
	
	@GetMapping(path="/Find/{id}")
	public Niveau findOneNiveau (@PathVariable("id") Long id)
	{
		
		return niveauMetier.findNiveau(id);
	}
	
	@GetMapping(path="/List")
	public List<Niveau> ListNiveau ()
	{
		return niveauMetier.listNiveau();
	}
	@DeleteMapping(path="/Delete/{id}")
	public void DeleteOneNiveau (@PathVariable("id") Long IdNiveau)
	{
		
		niveauMetier.deleteNiveau(IdNiveau);
	}

}

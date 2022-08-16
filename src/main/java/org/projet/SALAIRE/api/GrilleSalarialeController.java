package org.projet.SALAIRE.api;

import java.util.List;

import org.projet.SALAIRE.entity.GrilleSalariale;
import org.projet.SALAIRE.metier.GrilleSalarialeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/GrilleSalariale")
public class GrilleSalarialeController {
@Autowired private GrilleSalarialeMetier grilleSalarialeMetier;
	

	@PostMapping(path="/Save")
	public GrilleSalariale AjouterFonction(@RequestBody GrilleSalariale g)
	{
		return grilleSalarialeMetier.addGrille(g);
	}
	@GetMapping(path="/Traiter/{id}")
	public Boolean TraitementSalaire(@PathVariable("id") Long id)
	{
		return grilleSalarialeMetier.TraiterSalaire(id);
	}

	@GetMapping(path="/Find/{id}")
	public GrilleSalariale findOneFonction (@PathVariable("id") Long id)
	{
		
		return grilleSalarialeMetier.findGrille(id);
	}
	
	@GetMapping(path="/List")
	public List<GrilleSalariale> ListGrille ()
	{
		return grilleSalarialeMetier.listGrille();
	}
}

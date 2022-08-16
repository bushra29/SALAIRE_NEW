package org.projet.SALAIRE.api;

import java.util.List;

import org.projet.SALAIRE.entity.ModeDePaiement;
import org.projet.SALAIRE.metier.ModeDePaiementMetier;
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
@RequestMapping(path = "/api/ModeDePaiement")
public class ModeDePaiementController {
@Autowired private ModeDePaiementMetier modeDePaiementMetier;
	
    @PostMapping(path="/Save")
	public ModeDePaiement AjouterFonction(@RequestBody ModeDePaiement m)
	{
		return modeDePaiementMetier.addMode(m);
	}
	
	@GetMapping(path="/Find/{id}")
	public ModeDePaiement findOneMode (@PathVariable("id") Long id)
	{
		
		return modeDePaiementMetier.findMode(id);
	}
	
	@GetMapping(path="/List")
	public List<ModeDePaiement> ListMode ()
	{
		return modeDePaiementMetier.listMode();
	}

	@DeleteMapping(path="/Delete/{id}")
	public void DeleteOneModeP (@PathVariable("id") Long IdModeP)
	{
		
		modeDePaiementMetier.deleteMode(IdModeP);
	}
}

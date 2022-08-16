package org.projet.SALAIRE.api;

import java.util.List;

import org.projet.SALAIRE.entity.Mois;
import org.projet.SALAIRE.metier.MoisMetier;
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
@RequestMapping(path = "/api/Mois")
public class MoisController {
@Autowired private MoisMetier moisMetier;
	

	@PostMapping(path="/Save")
	public Mois AjouterMois(@RequestBody Mois m)
	{
		return moisMetier.addMois(m);
	}
	
	@GetMapping(path="/Find/{id}")
	public Mois findOneMois (@PathVariable("id") Long id)
	{
		
		return moisMetier.findMois(id);
	}
	
	@GetMapping(path="/List")
	public List<Mois> ListMois ()
	{
		return moisMetier.listMois();
	}
	@DeleteMapping(path="/Delete/{id}")
	public void DeleteMois(@PathVariable("id") Long idMois)
	{
		moisMetier.deleteMois(idMois);
	}

	@GetMapping(path = "/ActiverMois/{id}")
	public Mois ActiverMois(@PathVariable("id") Long IdMois) {
		return moisMetier.activeMois(IdMois);
	}
}

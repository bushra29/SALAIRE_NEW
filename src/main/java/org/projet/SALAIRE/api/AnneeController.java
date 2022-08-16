package org.projet.SALAIRE.api;

import java.util.List;


import org.projet.SALAIRE.entity.Annee;
import org.projet.SALAIRE.metier.AnneeMetier;
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
@RequestMapping(path="/api/Annee")
public class AnneeController {
	@Autowired
	private AnneeMetier anneeMetier;


	@PostMapping(path = "/Save")
	public Annee AjouterAnnee(@RequestBody Annee a) {
		return anneeMetier.addAnnee(a);
	}

	@GetMapping(path = "/Find/{id}")
	public Annee findOneAnnee(@PathVariable("id") Long id) {

		return anneeMetier.findAnnee(id);
	}

	@GetMapping(path = "/List")
	public List<Annee> ListAnnee() {
		return anneeMetier.listAnnee();
	}

	@DeleteMapping(path = "/Delete/{id}")
	public void DeleteAnnee(@PathVariable("id") Long IdAnnee) {
		anneeMetier.deleteAnnee(IdAnnee);
	}

	@GetMapping(path = "/ActiverAnnee/{id}")
	public Annee ActiverAnnee(@PathVariable("id") Long IdAnnee) {
		return anneeMetier.activeAnnee(IdAnnee);
	}



}
